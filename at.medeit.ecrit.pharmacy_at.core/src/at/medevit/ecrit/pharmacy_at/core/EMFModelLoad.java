package at.medevit.ecrit.pharmacy_at.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Pharmacy;

public class EMFModelLoad {
	static Resource resource = null;
	
	public void save(){
		if (resource == null) {
			load();
		}
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pharmacy load(){
		// Initialize the model
		ModelPackage.eINSTANCE.eClass();
		
		// Register the XMI resource factory for the .website extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		File xmiFile = new File(loadPath());
		
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		
		// Get the resource
		resource = resSet.getResource(URI.createURI(xmiFile.toURI().toString()), true);
		// Resource resource = resSet.getResource(URI.createURI("./Pharmacy.xmi"), true);
		Pharmacy pharmacy_at = (Pharmacy) resource.getContents().get(0);
		return pharmacy_at;
	}
	
	private String loadPath(){
		URL url = EMFModelLoad.class.getResource("/rsc/pharmacy.xmi");
		try {
			url = FileLocator.toFileURL(url);
			System.out.println(url.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url.getPath();
	}
}
