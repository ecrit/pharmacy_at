package at.medevit.ecrit.pharmacy_at.application.control;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionTreeLabelProvider extends ColumnLabelProvider implements
		ITableLabelProvider {
	
	public PrescriptionTreeLabelProvider(){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getText(Object element){
		if (element instanceof Prescription) {
			return ((Prescription) element).getNumber() + "";
		} else if (element instanceof Article) {
			return ((Article) element).getName();
		}
		return "?";
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex){
		switch (columnIndex) {
		case 0:
		case 1:
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
		case 1: // issuer
			if (element instanceof Prescription) {
				Prescription p = (Prescription) element;
				if (p.getIssuingPractitioner() == null || p.getIssuingPractitioner().isEmpty()) {
					return "?";
				}
				return p.getIssuingPractitioner();
			} else {
				return "";
			}
		case 2: // price
			if (element instanceof Article) {
				Article a = (Article) element;
				if (a.getPrice() < 0)
					return "";
				return a.getPrice() + " €";
			} else {
				Prescription p = (Prescription) element;
				float totalPrice = 0.0f;
				for (Article a : p.getArticle()) {
					totalPrice = totalPrice + a.getPrice();
				}
				return totalPrice + " €";
			}
		default:
			return "";
		}
	}
}
