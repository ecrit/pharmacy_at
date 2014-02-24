/**
 */
package at.medevit.ecrit.pharmacy_at.model;

import at.medevit.ecrit.pharmacy_at.application.User;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Report#getTitle <em>Title</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Report#getIssuer <em>Issuer</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Report#getPriority <em>Priority</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Report#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link at.medevit.ecrit.pharmacy_at.model.Report#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport()
 * @model
 * @generated
 */
public interface Report extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport_Title()
	 * @model required="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Report#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Issuer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issuer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issuer</em>' containment reference.
	 * @see #setIssuer(User)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport_Issuer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	User getIssuer();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Report#getIssuer <em>Issuer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issuer</em>' containment reference.
	 * @see #getIssuer()
	 * @generated
	 */
	void setIssuer(User value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link at.medevit.ecrit.pharmacy_at.model.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see at.medevit.ecrit.pharmacy_at.model.Priority
	 * @see #setPriority(Priority)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport_Priority()
	 * @model
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Report#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see at.medevit.ecrit.pharmacy_at.model.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' attribute.
	 * @see #setConcerns(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport_Concerns()
	 * @model
	 * @generated
	 */
	String getConcerns();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Report#getConcerns <em>Concerns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concerns</em>' attribute.
	 * @see #getConcerns()
	 * @generated
	 */
	void setConcerns(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see at.medevit.ecrit.pharmacy_at.model.ModelPackage#getReport_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link at.medevit.ecrit.pharmacy_at.model.Report#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Report
