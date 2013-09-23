/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Bill;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

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
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getPrescription <em>Prescription</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.BillImpl#getPaidAmount <em>Paid Amount</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BillImpl extends MinimalEObjectImpl.Container implements Bill {
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BILL__ARTICLE:
				return getArticle();
			case ModelPackage.BILL__PRESCRIPTION:
				return getPrescription();
			case ModelPackage.BILL__PAID_AMOUNT:
				return getPaidAmount();
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
			case ModelPackage.BILL__ARTICLE:
				getArticle().clear();
				return;
			case ModelPackage.BILL__PRESCRIPTION:
				getPrescription().clear();
				return;
			case ModelPackage.BILL__PAID_AMOUNT:
				setPaidAmount(PAID_AMOUNT_EDEFAULT);
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
			case ModelPackage.BILL__ARTICLE:
				return article != null && !article.isEmpty();
			case ModelPackage.BILL__PRESCRIPTION:
				return prescription != null && !prescription.isEmpty();
			case ModelPackage.BILL__PAID_AMOUNT:
				return paidAmount != PAID_AMOUNT_EDEFAULT;
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
		result.append(" (paidAmount: ");
		result.append(paidAmount);
		result.append(')');
		return result.toString();
	}

} //BillImpl
