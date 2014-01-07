/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getId <em>Id</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getArticle <em>Article</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getPrescription <em>Prescription</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getPaidAmount <em>Paid Amount</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getDate <em>Date</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getInvoiceCustomer <em>Invoice Customer</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice()
 * @model
 * @generated
 */
public interface Invoice extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

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
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_Article()
	 * @model
	 * @generated
	 */
	EList<Article> getArticle();

	/**
	 * Returns the value of the '<em><b>Prescription</b></em>' reference list.
	 * The list contents are of type {@link at.medevit.ecrit.pharmacy_at.model.Prescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prescription</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prescription</em>' reference list.
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_Prescription()
	 * @model
	 * @generated
	 */
	EList<Prescription> getPrescription();

	/**
	 * Returns the value of the '<em><b>Paid Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paid Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paid Amount</em>' attribute.
	 * @see #setPaidAmount(float)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_PaidAmount()
	 * @model
	 * @generated
	 */
	float getPaidAmount();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getPaidAmount <em>Paid Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paid Amount</em>' attribute.
	 * @see #getPaidAmount()
	 * @generated
	 */
	void setPaidAmount(float value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Invoice Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoice Customer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoice Customer</em>' reference.
	 * @see #setInvoiceCustomer(Customer)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getInvoice_InvoiceCustomer()
	 * @model
	 * @generated
	 */
	Customer getInvoiceCustomer();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Invoice#getInvoiceCustomer <em>Invoice Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invoice Customer</em>' reference.
	 * @see #getInvoiceCustomer()
	 * @generated
	 */
	void setInvoiceCustomer(Customer value);

} // Invoice
