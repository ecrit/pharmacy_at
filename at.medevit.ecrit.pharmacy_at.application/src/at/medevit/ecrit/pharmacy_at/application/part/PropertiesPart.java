 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PropertiesPart {
	@Inject
	public PropertiesPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));
		
		Label lblPropertiespart = new Label(composite, SWT.NONE);
		lblPropertiespart.setText("Properties");
		new Label(composite, SWT.NONE);
		
		//description
		Label lblDescription = new Label(composite, SWT.NONE);
		lblDescription.setText("Description: ");
		
		Text txtDescription = new Text(composite, SWT.BORDER);
		txtDescription.setText("not implemented yet");
	}
}