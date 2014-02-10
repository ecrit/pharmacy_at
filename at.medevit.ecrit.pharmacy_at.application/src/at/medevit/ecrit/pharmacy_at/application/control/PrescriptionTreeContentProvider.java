package at.medevit.ecrit.pharmacy_at.application.control;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionTreeContentProvider implements ITreeContentProvider, ICheckStateProvider {
	
	Collection<Prescription> prescriptions;
	HashMap<String, Article> article;
	
	@Override
	public void dispose(){}
	
	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput){
		prescriptions = (Collection<Prescription>) newInput;
		article = new HashMap<>();
	}
	
	@Override
	public Object[] getElements(Object inputElement){
		return prescriptions.toArray();
	}
	
	@Override
	public Object[] getChildren(Object parentElement){
		if (parentElement instanceof Prescription) {
			return ((Prescription) parentElement).getArticle().toArray();
		}
		return null;
	}
	
	@Override
	public Object getParent(Object element){
		if (element instanceof Article) {
			for (Prescription p : prescriptions) {
				if (p.getArticle().contains((Article) element)) {
					return p;
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean hasChildren(Object element){
		if (element instanceof Prescription) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isChecked(Object element){
		if (element instanceof Prescription) {
			Object[] children = getChildren(element);
			for (Object object : children) {
				Article a = (Article) object;
				if (article.containsKey(a.getName())) {
					return true;
				}
			}
		} else if (element instanceof Article) {
			Article a = (Article) element;
			return article.containsKey(a.getName());
		}
		return false;
	}
	
	@Override
	public boolean isGrayed(Object element){
		// TODO Auto-generated method stub
		return false;
	}
}
