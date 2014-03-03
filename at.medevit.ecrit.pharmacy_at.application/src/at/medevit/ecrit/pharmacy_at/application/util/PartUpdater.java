package at.medevit.ecrit.pharmacy_at.application.util;

import java.util.HashMap;
import java.util.List;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import at.medevit.ecrit.pharmacy_at.application.part.IPart;

public class PartUpdater {
	private static EPartService partService;
	private static HashMap<String, IPart> idPartMap = new HashMap<String, IPart>();
	
	public static void updatePart(EPartService partSrv, List<String> partIds){
		partService = partSrv;
		
		for (String id : partIds) {
			IPart part = idPartMap.get(id);
			if (part == null) {
				part = (IPart) getPartObject(id);
				idPartMap.put(id, part);
			}
			part.updatePart();
		}
	}
	
	private static Object getPartObject(String id){
		MPart part = partService.findPart(id);
		return part.getObject();
	}
	
	public static IPart findPart(String id){
		return idPartMap.get(id);
	}
}
