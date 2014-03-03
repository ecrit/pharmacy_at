package at.medevit.ecrit.pharmacy_at.application.handler;

import org.eclipse.e4.core.di.annotations.Execute;

import at.medevit.ecrit.pharmacy_at.application.util.PrintInventoryPDF;

public class PrintInventoryHandler {
	@Execute
	public void execute(){
		new PrintInventoryPDF();
	}
	
}