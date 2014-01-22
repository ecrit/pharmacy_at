/**
 */
package at.medevit.ecrit.pharmacy_at.application;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Users</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.application.Users#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUsers()
 * @model
 * @generated
 */
public interface Users extends EObject {
	/**
	 * Returns the value of the '<em><b>Users</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.application.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUsers_Users()
	 * @model
	 * @generated
	 */
	EList<User> getUsers();

} // Users
