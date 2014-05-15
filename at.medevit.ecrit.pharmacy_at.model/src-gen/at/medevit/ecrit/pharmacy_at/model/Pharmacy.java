/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import at.medevit.ecrit.pharmacy_at.application.User;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pharmacy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getName <em>Name</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getAddress <em>Address</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStock <em>Stock</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getInvoices <em>Invoices</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getReports <em>Reports</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getCustomers <em>Customers</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStockOrders <em>Stock Orders</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getLineItems <em>Line Items</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStaff <em>Staff</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getCurrentUser <em>Current User</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy()
 * @model
 * @generated
 */
public interface Pharmacy extends EObject {
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
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Address()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Stock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stock</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stock</em>' containment reference.
	 * @see #setStock(Stock)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Stock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Stock getStock();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getStock <em>Stock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stock</em>' containment reference.
	 * @see #getStock()
	 * @generated
	 */
	void setStock(Stock value);

	/**
	 * Returns the value of the '<em><b>Invoices</b></em>' containment reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Invoice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoices</em>' containment reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Invoices()
	 * @model containment="true"
	 * @generated
	 */
	EList<Invoice> getInvoices();

	/**
	 * Returns the value of the '<em><b>Reports</b></em>' containment reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Report}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reports</em>' containment reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Reports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Report> getReports();

	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Customers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Stock Orders</b></em>' containment reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.StockOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stock Orders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stock Orders</em>' containment reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_StockOrders()
	 * @model containment="true"
	 * @generated
	 */
	EList<StockOrder> getStockOrders();

	/**
	 * Returns the value of the '<em><b>Line Items</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Items</em>' containment reference.
	 * @see #setLineItems(LineItems)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_LineItems()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LineItems getLineItems();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getLineItems <em>Line Items</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Items</em>' containment reference.
	 * @see #getLineItems()
	 * @generated
	 */
	void setLineItems(LineItems value);

	/**
	 * Returns the value of the '<em><b>Staff</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.application.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Staff</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Staff</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_Staff()
	 * @model
	 * @generated
	 */
	EList<User> getStaff();

	/**
	 * Returns the value of the '<em><b>Current User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current User</em>' reference.
	 * @see #setCurrentUser(User)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getPharmacy_CurrentUser()
	 * @model required="true"
	 * @generated
	 */
	User getCurrentUser();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Pharmacy#getCurrentUser <em>Current User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current User</em>' reference.
	 * @see #getCurrentUser()
	 * @generated
	 */
	void setCurrentUser(User value);

} // Pharmacy
