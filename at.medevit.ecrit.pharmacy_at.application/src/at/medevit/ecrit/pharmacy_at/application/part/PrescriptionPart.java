 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class PrescriptionPart {
	@Inject
	public PrescriptionPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		Label lblPrescriptionpart = new Label(parent, SWT.NONE);
		lblPrescriptionpart.setText("PrescriptionPart");
		//TODO Your code here
	}
	
	
	
	
}