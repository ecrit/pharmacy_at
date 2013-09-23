/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Article</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__ARTICLE = 0;

	/**
	 * The feature id for the '<em><b>Prescription</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__PRESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Paid Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL__PAID_AMOUNT = 2;

	/**
	 * The number of structural features of the '<em>Bill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BILL_FEATURE_COUNT = 3;

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
	 * The number of structural features of the '<em>Stock Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Stock Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCK_ORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
	 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrderStatus()
	 * @generated
	 */
	int STOCK_ORDER_STATUS = 6;


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
	 * Returns the meta object for class '{@link at.medevit.ecrit.pharmacy_at.model.Bill <em>Bill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bill</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.Bill
	 * @generated
	 */
	EClass getBill();

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
	 * Returns the meta object for enum '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Stock Order Status</em>'.
	 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
	 * @generated
	 */
	EEnum getStockOrderStatus();

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
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl <em>Bill</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.BillImpl
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getBill()
		 * @generated
		 */
		EClass BILL = eINSTANCE.getBill();

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
		 * The meta object literal for the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrderStatus <em>Stock Order Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.medevit.ecrit.pharmacy_at.model.StockOrderStatus
		 * @see at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl#getStockOrderStatus()
		 * @generated
		 */
		EEnum STOCK_ORDER_STATUS = eINSTANCE.getStockOrderStatus();

	}

} //ModelPackage
