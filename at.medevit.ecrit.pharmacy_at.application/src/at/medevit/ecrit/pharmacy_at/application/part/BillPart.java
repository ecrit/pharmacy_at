 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class BillPart {
	@Inject
	public BillPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		Label lblBillpart = new Label(parent, SWT.NONE);
		lblBillpart.setText("BillPart");
		//TODO Your code here
	}
	
	
	
	
}