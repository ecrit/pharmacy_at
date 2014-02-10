package at.medevit.ecrit.pharmacy_at.application.control;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import at.medevit.ecrit.pharmacy_at.application.converter.DateToStringConverter;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;

public class InvoiceTreeLabelProvider extends ColumnLabelProvider implements ITableLabelProvider {
	private final Image MEDICINE = getArticleImage("pill.png");
	
	public InvoiceTreeLabelProvider(){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getText(Object element){
		if (element instanceof Invoice) {
			return ((Invoice) element).getId() + "";
		} else if (element instanceof Article) {
			return ((Article) element).getName();
		}
		return "?";
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex){
		switch (columnIndex) {
		case 0:
			if (element instanceof Article)
				return MEDICINE;
		case 2:
		case 3:
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex){
		switch (columnIndex) {
		case 0: // name
			return getText(element);
		case 1: // price
			if (element instanceof Article) {
				Article a = (Article) element;
				if (a.getPrice() < 0)
					return "";
				return a.getPrice() + " €";
			} else {
				Invoice i = (Invoice) element;
				float totalPrice = 0.0f;
				for (Article a : i.getArticle()) {
					totalPrice = totalPrice + a.getPrice();
				}
				return totalPrice + " €";
			}
		case 2: // date
			if (element instanceof Invoice) {
				Invoice i = (Invoice) element;
				DateToStringConverter dtsConverter = new DateToStringConverter();
				return (String) dtsConverter.convert(i.getDate());
			}
		default:
			return "";
		}
	}
	
	private static Image getArticleImage(String file){
		Bundle bundle = FrameworkUtil.getBundle(InvoiceTreeLabelProvider.class);
		URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		return image.createImage();
	}
}
