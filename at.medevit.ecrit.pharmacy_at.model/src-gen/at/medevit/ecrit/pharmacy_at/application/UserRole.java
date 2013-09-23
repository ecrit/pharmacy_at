/**
 */
package at.medevit.ecrit.pharmacy_at.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>User Role</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see at.medevit.ecrit.pharmacy_at.application.ApplicationPackage#getUserRole()
 * @model
 * @generated
 */
public enum UserRole implements Enumerator {
	/**
	 * The '<em><b>SELLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELLER_VALUE
	 * @generated
	 * @ordered
	 */
	SELLER(0, "SELLER", "SELLER"),

	/**
	 * The '<em><b>CLERK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLERK_VALUE
	 * @generated
	 * @ordered
	 */
	CLERK(1, "CLERK", "CLERK"),

	/**
	 * The '<em><b>STOCKIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOCKIST_VALUE
	 * @generated
	 * @ordered
	 */
	STOCKIST(2, "STOCKIST", "STOCKIST"),

	/**
	 * The '<em><b>SYSADMIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSADMIN_VALUE
	 * @generated
	 * @ordered
	 */
	SYSADMIN(3, "SYSADMIN", "SYSADMIN");

	/**
	 * The '<em><b>SELLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SELLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SELLER_VALUE = 0;

	/**
	 * The '<em><b>CLERK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLERK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLERK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLERK_VALUE = 1;

	/**
	 * The '<em><b>STOCKIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOCKIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOCKIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STOCKIST_VALUE = 2;

	/**
	 * The '<em><b>SYSADMIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYSADMIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSADMIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYSADMIN_VALUE = 3;

	/**
	 * An array of all the '<em><b>User Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UserRole[] VALUES_ARRAY =
		new UserRole[] {
			SELLER,
			CLERK,
			STOCKIST,
			SYSADMIN,
		};

	/**
	 * A public read-only list of all the '<em><b>User Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UserRole> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>User Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserRole get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UserRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserRole getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UserRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserRole get(int value) {
		switch (value) {
			case SELLER_VALUE: return SELLER;
			case CLERK_VALUE: return CLERK;
			case STOCKIST_VALUE: return STOCKIST;
			case SYSADMIN_VALUE: return SYSADMIN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private UserRole(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //UserRole
