package at.medevit.ecrit.pharmacy_at.application.util;

import java.util.ArrayList;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class CommandUtil {
	private static IEclipseContext context;
	private static ECommandService commandService;
	private static EHandlerService handlerService;
	
	/**
	 * @deprecated for demonstration purposes
	 * @param cmd
	 *            command the parameter should be added to
	 * @param cmdParameterId
	 *            id of the commandparameter @see applicationmodel/command/commandParameter
	 * @param msgToPass
	 *            string message you'd like to pass to the handler
	 * @return a parametericed command
	 */
	private static ParameterizedCommand populateCommandWithParameters(Command cmd,
		String cmdParameterId, String msgToPass){
		ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);
		try {
			// get parameters
			IParameter iparam = cmd.getParameter(cmdParameterId);
			ArrayList<Parameterization> parameters = new ArrayList<Parameterization>();
			parameters.add(new Parameterization(iparam, msgToPass));
			
			// create parameterized command
			pCmd =
				new ParameterizedCommand(cmd, parameters.toArray(new Parameterization[parameters
					.size()]));
		} catch (NotDefinedException e) {
			e.printStackTrace();
		}
		return pCmd;
	}
	
	/**
	 * Manually performs all the neccessary steps to call the given command
	 * 
	 * @param commandId
	 * @param commandParameterId
	 * @param msgToPass
	 * @param handler
	 *            will be called in this method
	 */
	@SuppressWarnings("restriction")
	public static void manuallyCallCommand(String commandId, String commandParameterId,
		String msgToPass, Object handler){
		
		Command cmd = commandService.getCommand(commandId);
		ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);
		if (commandParameterId != null && !commandParameterId.isEmpty()) {
			if (msgToPass == null || msgToPass.isEmpty()) {
				msgToPass = "parameter";
			}
			pCmd = populateCommandWithParameters(cmd, commandParameterId, msgToPass);
		}
		
		// manually inject as all the injected values are null otherwise
		ContextInjectionFactory.inject(handler, context);
		handlerService.activateHandler(commandId, handler);
		
		// only execute if command can be executed
		if (handlerService.canExecute(pCmd)) {
			handlerService.executeHandler(pCmd);
		}
	}
	
	public static void setContextAndServices(IEclipseContext ctxt, ECommandService commandSrv,
		EHandlerService handlerSrv){
		context = ctxt;
		commandService = commandSrv;
		handlerService = handlerSrv;
	}
	
	public static <T> T getSelectionOfType(Class<T> clazz, Object selection){
		
		if (selection != null && clazz.isAssignableFrom(selection.getClass())) {
			return clazz.cast(selection);
		} else {
			return null;
		}
	}
}
