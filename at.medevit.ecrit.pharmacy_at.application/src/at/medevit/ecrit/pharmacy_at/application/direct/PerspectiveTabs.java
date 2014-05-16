/**
 * Jo Grant, Senior Software Engineer
 * Admin and Config Console Architect
 * OpenPages, IBM
 * 
 * http://www.eclipse.org/forums/index.php/t/203790/
 */
package at.medevit.ecrit.pharmacy_at.application.direct;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class PerspectiveTabs {
	private MPerspectiveStack mStack;
	private TabFolder mFolder;
	
	@Inject
	IEclipseContext context;
	
	@PostConstruct
	public void createUI(Composite parent, MWindow window, EModelService service){
		mFolder = new TabFolder(parent, SWT.TOP);
		findStack(window);
		if (mStack == null)
			return;
		updateTabs();
		// called to make sure initial perspective is set in context
		doTabClick();	
		mFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				doTabClick();
			}
		});
	}
	
	private void updateTabs(){
		for (MPerspective perspective : mStack.getChildren()) {
			if (userHasAccess(perspective)) {
				
				TabItem ti = new TabItem(mFolder, SWT.NULL);
				ti.setText(perspective.getLabel());
				ti.setData("perspective", perspective);
				if (ti.getImage() == null) {
					try {
						if (perspective.getIconURI() != null)
							ti.setImage(ImageDescriptor.createFromURL(
								new URL(perspective.getIconURI())).createImage());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private boolean userHasAccess(MPerspective perspective){
		String perspectiveId = perspective.getElementId();
		List<UserRole> roles = SampleModel.getPharmacy().getCurrentUser().getRole();
		
		if (perspectiveId.equals(AppModelId.PERSPECTIVE_PERSPECTIVE_SELLER)) {
			if (roles.contains(UserRole.SELLER)) {
				return true;
			}
		} else if (perspectiveId.equals(AppModelId.PERSPECTIVE_PERSPECTIVE_STOCKIST)) {
			if (roles.contains(UserRole.STOCKIST)) {
				return true;
			}
		} else if (perspectiveId.equals(AppModelId.PERSPECTIVE_PERSPECTIVE_CLERK)) {
			if (roles.contains(UserRole.CLERK)) {
				return true;
			}
		} else if (perspectiveId.equals(AppModelId.PERSPECTIVE_PERSPECTIVE_ADMIN)) {
			if (roles.contains(UserRole.SYSADMIN)) {
				return true;
			}
		}
		return false;
	}
	
	private void doTabClick(){
		TabItem ti = mFolder.getSelection()[0];
		MPerspective perspective = (MPerspective) ti.getData("perspective");
		mStack.setSelectedElement(perspective);
		//essential for core expressions
		context.set("activePerspective", perspective.getElementId());
		System.out.println(perspective.getElementId());
	}
	
	private void findStack(MWindow window){
		for (MWindowElement elem : window.getChildren())
			if (elem instanceof MPerspectiveStack) {
				mStack = (MPerspectiveStack) elem;
				return;
			}
	}
}
