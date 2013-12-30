/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Date</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Date#getDate <em>Date</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Date#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getDate()
 * @model
 * @generated
 */
public interface Date extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(java.util.Date)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getDate_Date()
	 * @model required="true"
	 * @generated
	 */
	java.util.Date getDate();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Date#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(java.util.Date value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(java.util.Date)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getDate_Time()
	 * @model required="true"
	 * @generated
	 */
	java.util.Date getTime();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Date#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(java.util.Date value);

} // Date
