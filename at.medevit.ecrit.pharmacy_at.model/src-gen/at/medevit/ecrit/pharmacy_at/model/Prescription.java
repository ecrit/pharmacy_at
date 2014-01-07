/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prescription</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getIssuingPractitioner <em>Issuing Practitioner</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getNumber <em>Number</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getPrescriptionCustomer <em>Prescription Customer</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPrescription()
 * @model
 * @generated
 */
public interface Prescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Issuing Practitioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issuing Practitioner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issuing Practitioner</em>' attribute.
	 * @see #setIssuingPractitioner(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPrescription_IssuingPractitioner()
	 * @model
	 * @generated
	 */
	String getIssuingPractitioner();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getIssuingPractitioner <em>Issuing Practitioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issuing Practitioner</em>' attribute.
	 * @see #getIssuingPractitioner()
	 * @generated
	 */
	void setIssuingPractitioner(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPrescription_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Article</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Article}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Article</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Article</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPrescription_Article()
	 * @model
	 * @generated
	 */
	EList<Article> getArticle();

	/**
	 * Returns the value of the '<em><b>Prescription Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prescription Customer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prescription Customer</em>' reference.
	 * @see #setPrescriptionCustomer(Customer)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPrescription_PrescriptionCustomer()
	 * @model
	 * @generated
	 */
	Customer getPrescriptionCustomer();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Prescription#getPrescriptionCustomer <em>Prescription Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prescription Customer</em>' reference.
	 * @see #getPrescriptionCustomer()
	 * @generated
	 */
	void setPrescriptionCustomer(Customer value);

} // Prescription
