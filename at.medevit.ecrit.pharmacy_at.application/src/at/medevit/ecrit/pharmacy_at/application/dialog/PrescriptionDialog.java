package at.medevit.ecrit.pharmacy_at.application.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionDialog extends TitleAreaDialog {
	private List<Article> articles;
	private List<Article> selArticles;
	private Prescription p; 
	private Text txtPrescriptionNr;
	private Text txtIssuingPractitioner;
	private TableViewer tableViewer;

	private EPartService partService;

	public PrescriptionDialog(Shell parentShell, List<Article> articles) {
		super(parentShell);
		this.articles = articles;
		this.selArticles = new ArrayList<Article>();
	}

	@Override
	public void create() {
		super.create();
		setTitle("Custom Prescription Dialog");
		setMessage("Fill in prescription stuff", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);

		createPrescriptionNrPart(container);
		createIssuingPractitionerPart(container);
//		createArticleReviewPart(container);
		createArticleSelectionPart(container);
		
		return area;
	}

	private void createPrescriptionNrPart(Composite container) {
		Label lblPrescriptionNr = new Label(container, SWT.NONE);
		lblPrescriptionNr.setText("Prescription Number");

		GridData dataPrescriptionNr = new GridData();
		dataPrescriptionNr.grabExcessHorizontalSpace = true;
		dataPrescriptionNr.horizontalAlignment = GridData.FILL;

		txtPrescriptionNr = new Text(container, SWT.BORDER);
		txtPrescriptionNr.setLayoutData(dataPrescriptionNr);
	}

	private void createIssuingPractitionerPart(Composite container) {
		Label lblIssuingPractitioner = new Label(container, SWT.NONE);
		lblIssuingPractitioner.setText("Issuing Practitioner");

		GridData dataIssuingPractitioner = new GridData();
		dataIssuingPractitioner.grabExcessHorizontalSpace = true;
		dataIssuingPractitioner.horizontalAlignment = GridData.FILL;

		txtIssuingPractitioner = new Text(container, SWT.BORDER);
		txtIssuingPractitioner.setLayoutData(dataIssuingPractitioner);

	}

	private void createArticleSelectionPart(Composite container){
		Label lblArticles = new Label(container, SWT.NONE);
		lblArticles.setText("Prescription Articles");

		tableViewer = new TableViewer(container, SWT.CHECK|SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					Article a = (Article) event.item.getData();

					if (selArticles.contains(a)) {
						selArticles.remove(a);
					} else {
						selArticles.add(a);
					}

				}
			}
		});
		
		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		// set the column title & size
		tvc.getColumn().setText("Article Name");
		tvc.getColumn().setWidth(200);
		tvc.getColumn().setResizable(false);
		
		for (Article a : articles) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(a.getName());
		}
	}
	
	private void createArticleReviewPart(Composite container) {
		Label lblArticles = new Label(container, SWT.NONE);
		lblArticles.setText("Prescription Articles");

		tableViewer = new TableViewer(container, SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		table.setEnabled(false);

		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		// set the column title & size
		tvc.getColumn().setText("Article Name");
		tvc.getColumn().setWidth(200);
		tvc.getColumn().setResizable(false);
		
		for (Article a : articles) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(a.getName());
		}
		
	}

	@Override
	protected void okPressed() {
		p.setNumber(Integer.parseInt(txtPrescriptionNr.getText()));
		p.setIssuingPractitioner(txtIssuingPractitioner.getText());

		for (Article a : articles) {
			p.getArticle().add(a);
		}		
		super.okPressed();
	}

	public void setConcernedArticles(List<Article> articles) {
		this.articles = articles;
		tableViewer.refresh();
	}
	
	public void setPrescription(Prescription p) {
		this.p = p;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

}
