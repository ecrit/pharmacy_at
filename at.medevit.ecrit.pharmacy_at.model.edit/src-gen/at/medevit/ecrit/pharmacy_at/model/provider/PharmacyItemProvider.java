/**
 */
package at.medevit.ecrit.pharmacy_at.model.provider;


import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Pharmacy;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link at.medevit.ecrit.pharmacy_at.model.Pharmacy} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PharmacyItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PharmacyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addAddressPropertyDescriptor(object);
			addStockPropertyDescriptor(object);
			addInvoicesPropertyDescriptor(object);
			addReportsPropertyDescriptor(object);
			addCustomersPropertyDescriptor(object);
			addStockOrdersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_name_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_address_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_address_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__ADDRESS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stock feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStockPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_stock_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_stock_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__STOCK,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Invoices feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInvoicesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_invoices_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_invoices_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__INVOICES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_reports_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_reports_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__REPORTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Customers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCustomersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_customers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_customers_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__CUSTOMERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stock Orders feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStockOrdersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pharmacy_stockOrders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pharmacy_stockOrders_feature", "_UI_Pharmacy_type"),
				 ModelPackage.Literals.PHARMACY__STOCK_ORDERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__ADDRESS);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__STOCK);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__INVOICES);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__REPORTS);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__CUSTOMERS);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__STOCK_ORDERS);
			childrenFeatures.add(ModelPackage.Literals.PHARMACY__LINE_ITEMS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Pharmacy.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Pharmacy"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Pharmacy)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Pharmacy_type") :
			getString("_UI_Pharmacy_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Pharmacy.class)) {
			case ModelPackage.PHARMACY__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.PHARMACY__ADDRESS:
			case ModelPackage.PHARMACY__STOCK:
			case ModelPackage.PHARMACY__INVOICES:
			case ModelPackage.PHARMACY__REPORTS:
			case ModelPackage.PHARMACY__CUSTOMERS:
			case ModelPackage.PHARMACY__STOCK_ORDERS:
			case ModelPackage.PHARMACY__LINE_ITEMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__ADDRESS,
				 ModelFactory.eINSTANCE.createAddress()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__STOCK,
				 ModelFactory.eINSTANCE.createStock()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__INVOICES,
				 ModelFactory.eINSTANCE.createInvoice()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__REPORTS,
				 ModelFactory.eINSTANCE.createReport()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__CUSTOMERS,
				 ModelFactory.eINSTANCE.createCustomer()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__STOCK_ORDERS,
				 ModelFactory.eINSTANCE.createStockOrder()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PHARMACY__LINE_ITEMS,
				 ModelFactory.eINSTANCE.createLineItems()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Pharmacy_atEditPlugin.INSTANCE;
	}

}
