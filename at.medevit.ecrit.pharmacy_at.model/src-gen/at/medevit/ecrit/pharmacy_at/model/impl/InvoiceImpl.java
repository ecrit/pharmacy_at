/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Customer;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getPrescription <em>Prescription</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getPaidAmount <em>Paid Amount</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getDate <em>Date</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.InvoiceImpl#getInvoiceCustomer <em>Invoice Customer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvoiceImpl extends MinimalEObjectImpl.Container implements Invoice {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArticle() <em>Article</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArticle()
	 * @generated
	 * @ordered
	 */
	protected EList<Article> article;

	/**
	 * The cached value of the '{@link #getPrescription() <em>Prescription</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrescription()
	 * @generated
	 * @ordered
	 */
	protected EList<Prescription> prescription;

	/**
	 * The default value of the '{@link #getPaidAmount() <em>Paid Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaidAmount()
	 * @generated
	 * @ordered
	 */
	protected static final float PAID_AMOUNT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPaidAmount() <em>Paid Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaidAmount()
	 * @generated
	 * @ordered
	 */
	protected float paidAmount = PAID_AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvoiceCustomer() <em>Invoice Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvoiceCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer invoiceCustomer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.INVOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INVOICE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Article> getArticle() {
		if (article == null) {
			article = new EObjectResolvingEList<Article>(Article.class, this, ModelPackage.INVOICE__ARTICLE);
		}
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Prescription> getPrescription() {
		if (prescription == null) {
			prescription = new EObjectResolvingEList<Prescription>(Prescription.class, this, ModelPackage.INVOICE__PRESCRIPTION);
		}
		return prescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPaidAmount() {
		return paidAmount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaidAmount(float newPaidAmount) {
		float oldPaidAmount = paidAmount;
		paidAmount = newPaidAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INVOICE__PAID_AMOUNT, oldPaidAmount, paidAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INVOICE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getInvoiceCustomer() {
		if (invoiceCustomer != null && invoiceCustomer.eIsProxy()) {
			InternalEObject oldInvoiceCustomer = (InternalEObject)invoiceCustomer;
			invoiceCustomer = (Customer)eResolveProxy(oldInvoiceCustomer);
			if (invoiceCustomer != oldInvoiceCustomer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.INVOICE__INVOICE_CUSTOMER, oldInvoiceCustomer, invoiceCustomer));
			}
		}
		return invoiceCustomer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetInvoiceCustomer() {
		return invoiceCustomer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvoiceCustomer(Customer newInvoiceCustomer) {
		Customer oldInvoiceCustomer = invoiceCustomer;
		invoiceCustomer = newInvoiceCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INVOICE__INVOICE_CUSTOMER, oldInvoiceCustomer, invoiceCustomer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.INVOICE__ID:
				return getId();
			case ModelPackage.INVOICE__ARTICLE:
				return getArticle();
			case ModelPackage.INVOICE__PRESCRIPTION:
				return getPrescription();
			case ModelPackage.INVOICE__PAID_AMOUNT:
				return getPaidAmount();
			case ModelPackage.INVOICE__DATE:
				return getDate();
			case ModelPackage.INVOICE__INVOICE_CUSTOMER:
				if (resolve) return getInvoiceCustomer();
				return basicGetInvoiceCustomer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.INVOICE__ID:
				setId((Integer)newValue);
				return;
			case ModelPackage.INVOICE__ARTICLE:
				getArticle().clear();
				getArticle().addAll((Collection<? extends Article>)newValue);
				return;
			case ModelPackage.INVOICE__PRESCRIPTION:
				getPrescription().clear();
				getPrescription().addAll((Collection<? extends Prescription>)newValue);
				return;
			case ModelPackage.INVOICE__PAID_AMOUNT:
				setPaidAmount((Float)newValue);
				return;
			case ModelPackage.INVOICE__DATE:
				setDate((Date)newValue);
				return;
			case ModelPackage.INVOICE__INVOICE_CUSTOMER:
				setInvoiceCustomer((Customer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.INVOICE__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.INVOICE__ARTICLE:
				getArticle().clear();
				return;
			case ModelPackage.INVOICE__PRESCRIPTION:
				getPrescription().clear();
				return;
			case ModelPackage.INVOICE__PAID_AMOUNT:
				setPaidAmount(PAID_AMOUNT_EDEFAULT);
				return;
			case ModelPackage.INVOICE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ModelPackage.INVOICE__INVOICE_CUSTOMER:
				setInvoiceCustomer((Customer)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.INVOICE__ID:
				return id != ID_EDEFAULT;
			case ModelPackage.INVOICE__ARTICLE:
				return article != null && !article.isEmpty();
			case ModelPackage.INVOICE__PRESCRIPTION:
				return prescription != null && !prescription.isEmpty();
			case ModelPackage.INVOICE__PAID_AMOUNT:
				return paidAmount != PAID_AMOUNT_EDEFAULT;
			case ModelPackage.INVOICE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ModelPackage.INVOICE__INVOICE_CUSTOMER:
				return invoiceCustomer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", paidAmount: ");
		result.append(paidAmount);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //InvoiceImpl
