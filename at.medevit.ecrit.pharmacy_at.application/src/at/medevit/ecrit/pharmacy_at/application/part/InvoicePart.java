 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class InvoicePart {
	@Inject
	public InvoicePart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		Label lblInvoicepart = new Label(parent, SWT.NONE);
		lblInvoicepart.setText("InvoicePart");
		//TODO Your code here
	}
	
	
	
	
}