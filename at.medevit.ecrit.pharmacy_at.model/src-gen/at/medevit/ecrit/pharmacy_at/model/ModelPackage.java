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
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl <em>Pharmacy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPharmacy()
	 * @generated
	 */
	int PHARMACY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Stock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__STOCK = 2;

	/**
	 * The feature id for the '<em><b>Invoices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__INVOICES = 3;

	/**
	 * The feature id for the '<em><b>Reports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__REPORTS = 4;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__CUSTOMERS = 5;

	/**
	 * The feature id for the '<em><b>Stock Orders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__STOCK_ORDERS = 6;

	/**
	 * The feature id for the '<em><b>Line Items</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY__LINE_ITEMS = 7;

	/**
	 * The number of structural features of the '<em>Pharmacy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Pharmacy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHARMACY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl <em>Prescription</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPrescription()
	 * @generated
	 */
	int PRESCRIPTION = 1;

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
	 * The feature id for the '<em><b>Article</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION__ARTICLE = 2;

	/**
	 * The feature id for the '<em><b>Prescription Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION__PRESCRIPTION_CUSTOMER = 3;

	/**
	 * The number of structural features of the '<em>Prescription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESCRIPTION_FEATURE_COUNT = 4;

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
	int ARTICLE = 2;

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
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__PRICE = 4;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl <em>Invoice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getInvoice()
	 * @generated
	 */
	int INVOICE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__ID = 0;

	/**
	 * The feature id for the '<em><b>Article</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Prescription</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__PRESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Paid Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__PAID_AMOUNT = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__DATE = 4;

	/**
	 * The feature id for the '<em><b>Invoice Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE__INVOICE_CUSTOMER = 5;

	/**
	 * The number of structural features of the '<em>Invoice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Invoice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.StockImpl <em>Stock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.StockImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStock()
	 * @generated
	 */
	int STOCK = 4;

	/**
	 * The feature id for the '<em><b>Articles</b></em>' containment reference list.
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
	int STOCK_ARTICLE = 5;

	/**
	 * The feature id for the '<em><b>Article</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Number Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE__NUMBER_ORDERED = 3;

	/**
	 * The number of structural features of the '<em>Stock Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ARTICLE_FEATURE_COUNT = 4;

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
	int STOCK_ORDER = 6;

	/**
	 * The feature id for the '<em><b>Article</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Bound For</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Issuer</b></em>' containment reference.
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
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.AddressImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getAddress()
	 * @generated
	 */
	int ADDRESS = 8;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__STREET = 0;

	/**
	 * The feature id for the '<em><b>Post Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__POST_CODE = 1;

	/**
	 * The feature id for the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__TOWN = 2;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__COUNTRY = 3;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.CustomerImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 9;

	/**
	 * The feature id for the '<em><b>Insurance Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__INSURANCE_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PHONE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ADDRESS = 3;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.LineItemsImpl <em>Line Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.LineItemsImpl
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getLineItems()
	 * @generated
	 */
	int LINE_ITEMS = 10;

	/**
	 * The feature id for the '<em><b>Article</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_ITEMS__ARTICLE = 0;

	/**
	 * The number of structural features of the '<em>Line Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_ITEMS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Line Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_ITEMS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrderStatus()
	 * @generated
	 */
	int STOCK_ORDER_STATUS = 11;


	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.ArticleAvailability <em>Article Availability</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.ArticleAvailability
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getArticleAvailability()
	 * @generated
	 */
	int ARTICLE_AVAILABILITY = 12;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.Priority <em>Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.Priority
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 13;


	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy <em>Pharmacy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pharmacy</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy
	 * @generated
	 */
	EClass getPharmacy();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getName()
	 * @see #getPharmacy()
	 * @generated
	 */
	EAttribute getPharmacy_Name();

	/**
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getAddress()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_Address();

	/**
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStock <em>Stock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stock</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStock()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_Stock();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getInvoices <em>Invoices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invoices</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getInvoices()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_Invoices();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getReports <em>Reports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reports</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getReports()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_Reports();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getCustomers()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStockOrders <em>Stock Orders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stock Orders</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStockOrders()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_StockOrders();

	/**
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getLineItems <em>Line Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Line Items</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Pharmacy#getLineItems()
	 * @see #getPharmacy()
	 * @generated
	 */
	EReference getPharmacy_LineItems();

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
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription#getArticle()
	 * @see #getPrescription()
	 * @generated
	 */
	EReference getPrescription_Article();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getPrescriptionCustomer <em>Prescription Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prescription Customer</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Prescription#getPrescriptionCustomer()
	 * @see #getPrescription()
	 * @generated
	 */
	EReference getPrescription_PrescriptionCustomer();

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
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Article#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Article#getPrice()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Price();

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
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Invoice <em>Invoice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoice</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice
	 * @generated
	 */
	EClass getInvoice();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getId()
	 * @see #getInvoice()
	 * @generated
	 */
	EAttribute getInvoice_Id();

	/**
	 * Returns the meta object for the reference list '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getArticle()
	 * @see #getInvoice()
	 * @generated
	 */
	EReference getInvoice_Article();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getPrescription <em>Prescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prescription</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getPrescription()
	 * @see #getInvoice()
	 * @generated
	 */
	EReference getInvoice_Prescription();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getPaidAmount <em>Paid Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paid Amount</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getPaidAmount()
	 * @see #getInvoice()
	 * @generated
	 */
	EAttribute getInvoice_PaidAmount();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getDate()
	 * @see #getInvoice()
	 * @generated
	 */
	EAttribute getInvoice_Date();

	/**
	 * Returns the meta object for the reference '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getInvoiceCustomer <em>Invoice Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invoice Customer</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Invoice#getInvoiceCustomer()
	 * @see #getInvoice()
	 * @generated
	 */
	EReference getInvoice_InvoiceCustomer();

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
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Stock#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Articles</em>'.
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
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Article</em>'.
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
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOrdered <em>Number Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Ordered</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOrdered()
	 * @see #getStockArticle()
	 * @generated
	 */
	EAttribute getStockArticle_NumberOrdered();

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
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Article</em>'.
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
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getBoundFor <em>Bound For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bound For</em>'.
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
	 * Returns the meta object for the containment reference '{@link at.medevit.ecrit.pharmacy_at.model.Report#getIssuer <em>Issuer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Issuer</em>'.
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
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Address
	 * @generated
	 */
	EClass getAddress();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Address#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Address#getStreet()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Street();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Address#getPostCode <em>Post Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Code</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Address#getPostCode()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_PostCode();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Address#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Town</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Address#getTown()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Town();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Address#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Address#getCountry()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Country();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Customer#getInsuranceNumber <em>Insurance Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Customer#getInsuranceNumber()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_InsuranceNumber();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Customer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Customer#getName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Name();

	/**
	 * Returns the meta object for the attribute '{@link at.medevit.ecrit.pharmacy_at.model.Customer#getPhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone Number</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Customer#getPhoneNumber()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_PhoneNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.Customer#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Customer#getAddress()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Address();

	/**
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.LineItems <em>Line Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Items</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.LineItems
	 * @generated
	 */
	EClass getLineItems();

	/**
	 * Returns the meta object for the containment reference list '{@link at.medevit.ecrit.pharmacy_at.model.LineItems#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Article</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.LineItems#getArticle()
	 * @see #getLineItems()
	 * @generated
	 */
	EReference getLineItems_Article();

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
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl <em>Pharmacy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getPharmacy()
		 * @generated
		 */
		EClass PHARMACY = eINSTANCE.getPharmacy();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHARMACY__NAME = eINSTANCE.getPharmacy_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__ADDRESS = eINSTANCE.getPharmacy_Address();

		/**
		 * The meta object literal for the '<em><b>Stock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__STOCK = eINSTANCE.getPharmacy_Stock();

		/**
		 * The meta object literal for the '<em><b>Invoices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__INVOICES = eINSTANCE.getPharmacy_Invoices();

		/**
		 * The meta object literal for the '<em><b>Reports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__REPORTS = eINSTANCE.getPharmacy_Reports();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__CUSTOMERS = eINSTANCE.getPharmacy_Customers();

		/**
		 * The meta object literal for the '<em><b>Stock Orders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__STOCK_ORDERS = eINSTANCE.getPharmacy_StockOrders();

		/**
		 * The meta object literal for the '<em><b>Line Items</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHARMACY__LINE_ITEMS = eINSTANCE.getPharmacy_LineItems();

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
		 * The meta object literal for the '<em><b>Article</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESCRIPTION__ARTICLE = eINSTANCE.getPrescription_Article();

		/**
		 * The meta object literal for the '<em><b>Prescription Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESCRIPTION__PRESCRIPTION_CUSTOMER = eINSTANCE.getPrescription_PrescriptionCustomer();

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
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__PRICE = eINSTANCE.getArticle_Price();

		/**
		 * The meta object literal for the '<em><b>Has Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARTICLE___HAS_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getArticle__HasName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl <em>Invoice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getInvoice()
		 * @generated
		 */
		EClass INVOICE = eINSTANCE.getInvoice();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOICE__ID = eINSTANCE.getInvoice_Id();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOICE__ARTICLE = eINSTANCE.getInvoice_Article();

		/**
		 * The meta object literal for the '<em><b>Prescription</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOICE__PRESCRIPTION = eINSTANCE.getInvoice_Prescription();

		/**
		 * The meta object literal for the '<em><b>Paid Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOICE__PAID_AMOUNT = eINSTANCE.getInvoice_PaidAmount();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOICE__DATE = eINSTANCE.getInvoice_Date();

		/**
		 * The meta object literal for the '<em><b>Invoice Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOICE__INVOICE_CUSTOMER = eINSTANCE.getInvoice_InvoiceCustomer();

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
		 * The meta object literal for the '<em><b>Articles</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Article</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Number Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCK_ARTICLE__NUMBER_ORDERED = eINSTANCE.getStockArticle_NumberOrdered();

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
		 * The meta object literal for the '<em><b>Article</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Bound For</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Issuer</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.AddressImpl <em>Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.AddressImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getAddress()
		 * @generated
		 */
		EClass ADDRESS = eINSTANCE.getAddress();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__STREET = eINSTANCE.getAddress_Street();

		/**
		 * The meta object literal for the '<em><b>Post Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__POST_CODE = eINSTANCE.getAddress_PostCode();

		/**
		 * The meta object literal for the '<em><b>Town</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__TOWN = eINSTANCE.getAddress_Town();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__COUNTRY = eINSTANCE.getAddress_Country();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.CustomerImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Insurance Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__INSURANCE_NUMBER = eINSTANCE.getCustomer_InsuranceNumber();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NAME = eINSTANCE.getCustomer_Name();

		/**
		 * The meta object literal for the '<em><b>Phone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__PHONE_NUMBER = eINSTANCE.getCustomer_PhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__ADDRESS = eINSTANCE.getCustomer_Address();

		/**
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.LineItemsImpl <em>Line Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.LineItemsImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getLineItems()
		 * @generated
		 */
		EClass LINE_ITEMS = eINSTANCE.getLineItems();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE_ITEMS__ARTICLE = eINSTANCE.getLineItems_Article();

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
