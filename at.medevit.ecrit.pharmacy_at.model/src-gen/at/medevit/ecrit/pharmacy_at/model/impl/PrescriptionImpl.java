/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Customer;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prescription</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl#getIssuingPractitioner <em>Issuing Practitioner</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PrescriptionImpl#getPrescriptionCustomer <em>Prescription Customer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrescriptionImpl extends MinimalEObjectImpl.Container implements Prescription {
	/**
	 * The default value of the '{@link #getIssuingPractitioner() <em>Issuing Practitioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssuingPractitioner()
	 * @generated
	 * @ordered
	 */
	protected static final String ISSUING_PRACTITIONER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssuingPractitioner() <em>Issuing Practitioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssuingPractitioner()
	 * @generated
	 * @ordered
	 */
	protected String issuingPractitioner = ISSUING_PRACTITIONER_EDEFAULT;

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
	 * The cached value of the '{@link #getArticle() <em>Article</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArticle()
	 * @generated
	 * @ordered
	 */
	protected EList<Article> article;

	/**
	 * The cached value of the '{@link #getPrescriptionCustomer() <em>Prescription Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrescriptionCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer prescriptionCustomer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PRESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIssuingPractitioner() {
		return issuingPractitioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssuingPractitioner(String newIssuingPractitioner) {
		String oldIssuingPractitioner = issuingPractitioner;
		issuingPractitioner = newIssuingPractitioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRESCRIPTION__ISSUING_PRACTITIONER, oldIssuingPractitioner, issuingPractitioner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRESCRIPTION__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Article> getArticle() {
		if (article == null) {
			article = new EObjectContainmentEList<Article>(Article.class, this, ModelPackage.PRESCRIPTION__ARTICLE);
		}
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getPrescriptionCustomer() {
		if (prescriptionCustomer != null && prescriptionCustomer.eIsProxy()) {
			InternalEObject oldPrescriptionCustomer = (InternalEObject)prescriptionCustomer;
			prescriptionCustomer = (Customer)eResolveProxy(oldPrescriptionCustomer);
			if (prescriptionCustomer != oldPrescriptionCustomer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER, oldPrescriptionCustomer, prescriptionCustomer));
			}
		}
		return prescriptionCustomer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetPrescriptionCustomer() {
		return prescriptionCustomer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrescriptionCustomer(Customer newPrescriptionCustomer) {
		Customer oldPrescriptionCustomer = prescriptionCustomer;
		prescriptionCustomer = newPrescriptionCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER, oldPrescriptionCustomer, prescriptionCustomer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PRESCRIPTION__ARTICLE:
				return ((InternalEList<?>)getArticle()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PRESCRIPTION__ISSUING_PRACTITIONER:
				return getIssuingPractitioner();
			case ModelPackage.PRESCRIPTION__NUMBER:
				return getNumber();
			case ModelPackage.PRESCRIPTION__ARTICLE:
				return getArticle();
			case ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER:
				if (resolve) return getPrescriptionCustomer();
				return basicGetPrescriptionCustomer();
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
			case ModelPackage.PRESCRIPTION__ISSUING_PRACTITIONER:
				setIssuingPractitioner((String)newValue);
				return;
			case ModelPackage.PRESCRIPTION__NUMBER:
				setNumber((Integer)newValue);
				return;
			case ModelPackage.PRESCRIPTION__ARTICLE:
				getArticle().clear();
				getArticle().addAll((Collection<? extends Article>)newValue);
				return;
			case ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER:
				setPrescriptionCustomer((Customer)newValue);
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
			case ModelPackage.PRESCRIPTION__ISSUING_PRACTITIONER:
				setIssuingPractitioner(ISSUING_PRACTITIONER_EDEFAULT);
				return;
			case ModelPackage.PRESCRIPTION__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ModelPackage.PRESCRIPTION__ARTICLE:
				getArticle().clear();
				return;
			case ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER:
				setPrescriptionCustomer((Customer)null);
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
			case ModelPackage.PRESCRIPTION__ISSUING_PRACTITIONER:
				return ISSUING_PRACTITIONER_EDEFAULT == null ? issuingPractitioner != null : !ISSUING_PRACTITIONER_EDEFAULT.equals(issuingPractitioner);
			case ModelPackage.PRESCRIPTION__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ModelPackage.PRESCRIPTION__ARTICLE:
				return article != null && !article.isEmpty();
			case ModelPackage.PRESCRIPTION__PRESCRIPTION_CUSTOMER:
				return prescriptionCustomer != null;
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
		result.append(" (issuingPractitioner: ");
		result.append(issuingPractitioner);
		result.append(", number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //PrescriptionImpl
