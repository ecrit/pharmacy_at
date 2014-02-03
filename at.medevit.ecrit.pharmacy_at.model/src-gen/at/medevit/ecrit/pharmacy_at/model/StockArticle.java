/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stock Article</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOnStock <em>Number On Stock</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOrdered <em>Number Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockArticle()
 * @model
 * @generated
 */
public interface StockArticle extends EObject {
	/**
	 * Returns the value of the '<em><b>Article</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Article</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Article</em>' reference.
	 * @see #setArticle(Article)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockArticle_Article()
	 * @model required="true"
	 * @generated
	 */
	Article getArticle();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getArticle <em>Article</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Article</em>' reference.
	 * @see #getArticle()
	 * @generated
	 */
	void setArticle(Article value);

	/**
	 * Returns the value of the '<em><b>Number On Stock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number On Stock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number On Stock</em>' attribute.
	 * @see #setNumberOnStock(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockArticle_NumberOnStock()
	 * @model
	 * @generated
	 */
	int getNumberOnStock();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOnStock <em>Number On Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number On Stock</em>' attribute.
	 * @see #getNumberOnStock()
	 * @generated
	 */
	void setNumberOnStock(int value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockArticle_LowerBound()
	 * @model
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Number Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Ordered</em>' attribute.
	 * @see #setNumberOrdered(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockArticle_NumberOrdered()
	 * @model
	 * @generated
	 */
	int getNumberOrdered();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockArticle#getNumberOrdered <em>Number Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Ordered</em>' attribute.
	 * @see #getNumberOrdered()
	 * @generated
	 */
	void setNumberOrdered(int value);

} // StockArticle
