/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stock Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getIssuer <em>Issuer</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockOrder()
 * @model
 * @generated
 */
public interface StockOrder extends EObject {
	/**
	 * Returns the value of the '<em><b>Article</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Article}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Article</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Article</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockOrder_Article()
	 * @model
	 * @generated
	 */
	EList<Article> getArticle();

	/**
	 * Returns the value of the '<em><b>Issuer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issuer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issuer</em>' attribute.
	 * @see #setIssuer(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockOrder_Issuer()
	 * @model
	 * @generated
	 */
	String getIssuer();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getIssuer <em>Issuer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issuer</em>' attribute.
	 * @see #getIssuer()
	 * @generated
	 */
	void setIssuer(String value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getStockOrder_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.StockOrder#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

} // StockOrder
