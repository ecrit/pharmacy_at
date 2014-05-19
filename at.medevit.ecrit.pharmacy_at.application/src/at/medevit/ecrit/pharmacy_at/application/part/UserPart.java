package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.ApplicationPackage;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.handler.admin.DeleteUserHandler;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class UserPart implements IPart {
	private TableViewer tableViewer;
	private List<User> staff;
	
	@Inject
	private IEclipseContext context;
	@Inject
	private EMenuService menuService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	@Inject
	private ESelectionService selectionService;
	
	@Inject
	public UserPart(){
		staff = SampleModel.getPharmacy().getStaff();
	}
	
	@PostConstruct
	public void postConstruct(final Composite parent){
		// sent to selUser for a new user entry
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Group uManagementGroup = new Group(composite, SWT.NONE);
		uManagementGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		GridLayout gl_manageUser = new GridLayout(1, false);
		gl_manageUser.marginLeft = 10;
		gl_manageUser.marginRight = 10;
		uManagementGroup.setLayout(gl_manageUser);
		uManagementGroup.setText("User Management");
		
		Label lblNewUserHint = new Label(uManagementGroup, SWT.NONE);
		lblNewUserHint.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblNewUserHint.setText("In order to create a new user, press the 'New User' Button below "
			+ "and fill in the required data in the 'UserData' part on the right hand side.");
		
		Button btnNew = new Button(uManagementGroup, SWT.PUSH);
		GridData gd_btnNew = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_btnNew.widthHint = 80;
		btnNew.setLayoutData(gd_btnNew);
		btnNew.setText("New User");
		btnNew.addSelectionListener(new SelectionAdapter() {
			// send emptyUser to selUser for a new user entry
			@Override
			public void widgetSelected(SelectionEvent e){
				selectionService.setSelection(SampleModel.getPlainNewUser());
			}
		});
		
		new Label(uManagementGroup, SWT.NONE);
		
		// Users
		Group uChooseGroup = new Group(composite, SWT.NONE);
		uChooseGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_chooseUser = new GridLayout(2, false);
		gl_chooseUser.marginLeft = 10;
		gl_chooseUser.marginRight = 10;
		uChooseGroup.setLayout(gl_chooseUser);
		uChooseGroup.setText("Choose User");
		
		initTableViewer(uChooseGroup);
		
		// indent
		new Label(uChooseGroup, SWT.NONE);
		
		// Delete User button
		
		Button btnDelete = new Button(uChooseGroup, SWT.PUSH);
		GridData gd_btnDelete = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnDelete.widthHint = 80;
		btnDelete.setLayoutData(gd_btnDelete);
		btnDelete.setText("Delete User");
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e){
				if (tableViewer.getSelection() == null) {
					MessageDialog.openInformation(parent.getShell(), "Info", "No user selected");
				} else {
					IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();
					User selectedUser = (User) sel.getFirstElement();
					if (MessageDialog.openConfirm(
						parent.getShell(),
						"Delete User",
						"Are you sure you want to delete the selected user?\n"
							+ selectedUser.getName()
							+ "\n The correponding user data will be lost!")) {
						
						CommandUtil.setContextAndServices(context, commandService, handlerService);
						CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_DELETEUSER,
							"commandparameter.deleteUser", "user to delete",
							new DeleteUserHandler());
						
						selectionService.setSelection(SampleModel.getPlainNewUser());
						updatePart();
					}
				}
			}
		});
		menuService
			.registerContextMenu(tableViewer.getTable(), AppModelId.POPUPMENU_POPUPMENU_USER);
	}
	
	private void initTableViewer(Composite composite){
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);
		
		ObservableListContentProvider cp = new ObservableListContentProvider();
		
		// init column
		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap userNameMap =
			EMFProperties.value(ApplicationPackage.Literals.USER__NAME).observeDetail(
				cp.getKnownElements());
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(userNameMap));
		TableColumn colUserName = tvc.getColumn();
		colUserName.setWidth(100);
		
		tableViewer.setContentProvider(cp);
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				selectionService.setSelection((User) selection.getFirstElement());
			}
		});
		
		// set model
		IObservableList input = Properties.selfList(User.class).observe(staff);
		tableViewer.setInput(input);
	}
	
	@Override
	public void updatePart(){
		if (tableViewer != null) {
			staff = SampleModel.getPharmacy().getStaff();
			tableViewer.refresh();
		}
	}
}