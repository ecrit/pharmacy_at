package at.medevit.ecrit.pharmacy_at.fragment.toolcontrol;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ToolControl {
	
	@PostConstruct
	public void createGui(Composite comp) {
		Label lab = new Label(comp, SWT.TOP);
		lab.setText("You just added the fragment!");
	}
}