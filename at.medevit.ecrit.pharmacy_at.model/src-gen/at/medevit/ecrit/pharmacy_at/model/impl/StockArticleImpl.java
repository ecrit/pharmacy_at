/**
 */
package at.medevit.ecrit.pharmacy_at.model.impl;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

import org.eclipse.emf.common.notify.Notification;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public class StockArticleImpl extends MinimalEObjectImpl.Container implements StockArticle {
	/**
	 * The cached value of the '{@link #getArticle() <em>Article</em>}' reference.
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
		if (article != null && article.eIsProxy()) {
			InternalEObject oldArticle = (InternalEObject)article;
			article = (Article)eResolveProxy(oldArticle);
			if (article != oldArticle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.STOCK_ARTICLE__ARTICLE, oldArticle, article));
			}
		}
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Article basicGetArticle() {
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArticle(Article newArticle) {
		Article oldArticle = article;
		article = newArticle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STOCK_ARTICLE__ARTICLE, oldArticle, article));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.STOCK_ARTICLE__ARTICLE:
				if (resolve) return getArticle();
				return basicGetArticle();
			case ModelPackage.STOCK_ARTICLE__NUMBER_ON_STOCK:
				return getNumberOnStock();
			case ModelPackage.STOCK_ARTICLE__LOWER_BOUND:
				return getLowerBound();
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
		result.append(')');
		return result.toString();
	}

} //StockArticleImpl
