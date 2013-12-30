/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.medevit.ecrit.pharmacy_at.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "pharmacy_at/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "www.ecrit.at";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl <em>Prescription</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPrescription()
	 * @generated
	 */
	int PRESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Issuing Practitioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION__ISSUING_PRACTITIONER = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Article</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION__ARTICLE = 2;

	/**
	 * The number of structural features of the '<em>Prescription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Prescription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.ArticleImpl <em>Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ArticleImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getArticle()
	 * @generated
	 */
	int ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Admission Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__ADMISSION_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Availability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__AVAILABILITY = 3;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Has Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE___HAS_NAME__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl <em>Bill</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.BillImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getBill()
	 * @generated
	 */
	int BILL = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Article</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Prescription</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__PRESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Paid Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__PAID_AMOUNT = 3;

	/**
	 * The feature id for the '<em><b>Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__DATE_TIME = 4;

	/**
	 * The number of structural features of the '<em>Bill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Bill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockImpl <em>Stock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStock()
	 * @generated
	 */
	int STOCK = 3;

	/**
	 * The feature id for the '<em><b>Articles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK__ARTICLES = 0;

	/**
	 * The number of structural features of the '<em>Stock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl <em>Stock Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockArticle()
	 * @generated
	 */
	int STOCK_ARTICLE = 4;

	/**
	 * The feature id for the '<em><b>Article</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE__ARTICLE = 0;

	/**
	 * The feature id for the '<em><b>Number On Stock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE__NUMBER_ON_STOCK = 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE__LOWER_BOUND = 2;

	/**
	 * The number of structural features of the '<em>Stock Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Stock Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl <em>Stock Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrder()
	 * @generated
	 */
	int STOCK_ORDER = 5;

	/**
	 * The feature id for the '<em><b>Article</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER__ARTICLE = 0;

	/**
	 * The feature id for the '<em><b>Issuer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER__ISSUER = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER__NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Bound For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER__BOUND_FOR = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER__STATUS = 4;

	/**
	 * The number of structural features of the '<em>Stock Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Stock Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.DateImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__DATE = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__TIME = 1;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.ReportImpl <em>Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ReportImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getReport()
	 * @generated
	 */
	int REPORT = 7;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Issuer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__ISSUER = 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__PRIORITY = 2;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__CONCERNS = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__TEXT = 4;

	/**
	 * The number of structural features of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrderStatus()
	 * @generated
	 */
	int STOCK_ORDER_STATUS = 8;


	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.ArticleAvailability <em>Article Availability</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.ArticleAvailability
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getArticleAvailability()
	 * @generated
	 */
	int ARTICLE_AVAILABILITY = 9;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.Priority <em>Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.Priority
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 10;


	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Prescription <em>Prescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prescription</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription
	 * @generated
	 */
	EClass getPrescription();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getIssuingPractitioner <em>Issuing Practitioner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issuing Practitioner</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription#getIssuingPractitioner()
	 * @see #getPrescription()
	 * @generated
	 */
	EAttribute getPrescription_IssuingPractitioner();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription#getNumber()
	 * @see #getPrescription()
	 * @generated
	 */
	EAttribute getPrescription_Number();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription#getArticle()
	 * @see #getPrescription()
	 * @generated
	 */
	EReference getPrescription_Article();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article
	 * @generated
	 */
	EClass getArticle();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Article#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#getName()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Name();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Article#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#getDescription()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Description();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Article#getAdmissionNumber <em>Admission Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Admission Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#getAdmissionNumber()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_AdmissionNumber();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Article#getAvailability <em>Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Availability</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#getAvailability()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Availability();

	/**
	 * Returns the meta object for the '{@link at.medevit.ecrit.pharmacy_at.model.Article#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name</em>' operation.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getArticle__HasName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Bill <em>Bill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bill</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill
	 * @generated
	 */
	EClass getBill();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill#getNumber()
	 * @see #getBill()
	 * @generated
	 */
	EAttribute getBill_Number();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill#getArticle()
	 * @see #getBill()
	 * @generated
	 */
	EReference getBill_Article();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getPrescription <em>Prescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Prescription</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill#getPrescription()
	 * @see #getBill()
	 * @generated
	 */
	EReference getBill_Prescription();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getPaidAmount <em>Paid Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paid Amount</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill#getPaidAmount()
	 * @see #getBill()
	 * @generated
	 */
	EAttribute getBill_PaidAmount();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getDateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Date Time</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill#getDateTime()
	 * @see #getBill()
	 * @generated
	 */
	EReference getBill_DateTime();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Stock <em>Stock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stock</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Stock
	 * @generated
	 */
	EClass getStock();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.Stock#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Articles</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Stock#getArticles()
	 * @see #getStock()
	 * @generated
	 */
	EReference getStock_Articles();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle <em>Stock Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stock Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockArticle
	 * @generated
	 */
	EClass getStockArticle();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockArticle#getArticle()
	 * @see #getStockArticle()
	 * @generated
	 */
	EReference getStockArticle_Article();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOnStock <em>Number On Stock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number On Stock</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOnStock()
	 * @see #getStockArticle()
	 * @generated
	 */
	EAttribute getStockArticle_NumberOnStock();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockArticle#getLowerBound()
	 * @see #getStockArticle()
	 * @generated
	 */
	EAttribute getStockArticle_LowerBound();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder <em>Stock Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stock Order</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder
	 * @generated
	 */
	EClass getStockOrder();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder#getArticle()
	 * @see #getStockOrder()
	 * @generated
	 */
	EReference getStockOrder_Article();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getIssuer <em>Issuer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issuer</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder#getIssuer()
	 * @see #getStockOrder()
	 * @generated
	 */
	EAttribute getStockOrder_Issuer();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder#getNumber()
	 * @see #getStockOrder()
	 * @generated
	 */
	EAttribute getStockOrder_Number();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getBoundFor <em>Bound For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound For</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder#getBoundFor()
	 * @see #getStockOrder()
	 * @generated
	 */
	EReference getStockOrder_BoundFor();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrder#getStatus()
	 * @see #getStockOrder()
	 * @generated
	 */
	EAttribute getStockOrder_Status();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Date#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Date#getDate()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Date();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Date#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Date#getTime()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Time();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Report <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report
	 * @generated
	 */
	EClass getReport();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Report#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report#getTitle()
	 * @see #getReport()
	 * @generated
	 */
	EAttribute getReport_Title();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.Report#getIssuer <em>Issuer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Issuer</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report#getIssuer()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Issuer();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Report#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report#getPriority()
	 * @see #getReport()
	 * @generated
	 */
	EAttribute getReport_Priority();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Report#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concerns</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report#getConcerns()
	 * @see #getReport()
	 * @generated
	 */
	EAttribute getReport_Concerns();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Report#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Report#getText()
	 * @see #getReport()
	 * @generated
	 */
	EAttribute getReport_Text();

	/**
	 * Returns the meta object for enum '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Stock Order Status</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
	 * @generated
	 */
	EEnum getStockOrderStatus();

	/**
	 * Returns the meta object for enum '{@link at.medevit.ecrit.pharmacy_at.model.ArticleAvailability <em>Article Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Article Availability</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.ArticleAvailability
	 * @generated
	 */
	EEnum getArticleAvailability();

	/**
	 * Returns the meta object for enum '{@link at.medevit.ecrit.pharmacy_at.model.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Priority
	 * @generated
	 */
	EEnum getPriority();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl <em>Prescription</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPrescription()
		 * @generated
		 */
		EClass PRESCRIPTION = eINSTANCE.getPrescription();

		/**
		 * The meta object literal for the '<em><b>Issuing Practitioner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESCRIPTION__ISSUING_PRACTITIONER = eINSTANCE.getPrescription_IssuingPractitioner();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESCRIPTION__NUMBER = eINSTANCE.getPrescription_Number();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESCRIPTION__ARTICLE = eINSTANCE.getPrescription_Article();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.ArticleImpl <em>Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ArticleImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getArticle()
		 * @generated
		 */
		EClass ARTICLE = eINSTANCE.getArticle();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__NAME = eINSTANCE.getArticle_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__DESCRIPTION = eINSTANCE.getArticle_Description();

		/**
		 * The meta object literal for the '<em><b>Admission Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__ADMISSION_NUMBER = eINSTANCE.getArticle_AdmissionNumber();

		/**
		 * The meta object literal for the '<em><b>Availability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__AVAILABILITY = eINSTANCE.getArticle_Availability();

		/**
		 * The meta object literal for the '<em><b>Has Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARTICLE___HAS_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getArticle__HasName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl <em>Bill</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.BillImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getBill()
		 * @generated
		 */
		EClass BILL = eINSTANCE.getBill();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BILL__NUMBER = eINSTANCE.getBill_Number();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BILL__ARTICLE = eINSTANCE.getBill_Article();

		/**
		 * The meta object literal for the '<em><b>Prescription</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BILL__PRESCRIPTION = eINSTANCE.getBill_Prescription();

		/**
		 * The meta object literal for the '<em><b>Paid Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BILL__PAID_AMOUNT = eINSTANCE.getBill_PaidAmount();

		/**
		 * The meta object literal for the '<em><b>Date Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BILL__DATE_TIME = eINSTANCE.getBill_DateTime();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockImpl <em>Stock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStock()
		 * @generated
		 */
		EClass STOCK = eINSTANCE.getStock();

		/**
		 * The meta object literal for the '<em><b>Articles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOCK__ARTICLES = eINSTANCE.getStock_Articles();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl <em>Stock Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockArticle()
		 * @generated
		 */
		EClass STOCK_ARTICLE = eINSTANCE.getStockArticle();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOCK_ARTICLE__ARTICLE = eINSTANCE.getStockArticle_Article();

		/**
		 * The meta object literal for the '<em><b>Number On Stock</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ARTICLE__NUMBER_ON_STOCK = eINSTANCE.getStockArticle_NumberOnStock();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ARTICLE__LOWER_BOUND = eINSTANCE.getStockArticle_LowerBound();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl <em>Stock Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrder()
		 * @generated
		 */
		EClass STOCK_ORDER = eINSTANCE.getStockOrder();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOCK_ORDER__ARTICLE = eINSTANCE.getStockOrder_Article();

		/**
		 * The meta object literal for the '<em><b>Issuer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ORDER__ISSUER = eINSTANCE.getStockOrder_Issuer();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ORDER__NUMBER = eINSTANCE.getStockOrder_Number();

		/**
		 * The meta object literal for the '<em><b>Bound For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOCK_ORDER__BOUND_FOR = eINSTANCE.getStockOrder_BoundFor();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ORDER__STATUS = eINSTANCE.getStockOrder_Status();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.DateImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__DATE = eINSTANCE.getDate_Date();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__TIME = eINSTANCE.getDate_Time();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.ReportImpl <em>Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ReportImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getReport()
		 * @generated
		 */
		EClass REPORT = eINSTANCE.getReport();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPORT__TITLE = eINSTANCE.getReport_Title();

		/**
		 * The meta object literal for the '<em><b>Issuer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__ISSUER = eINSTANCE.getReport_Issuer();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPORT__PRIORITY = eINSTANCE.getReport_Priority();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPORT__CONCERNS = eINSTANCE.getReport_Concerns();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPORT__TEXT = eINSTANCE.getReport_Text();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrderStatus()
		 * @generated
		 */
		EEnum STOCK_ORDER_STATUS = eINSTANCE.getStockOrderStatus();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.ArticleAvailability <em>Article Availability</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.ArticleAvailability
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getArticleAvailability()
		 * @generated
		 */
		EEnum ARTICLE_AVAILABILITY = eINSTANCE.getArticleAvailability();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.Priority <em>Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.Priority
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPriority()
		 * @generated
		 */
		EEnum PRIORITY = eINSTANCE.getPriority();

	}

} //ModelPackage
