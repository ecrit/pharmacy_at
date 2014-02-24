/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stock Article</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl#getNumberOnStock <em>Number On Stock</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl#getNumberOrdered <em>Number Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StockArticleImpl extends MinimalEObjectImpl.Container implements StockArticle {
	/**
	 * The cached value of the '{@link #getArticle() <em>Article</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArticle()
	 * @generated
	 * @ordered
	 */
	protected Article article;

	/**
	 * The default value of the '{@link #getNumberOnStock() <em>Number On Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOnStock()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_ON_STOCK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOnStock() <em>Number On Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOnStock()
	 * @generated
	 * @ordered
	 */
	protected int numberOnStock = NUMBER_ON_STOCK_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOrdered() <em>Number Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_ORDERED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOrdered() <em>Number Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOrdered()
	 * @generated
	 * @ordered
	 */
	protected int numberOrdered = NUMBER_ORDERED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StockArticleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.STOCK_ARTICLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArticle(Article newArticle, NotificationChain msgs) {
		Article oldArticle = article;
		article = newArticle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__ARTICLE, oldArticle, newArticle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArticle(Article newArticle) {
		if (newArticle != article) {
			NotificationChain msgs = null;
			if (article != null)
				msgs = ((InternalEObject)article).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STOCK_ARTICLE__ARTICLE, null, msgs);
			if (newArticle != null)
				msgs = ((InternalEObject)newArticle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STOCK_ARTICLE__ARTICLE, null, msgs);
			msgs = basicSetArticle(newArticle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__ARTICLE, newArticle, newArticle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOnStock() {
		return numberOnStock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOnStock(int newNumberOnStock) {
		int oldNumberOnStock = numberOnStock;
		numberOnStock = newNumberOnStock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK, oldNumberOnStock, numberOnStock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		int oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOrdered() {
		return numberOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOrdered(int newNumberOrdered) {
		int oldNumberOrdered = numberOrdered;
		numberOrdered = newNumberOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__NUMBER_ORDERED, oldNumberOrdered, numberOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				return basicSetArticle(null, msgs);
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
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				return getArticle();
			case ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK:
				return getNumberOnStock();
			case ModelPackage.STOCK_ARTICLE__LOWER_BOUND:
				return getLowerBound();
			case ModelPackage.STOCK_ARTICLE__NUMBER_ORDERED:
				return getNumberOrdered();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				setArticle((Article)newValue);
				return;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK:
				setNumberOnStock((Integer)newValue);
				return;
			case ModelPackage.STOCK_ARTICLE__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ORDERED:
				setNumberOrdered((Integer)newValue);
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
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				setArticle((Article)null);
				return;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK:
				setNumberOnStock(NUMBER_ON_STOCK_EDEFAULT);
				return;
			case ModelPackage.STOCK_ARTICLE__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ORDERED:
				setNumberOrdered(NUMBER_ORDERED_EDEFAULT);
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
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				return article != null;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK:
				return numberOnStock != NUMBER_ON_STOCK_EDEFAULT;
			case ModelPackage.STOCK_ARTICLE__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case ModelPackage.STOCK_ARTICLE__NUMBER_ORDERED:
				return numberOrdered != NUMBER_ORDERED_EDEFAULT;
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
		result.append(" (numberOnStock: ");
		result.append(numberOnStock);
		result.append(", lowerBound: ");
		result.append(lowerBound);
		result.append(", numberOrdered: ");
		result.append(numberOrdered);
		result.append(')');
		return result.toString();
	}

} //StockArticleImpl
