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
	public static final Image GREEN = getImage("boxGreen_tbl.png");
	public static final Image YELLOW = getImage("boxYellow_tbl.png");
	public static final Image RED = getImage("boxRed_tbl.png");
	public static final Image GREY = getImage("boxGrey_tbl.png");
	
	// clerk part button
	public static final Image SELECT = getImage("select_all.png");
	public static final Image DESELECT = getImage("deselect_all.png");
	public static final Image INVOICE = getImage("invoice.png");
	
	public static final Image FILTER = getImage("filter.png");
	public static final Image CRITICAL = getImage("critical.png");
	
	public static final Image MEDICINE = getImage("pill.png");
	
	private static Image getImage(String file){
		Bundle bundle = FrameworkUtil.getBundle(ArticleListPart.class);
		URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		return image.createImage();
	}
}
