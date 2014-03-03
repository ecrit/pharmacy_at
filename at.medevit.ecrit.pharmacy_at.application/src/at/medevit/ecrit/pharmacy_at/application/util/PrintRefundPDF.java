package at.medevit.ecrit.pharmacy_at.application.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Pharmacy;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PrintRefundPDF {
	private static String FILE = "C:/Users/Lucia/Desktop/RefundForm.pdf";
	private static Font smallBold = new Font(Font.HELVETICA, 12, Font.BOLD);
	private static Font tinyBold = new Font(Font.HELVETICA, 11, Font.BOLD);
	private static Font tableHeaderFont = new Font(Font.HELVETICA, 11, Font.BOLD, Color.GRAY);
	
	private static java.util.List<Object> items;
	private static float total;
	
	public PrintRefundPDF(Shell shell, java.util.List<Object> checked){
		try {
			this.items = checked;
			this.total = 0.0f;
			
			DirectoryDialog dirDialog = new DirectoryDialog(shell);
			dirDialog.setFilterPath("c:\\");
			dirDialog.setText("Select a directory to save the refund");
			FILE = dirDialog.open() + "/RefundForm.pdf";
			
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addAddressHeader(document);
			addContent(document);
			document.close();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void addMetaData(Document document){
		document.addAuthor(System.getProperty("user.name"));
		document.addCreationDate();
		document.addProducer();
		document.addCreator(SampleModel.getPharmacy().getName());
		document.addTitle("Prescription Refund Invoice");
	}
	
	private static void addAddressHeader(Document document) throws DocumentException,
		MalformedURLException, IOException{
		Paragraph preface = new Paragraph();
		
		URL url = PrintRefundPDF.class.getResource("/icons/ecrit_logo.png");
		Image companyLogo = Image.getInstance(FileLocator.toFileURL(url));
		companyLogo.setAbsolutePosition(25, 730);
		companyLogo.scalePercent(20);
		preface.add(companyLogo);
		
		// Will create: Report generated by: _name, _date
		Pharmacy pharmacy = SampleModel.getPharmacy();
		Paragraph pharmacyName = new Paragraph(pharmacy.getName(), smallBold);
		pharmacyName.setAlignment(Element.ALIGN_RIGHT);
		preface.add(pharmacyName);
		
		Paragraph adrStreet = new Paragraph(pharmacy.getAddress().getStreet(), tinyBold);
		adrStreet.setAlignment(Element.ALIGN_RIGHT);
		preface.add(adrStreet);
		
		Paragraph adrPostCodeCity =
			new Paragraph(pharmacy.getAddress().getPostCode() + " "
				+ pharmacy.getAddress().getTown(), tinyBold);
		adrPostCodeCity.setAlignment(Element.ALIGN_RIGHT);
		preface.add(adrPostCodeCity);
		
		Paragraph adrCountry = new Paragraph(pharmacy.getAddress().getCountry(), tinyBold);
		adrCountry.setAlignment(Element.ALIGN_RIGHT);
		preface.add(adrCountry);
		
		addEmptyLine(preface, 1);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Paragraph invoiceDate = new Paragraph("Invoice Date: " + dateFormat.format(date), tinyBold);
		invoiceDate.setAlignment(Element.ALIGN_RIGHT);
		preface.add(invoiceDate);
		addEmptyLine(preface, 3);
		
		document.add(preface);
	}
	
	private static void addContent(Document document) throws DocumentException{
		Paragraph invParagraph = new Paragraph();
		createTable(invParagraph);
		
		document.add(invParagraph);
	}
	
	private static void createTable(Paragraph paragraph) throws DocumentException{
		PdfPTable table = new PdfPTable(4);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new int[] {
			50, 150, 300, 80
		});
		
		PdfPCell c1 = new PdfPCell(new Phrase("Nr", tableHeaderFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Practitioner", tableHeaderFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Article", tableHeaderFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Price", tableHeaderFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
		
		String nr = "Unknown";
		String practitioner = "Unknown";
		for (Object item : items) {
			if (item instanceof Prescription) {
				Prescription p = (Prescription) item;
				nr = p.getNumber() + "";
				practitioner = p.getIssuingPractitioner();
			} else {
				Article a = (Article) item;
				table.addCell(nr);
				table.addCell(practitioner);
				table.addCell(a.getName());
				table.addCell(a.getPrice() + " €");
				total += a.getPrice();
			}
		}
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell(" ");
		
		table.addCell("");
		table.addCell("");
		table.addCell("");
		PdfPCell sum = new PdfPCell(new Phrase(String.format("%.2f", total) + " €", smallBold));
		table.addCell(sum);
		
		paragraph.add(table);
		
	}
	
	private static void addEmptyLine(Paragraph paragraph, int number){
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
}