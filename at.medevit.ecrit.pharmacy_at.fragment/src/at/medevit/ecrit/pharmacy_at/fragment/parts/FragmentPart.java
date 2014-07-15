
package at.medevit.ecrit.pharmacy_at.fragment.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class FragmentPart {

	private Text txtInput;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Contributed through fragment");
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	}

	@Focus
	public void setFocus() {
		txtInput.setFocus();
	}
}