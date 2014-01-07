package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebParam.Mode;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Customer;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionPart {

	private TableViewer tableViewer;
	private IObservableList input;

	@Inject
	private EMenuService menuService;
	private static final String ID_ADD_PRESCRIPTION = "at.medevit.ecrit.pharmacy_at.application.popupmenu.addPrescritption";

	@Inject
	public PrescriptionPart() {
		// TODO Your code here
	}

	@SuppressWarnings("restriction")
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label lblPrescriptionpart = new Label(parent, SWT.NONE);
		lblPrescriptionpart.setText("PrescriptionPart");

		initTableViewer(parent);
		menuService.registerContextMenu(tableViewer.getTable(),
				ID_ADD_PRESCRIPTION);
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		input = Properties.selfList(Article.class).observe(
				createPrescriptions());
		tableViewer.setContentProvider(cp);

		// set model
		tableViewer.setInput(input);
	}

	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Number", "Practitioner" };
		EAttribute[] columnAttributes = new EAttribute[] {
				ModelPackage.Literals.PRESCRIPTION__NUMBER,
				ModelPackage.Literals.PRESCRIPTION__ISSUING_PRACTITIONER };
		int[] columnWidths = new int[] { 100, 150 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
			
			IObservableMap map = EMFProperties.value(columnAttributes[i]).observeDetail(cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}
		
		//FIXME make this work (articles are not shown till now!
//		FeaturePath path = FeaturePath.fromList(
//				ModelPackage.Literals.ARTICLE__NAME,
//				ModelPackage.Literals.PRESCRIPTION__ARTICLE);
//
//		// bind the feature and setup a table column
//		IObservableMap featureMap = EMFProperties.value(path).observeDetail(
//				cp.getKnownElements());
//		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
//		tvc.setLabelProvider(new ObservableMapCellLabelProvider(featureMap));
//		tvc.getColumn().setText("Article");
//		tvc.getColumn().setWidth(150);
	}

	private List<Prescription> createPrescriptions() {
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		ModelFactory factory = ModelFactory.eINSTANCE;

		String[] issuingPractitioner = new String[] { "Dr.Seltsam", "Dr.Doe",
				"Dr.Pain" };
		int[] number = new int[] { 1234456, 2341234, 9872340 };
		Customer c1 = factory.createCustomer();
		c1.setName("Sputnik Unkaputtbar");

		Article a1 = factory.createArticle();
		a1.setName("MexaVit");
		Article a2 = factory.createArticle();
		a2.setName("Lemocin");
		Article a3 = factory.createArticle();
		a3.setName("Aspirin");

		Prescription p = factory.createPrescription();
		p.setIssuingPractitioner(issuingPractitioner[0]);
		p.setNumber(number[0]);
		p.setPrescriptionCustomer(c1);
		p.getArticle().add(a3);
		p.getArticle().add(a2);
		p.getArticle().add(a1);

		prescriptionList.add(p);

		return prescriptionList;
	}

	public void addPrescription(Prescription p) {
		input.add(p);
		tableViewer.refresh();
	}
}