/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Article#getName <em>Name</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Article#getDescription <em>Description</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Article#getAdmissionNumber <em>Admission Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getArticle()
 * @model
 * @generated
 */
public interface Article extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getArticle_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Article#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getArticle_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Article#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Admission Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admission Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Admission Number</em>' attribute.
	 * @see #setAdmissionNumber(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getArticle_AdmissionNumber()
	 * @model
	 * @generated
	 */
	int getAdmissionNumber();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Article#getAdmissionNumber <em>Admission Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admission Number</em>' attribute.
	 * @see #getAdmissionNumber()
	 * @generated
	 */
	void setAdmissionNumber(int value);

} // Article
