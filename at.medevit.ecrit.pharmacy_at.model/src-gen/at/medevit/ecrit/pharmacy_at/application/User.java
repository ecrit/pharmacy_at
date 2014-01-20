/**
 */
package at.medevit.ecrit.pharmacy_at.application;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.application.User#getName <em>Name</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.application.User#getRole <em>Role</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.application.User#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
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
	 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUser_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.application.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.application.UserRole}.
	 * The literals are from the enumeration {@link at.medevit.ecrit.pharmacy_at.application.UserRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute list.
	 * @see at.medevit.ecrit.pharmacy_at.application.UserRole
	 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUser_Role()
	 * @model
	 * @generated
	 */
	EList<UserRole> getRole();

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUser_Password()
	 * @model required="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.application.User#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

} // User
