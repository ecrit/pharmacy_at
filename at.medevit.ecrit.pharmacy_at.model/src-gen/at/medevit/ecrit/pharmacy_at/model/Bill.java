/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bill</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Bill#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Bill#getPrescription <em>Prescription</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Bill#getPaidAmount <em>Paid Amount</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getBill()
 * @model
 * @generated
 */
public interface Bill extends EObject {
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
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getBill_Article()
	 * @model
	 * @generated
	 */
	EList<Article> getArticle();

	/**
	 * Returns the value of the '<em><b>Prescription</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Prescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prescription</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prescription</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getBill_Prescription()
	 * @model
	 * @generated
	 */
	EList<Prescription> getPrescription();

	/**
	 * Returns the value of the '<em><b>Paid Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paid Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paid Amount</em>' attribute.
	 * @see #setPaidAmount(float)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getBill_PaidAmount()
	 * @model
	 * @generated
	 */
	float getPaidAmount();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Bill#getPaidAmount <em>Paid Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paid Amount</em>' attribute.
	 * @see #getPaidAmount()
	 * @generated
	 */
	void setPaidAmount(float value);

} // Bill
