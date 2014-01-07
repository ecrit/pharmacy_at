 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InvoicePart {
	@Inject
	public InvoicePart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(1, false));
		
		Label lblInvoicepart = new Label(composite, SWT.NONE);
		lblInvoicepart.setText("Invoice");
		
		Text txtInvoice = new Text(composite, SWT.NONE);
		txtInvoice.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		txtInvoice.setText("At this place..."
				+ " the invoice will be placed soon....");
		txtInvoice.setEnabled(false);
		
		
	}
}