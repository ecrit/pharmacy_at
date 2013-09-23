/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Stock Order Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockOrderStatus()
 * @model
 * @generated
 */
public enum StockOrderStatus implements Enumerator {
	/**
	 * The '<em><b>NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @generated
	 * @ordered
	 */
	NEW(0, "NEW", "NEW"),

	/**
	 * The '<em><b>ORDERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORDERED_VALUE
	 * @generated
	 * @ordered
	 */
	ORDERED(1, "ORDERED", "ORDERED"),

	/**
	 * The '<em><b>AWAITING DELIVERY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AWAITING_DELIVERY_VALUE
	 * @generated
	 * @ordered
	 */
	AWAITING_DELIVERY(2, "AWAITING_DELIVERY", "AWAITING_DELIVERY"),

	/**
	 * The '<em><b>RECEIVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECEIVED_VALUE
	 * @generated
	 * @ordered
	 */
	RECEIVED(3, "RECEIVED", "RECEIVED"),

	/**
	 * The '<em><b>ARTICLE REPLACED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARTICLE_REPLACED_VALUE
	 * @generated
	 * @ordered
	 */
	ARTICLE_REPLACED(98, "ARTICLE_REPLACED", ""),

	/**
	 * The '<em><b>NOT AVAILABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_AVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_AVAILABLE(99, "NOT_AVAILABLE", "NOT_AVAILABLE");

	/**
	 * The '<em><b>NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE = 0;

	/**
	 * The '<em><b>ORDERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ORDERED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORDERED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_VALUE = 1;

	/**
	 * The '<em><b>AWAITING DELIVERY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AWAITING DELIVERY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AWAITING_DELIVERY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AWAITING_DELIVERY_VALUE = 2;

	/**
	 * The '<em><b>RECEIVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECEIVED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECEIVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECEIVED_VALUE = 3;

	/**
	 * The '<em><b>ARTICLE REPLACED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARTICLE REPLACED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARTICLE_REPLACED
	 * @model literal=""
	 * @generated
	 * @ordered
	 */
	public static final int ARTICLE_REPLACED_VALUE = 98;

	/**
	 * The '<em><b>NOT AVAILABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT AVAILABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_AVAILABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_AVAILABLE_VALUE = 99;

	/**
	 * An array of all the '<em><b>Stock Order Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final StockOrderStatus[] VALUES_ARRAY =
		new StockOrderStatus[] {
			NEW,
			ORDERED,
			AWAITING_DELIVERY,
			RECEIVED,
			ARTICLE_REPLACED,
			NOT_AVAILABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Stock Order Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<StockOrderStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Stock Order Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StockOrderStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StockOrderStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Stock Order Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StockOrderStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StockOrderStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Stock Order Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StockOrderStatus get(int value) {
		switch (value) {
			case NEW_VALUE: return NEW;
			case ORDERED_VALUE: return ORDERED;
			case AWAITING_DELIVERY_VALUE: return AWAITING_DELIVERY;
			case RECEIVED_VALUE: return RECEIVED;
			case ARTICLE_REPLACED_VALUE: return ARTICLE_REPLACED;
			case NOT_AVAILABLE_VALUE: return NOT_AVAILABLE;
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
	private StockOrderStatus(int value, String name, String literal) {
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
	
} //StockOrderStatus
