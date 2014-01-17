package at.medevit.ecrit.pharmacy_at.application;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "at.medevit.ecrit.pharmacy_at.application.messages"; 

	public static String ID_POPUP_ARTICLELIST;
	public static String ID_POPUP_PRESCRIPTION;
	public static String ID_POPUP_INVOICE_DATA;
	
	public static String ID_CMD_ADD_PRESCRIPTION;
	public static String ID_CMD_ADD_TO_PRESCRIPTION;
	public static String ID_CMD_OPEN_PRESCRIPTION;
	public static String ID_CMD_EDIT_PRESCRIPTION;
	public static String ID_CMD_DELETE_PRESCRIPTION;
	
	public static String ID_CMD_SAVE_INVOICE;
	public static String ID_CMD_ADD_TO_INVOICE;
	public static String ID_CMD_DELETE_FROM_INVOICE;
	public static String ID_CMD_CANCEL_INVOICE;
	
	public static String ID_PART_ARTICLELIST;
	public static String ID_PART_PROPERTIES;
	public static String ID_PART_INVOICE_DATA;
	public static String ID_PART_PRESCRIPTION;
	public static String ID_PART_INVOICE;
	public static String ID_PART_USER;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	private Messages(){}
}
