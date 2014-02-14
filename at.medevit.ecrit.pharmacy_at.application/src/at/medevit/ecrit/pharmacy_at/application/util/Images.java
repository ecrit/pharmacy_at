package at.medevit.ecrit.pharmacy_at.application.util;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import at.medevit.ecrit.pharmacy_at.application.part.ArticleListPart;

public class Images {
	// ArticleList Ordered-Cell images
	public static final Image GREEN = getImage("boxGreen.png");
	public static final Image YELLOW = getImage("boxYellow.png");
	public static final Image RED = getImage("boxRed.png");
	public static final Image GREY = getImage("boxGrey.png");
	
	// clerk select/deselect button
	public static final Image SELECT = getImage("select_all.png");
	public static final Image DESELECT = getImage("deselect_all.png");
	
	private static Image getImage(String file){
		Bundle bundle = FrameworkUtil.getBundle(ArticleListPart.class);
		URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		return image.createImage();
	}
}
