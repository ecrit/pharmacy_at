/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Bill;
import at.medevit.ecrit.pharmacy_at.model.Date;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bill</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getPrescription <em>Prescription</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getPaidAmount <em>Paid Amount</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getDateTime <em>Date Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BillImpl extends MinimalEObjectImpl.Container implements Bill {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

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
	 * The cached value of the '{@link #getDateTime() <em>Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTime()
	 * @generated
	 * @ordered
	 */
	protected Date dateTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BillImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BILL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BILL__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Article> getArticle() {
		if (article == null) {
			article = new EObjectResolvingEList<Article>(Article.class, this, ModelPackage.BILL__ARTICLE);
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
			prescription = new EObjectResolvingEList<Prescription>(Prescription.class, this, ModelPackage.BILL__PRESCRIPTION);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BILL__PAID_AMOUNT, oldPaidAmount, paidAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateTime() {
		if (dateTime != null && dateTime.eIsProxy()) {
			InternalEObject oldDateTime = (InternalEObject)dateTime;
			dateTime = (Date)eResolveProxy(oldDateTime);
			if (dateTime != oldDateTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.BILL__DATE_TIME, oldDateTime, dateTime));
			}
		}
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date basicGetDateTime() {
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateTime(Date newDateTime) {
		Date oldDateTime = dateTime;
		dateTime = newDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BILL__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BILL__NUMBER:
				return getNumber();
			case ModelPackage.BILL__ARTICLE:
				return getArticle();
			case ModelPackage.BILL__PRESCRIPTION:
				return getPrescription();
			case ModelPackage.BILL__PAID_AMOUNT:
				return getPaidAmount();
			case ModelPackage.BILL__DATE_TIME:
				if (resolve) return getDateTime();
				return basicGetDateTime();
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
			case ModelPackage.BILL__NUMBER:
				setNumber((Integer)newValue);
				return;
			case ModelPackage.BILL__ARTICLE:
				getArticle().clear();
				getArticle().addAll((Collection<? extends Article>)newValue);
				return;
			case ModelPackage.BILL__PRESCRIPTION:
				getPrescription().clear();
				getPrescription().addAll((Collection<? extends Prescription>)newValue);
				return;
			case ModelPackage.BILL__PAID_AMOUNT:
				setPaidAmount((Float)newValue);
				return;
			case ModelPackage.BILL__DATE_TIME:
				setDateTime((Date)newValue);
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
			case ModelPackage.BILL__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ModelPackage.BILL__ARTICLE:
				getArticle().clear();
				return;
			case ModelPackage.BILL__PRESCRIPTION:
				getPrescription().clear();
				return;
			case ModelPackage.BILL__PAID_AMOUNT:
				setPaidAmount(PAID_AMOUNT_EDEFAULT);
				return;
			case ModelPackage.BILL__DATE_TIME:
				setDateTime((Date)null);
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
			case ModelPackage.BILL__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ModelPackage.BILL__ARTICLE:
				return article != null && !article.isEmpty();
			case ModelPackage.BILL__PRESCRIPTION:
				return prescription != null && !prescription.isEmpty();
			case ModelPackage.BILL__PAID_AMOUNT:
				return paidAmount != PAID_AMOUNT_EDEFAULT;
			case ModelPackage.BILL__DATE_TIME:
				return dateTime != null;
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
		result.append(" (number: ");
		result.append(number);
		result.append(", paidAmount: ");
		result.append(paidAmount);
		result.append(')');
		return result.toString();
	}

} //BillImpl
