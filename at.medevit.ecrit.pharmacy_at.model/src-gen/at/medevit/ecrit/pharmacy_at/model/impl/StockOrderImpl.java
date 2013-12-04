/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Stock;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;

import at.medevit.ecrit.pharmacy_at.model.StockOrderStatus;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stock Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl#getIssuer <em>Issuer</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl#getBoundFor <em>Bound For</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockOrderImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StockOrderImpl extends MinimalEObjectImpl.Container implements StockOrder {
	/**
	 * The cached value of the '{@link #getArticle() <em>Article</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArticle()
	 * @generated
	 * @ordered
	 */
	protected EList<Article> article;

	/**
	 * The default value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssuer()
	 * @generated
	 * @ordered
	 */
	protected static final String ISSUER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssuer()
	 * @generated
	 * @ordered
	 */
	protected String issuer = ISSUER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBoundFor() <em>Bound For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundFor()
	 * @generated
	 * @ordered
	 */
	protected Stock boundFor;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final StockOrderStatus STATUS_EDEFAULT = StockOrderStatus.NEW;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected StockOrderStatus status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StockOrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.STOCK_ORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Article> getArticle() {
		if (article == null) {
			article = new EObjectResolvingEList<Article>(Article.class, this, ModelPackage.STOCK_ORDER__ARTICLE);
		}
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssuer(String newIssuer) {
		String oldIssuer = issuer;
		issuer = newIssuer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ORDER__ISSUER, oldIssuer, issuer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ORDER__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stock getBoundFor() {
		if (boundFor != null && boundFor.eIsProxy()) {
			InternalEObject oldBoundFor = (InternalEObject)boundFor;
			boundFor = (Stock)eResolveProxy(oldBoundFor);
			if (boundFor != oldBoundFor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.STOCK_ORDER__BOUND_FOR, oldBoundFor, boundFor));
			}
		}
		return boundFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stock basicGetBoundFor() {
		return boundFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundFor(Stock newBoundFor) {
		Stock oldBoundFor = boundFor;
		boundFor = newBoundFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ORDER__BOUND_FOR, oldBoundFor, boundFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StockOrderStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(StockOrderStatus newStatus) {
		StockOrderStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ORDER__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.STOCK_ORDER__ARTICLE:
				return getArticle();
			case ModelPackage.STOCK_ORDER__ISSUER:
				return getIssuer();
			case ModelPackage.STOCK_ORDER__NUMBER:
				return getNumber();
			case ModelPackage.STOCK_ORDER__BOUND_FOR:
				if (resolve) return getBoundFor();
				return basicGetBoundFor();
			case ModelPackage.STOCK_ORDER__STATUS:
				return getStatus();
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
			case ModelPackage.STOCK_ORDER__ARTICLE:
				getArticle().clear();
				getArticle().addAll((Collection<? extends Article>)newValue);
				return;
			case ModelPackage.STOCK_ORDER__ISSUER:
				setIssuer((String)newValue);
				return;
			case ModelPackage.STOCK_ORDER__NUMBER:
				setNumber((Integer)newValue);
				return;
			case ModelPackage.STOCK_ORDER__BOUND_FOR:
				setBoundFor((Stock)newValue);
				return;
			case ModelPackage.STOCK_ORDER__STATUS:
				setStatus((StockOrderStatus)newValue);
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
			case ModelPackage.STOCK_ORDER__ARTICLE:
				getArticle().clear();
				return;
			case ModelPackage.STOCK_ORDER__ISSUER:
				setIssuer(ISSUER_EDEFAULT);
				return;
			case ModelPackage.STOCK_ORDER__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ModelPackage.STOCK_ORDER__BOUND_FOR:
				setBoundFor((Stock)null);
				return;
			case ModelPackage.STOCK_ORDER__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case ModelPackage.STOCK_ORDER__ARTICLE:
				return article != null && !article.isEmpty();
			case ModelPackage.STOCK_ORDER__ISSUER:
				return ISSUER_EDEFAULT == null ? issuer != null : !ISSUER_EDEFAULT.equals(issuer);
			case ModelPackage.STOCK_ORDER__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ModelPackage.STOCK_ORDER__BOUND_FOR:
				return boundFor != null;
			case ModelPackage.STOCK_ORDER__STATUS:
				return status != STATUS_EDEFAULT;
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
		result.append(" (issuer: ");
		result.append(issuer);
		result.append(", number: ");
		result.append(number);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //StockOrderImpl
