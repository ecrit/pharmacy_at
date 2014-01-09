 
package at.medevit.ecrit.pharmacy_at.application.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class UserPart {
	@Inject
	public UserPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		//TODO Your code here
		Label lblUser = new Label(parent, SWT.NONE);
		lblUser.setText("User");
	}
	
	
	
	
}