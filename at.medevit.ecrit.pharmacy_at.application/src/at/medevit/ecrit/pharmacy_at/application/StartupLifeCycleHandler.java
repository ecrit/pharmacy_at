package at.medevit.ecrit.pharmacy_at.application;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.internal.workbench.swt.E4Application;
import org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.dialog.LoginDialog;

public class StartupLifeCycleHandler {
	@Inject
	EPartService partService;
	
	@Inject
	EModelService modelService;
	
	@PostContextCreate
	private void login(IApplicationContext appContext, IEclipseContext context, Display display){
		final Shell shell = new Shell(SWT.TOOL | SWT.NO_TRIM);
		LoginDialog dialog = new LoginDialog(shell);
		
		String cssTheme = "at.medevit.ecrit.pharmacy_at.application.theme.login";
		context.set(E4Application.THEME_ID, cssTheme);
		String cssURI = "css/login.css";
		context.set(E4Workbench.CSS_URI_ARG, cssURI);
		PartRenderingEngine.initializeStyling(shell.getDisplay(), context);
		
		// close the static splash screen
		appContext.applicationRunning();
		
		if(dialog.open() != Window.OK){
			System.exit(-1);
		}
	}
}