 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class PropertiesPart {
	@Inject
	public PropertiesPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		Label lblPropertiespart = new Label(parent, SWT.NONE);
		lblPropertiespart.setText("PropertiesPart");
		//TODO Your code here
	}
	
	
	
	
}