/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Address;
import at.medevit.ecrit.pharmacy_at.model.Customer;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.LineItems;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Pharmacy;
import at.medevit.ecrit.pharmacy_at.model.Report;
import at.medevit.ecrit.pharmacy_at.model.Stock;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;
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
 * An implementation of the model object '<em><b>Pharmacy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getStock <em>Stock</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getInvoices <em>Invoices</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getReports <em>Reports</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getStockOrders <em>Stock Orders</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.PharmacyImpl#getLineItems <em>Line Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PharmacyImpl extends MinimalEObjectImpl.Container implements Pharmacy {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected Address address;

	/**
	 * The cached value of the '{@link #getStock() <em>Stock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStock()
	 * @generated
	 * @ordered
	 */
	protected Stock stock;

	/**
	 * The cached value of the '{@link #getInvoices() <em>Invoices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvoices()
	 * @generated
	 * @ordered
	 */
	protected EList<Invoice> invoices;

	/**
	 * The cached value of the '{@link #getReports() <em>Reports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReports()
	 * @generated
	 * @ordered
	 */
	protected EList<Report> reports;

	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;

	/**
	 * The cached value of the '{@link #getStockOrders() <em>Stock Orders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStockOrders()
	 * @generated
	 * @ordered
	 */
	protected EList<StockOrder> stockOrders;

	/**
	 * The cached value of the '{@link #getLineItems() <em>Line Items</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineItems()
	 * @generated
	 * @ordered
	 */
	protected LineItems lineItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PharmacyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PHARMACY;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStock(Stock newStock, NotificationChain msgs) {
		Stock oldStock = stock;
		stock = newStock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__STOCK, oldStock, newStock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStock(Stock newStock) {
		if (newStock != stock) {
			NotificationChain msgs = null;
			if (stock != null)
				msgs = ((InternalEObject)stock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__STOCK, null, msgs);
			if (newStock != null)
				msgs = ((InternalEObject)newStock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__STOCK, null, msgs);
			msgs = basicSetStock(newStock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__STOCK, newStock, newStock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Invoice> getInvoices() {
		if (invoices == null) {
			invoices = new EObjectContainmentEList<Invoice>(Invoice.class, this, ModelPackage.PHARMACY__INVOICES);
		}
		return invoices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Report> getReports() {
		if (reports == null) {
			reports = new EObjectContainmentEList<Report>(Report.class, this, ModelPackage.PHARMACY__REPORTS);
		}
		return reports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentEList<Customer>(Customer.class, this, ModelPackage.PHARMACY__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StockOrder> getStockOrders() {
		if (stockOrders == null) {
			stockOrders = new EObjectContainmentEList<StockOrder>(StockOrder.class, this, ModelPackage.PHARMACY__STOCK_ORDERS);
		}
		return stockOrders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineItems getLineItems() {
		return lineItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLineItems(LineItems newLineItems, NotificationChain msgs) {
		LineItems oldLineItems = lineItems;
		lineItems = newLineItems;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__LINE_ITEMS, oldLineItems, newLineItems);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineItems(LineItems newLineItems) {
		if (newLineItems != lineItems) {
			NotificationChain msgs = null;
			if (lineItems != null)
				msgs = ((InternalEObject)lineItems).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__LINE_ITEMS, null, msgs);
			if (newLineItems != null)
				msgs = ((InternalEObject)newLineItems).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PHARMACY__LINE_ITEMS, null, msgs);
			msgs = basicSetLineItems(newLineItems, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PHARMACY__LINE_ITEMS, newLineItems, newLineItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PHARMACY__ADDRESS:
				return basicSetAddress(null, msgs);
			case ModelPackage.PHARMACY__STOCK:
				return basicSetStock(null, msgs);
			case ModelPackage.PHARMACY__INVOICES:
				return ((InternalEList<?>)getInvoices()).basicRemove(otherEnd, msgs);
			case ModelPackage.PHARMACY__REPORTS:
				return ((InternalEList<?>)getReports()).basicRemove(otherEnd, msgs);
			case ModelPackage.PHARMACY__CUSTOMERS:
				return ((InternalEList<?>)getCustomers()).basicRemove(otherEnd, msgs);
			case ModelPackage.PHARMACY__STOCK_ORDERS:
				return ((InternalEList<?>)getStockOrders()).basicRemove(otherEnd, msgs);
			case ModelPackage.PHARMACY__LINE_ITEMS:
				return basicSetLineItems(null, msgs);
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
			case ModelPackage.PHARMACY__NAME:
				return getName();
			case ModelPackage.PHARMACY__ADDRESS:
				return getAddress();
			case ModelPackage.PHARMACY__STOCK:
				return getStock();
			case ModelPackage.PHARMACY__INVOICES:
				return getInvoices();
			case ModelPackage.PHARMACY__REPORTS:
				return getReports();
			case ModelPackage.PHARMACY__CUSTOMERS:
				return getCustomers();
			case ModelPackage.PHARMACY__STOCK_ORDERS:
				return getStockOrders();
			case ModelPackage.PHARMACY__LINE_ITEMS:
				return getLineItems();
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
			case ModelPackage.PHARMACY__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PHARMACY__ADDRESS:
				setAddress((Address)newValue);
				return;
			case ModelPackage.PHARMACY__STOCK:
				setStock((Stock)newValue);
				return;
			case ModelPackage.PHARMACY__INVOICES:
				getInvoices().clear();
				getInvoices().addAll((Collection<? extends Invoice>)newValue);
				return;
			case ModelPackage.PHARMACY__REPORTS:
				getReports().clear();
				getReports().addAll((Collection<? extends Report>)newValue);
				return;
			case ModelPackage.PHARMACY__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection<? extends Customer>)newValue);
				return;
			case ModelPackage.PHARMACY__STOCK_ORDERS:
				getStockOrders().clear();
				getStockOrders().addAll((Collection<? extends StockOrder>)newValue);
				return;
			case ModelPackage.PHARMACY__LINE_ITEMS:
				setLineItems((LineItems)newValue);
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
			case ModelPackage.PHARMACY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PHARMACY__ADDRESS:
				setAddress((Address)null);
				return;
			case ModelPackage.PHARMACY__STOCK:
				setStock((Stock)null);
				return;
			case ModelPackage.PHARMACY__INVOICES:
				getInvoices().clear();
				return;
			case ModelPackage.PHARMACY__REPORTS:
				getReports().clear();
				return;
			case ModelPackage.PHARMACY__CUSTOMERS:
				getCustomers().clear();
				return;
			case ModelPackage.PHARMACY__STOCK_ORDERS:
				getStockOrders().clear();
				return;
			case ModelPackage.PHARMACY__LINE_ITEMS:
				setLineItems((LineItems)null);
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
			case ModelPackage.PHARMACY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PHARMACY__ADDRESS:
				return address != null;
			case ModelPackage.PHARMACY__STOCK:
				return stock != null;
			case ModelPackage.PHARMACY__INVOICES:
				return invoices != null && !invoices.isEmpty();
			case ModelPackage.PHARMACY__REPORTS:
				return reports != null && !reports.isEmpty();
			case ModelPackage.PHARMACY__CUSTOMERS:
				return customers != null && !customers.isEmpty();
			case ModelPackage.PHARMACY__STOCK_ORDERS:
				return stockOrders != null && !stockOrders.isEmpty();
			case ModelPackage.PHARMACY__LINE_ITEMS:
				return lineItems != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PharmacyImpl
