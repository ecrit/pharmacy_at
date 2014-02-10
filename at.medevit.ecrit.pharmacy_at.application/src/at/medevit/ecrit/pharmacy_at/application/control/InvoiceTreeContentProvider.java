package at.medevit.ecrit.pharmacy_at.application.control;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;

public class InvoiceTreeContentProvider implements ITreeContentProvider {
	
	Collection<Invoice> invoices;
	
	HashMap<String, Article> article;
	
	@Override
	public void dispose(){}
	
	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput){
		invoices = (Collection<Invoice>) newInput;
		article = new HashMap<>();
	}
	
	@Override
	public Object[] getElements(Object inputElement){
		return invoices.toArray();
	}
	
	@Override
	public Object[] getChildren(Object parentElement){
		if (parentElement instanceof Invoice) {
			return ((Invoice) parentElement).getArticle().toArray();
		}
		return null;
	}
	
	@Override
	public Object getParent(Object element){
		if (element instanceof Invoice) {
			return (Invoice) element;
		}
		return null;
	}
	
	@Override
	public boolean hasChildren(Object element){
		if (element instanceof Invoice) {
			return true;
		}
		return false;
	}
}
