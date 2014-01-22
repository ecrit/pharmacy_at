package at.medevit.ecrit.pharmacy_at.application;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.medevit.ecrit.pharmacy_at.application.impl.ApplicationPackageImpl;

public class SampleApplication {

	static ApplicationFactory factory = ApplicationFactory.eINSTANCE;
	static Resource resource = null;

	public static Resource getSampleApplication() {
		if (resource == null) {
			ApplicationPackageImpl.init();
			initSampleApplication();
		}
		return resource;
	}

	public static Users getUsers() {
		Resource u = getSampleApplication();
		return (Users) u.getContents().get(0);
	}

	private static void initSampleApplication() {
		ResourceSet resSet = new ResourceSetImpl();
		// Create a resource
		resource = resSet.createResource(URI
				.createURI("pharmacy_at/my.application"));

		Users users = initUsers();

		resource.getContents().add(users);

	}

	private static Users initUsers() {
		Users users = factory.createUsers();

		User u1 = factory.createUser();
		u1.setName("lucia");
		u1.setPassword("passwd1");
		u1.getRole().add(UserRole.SELLER);
		u1.getRole().add(UserRole.STOCKIST);

		User u2 = factory.createUser();
		u2.setName("marco");
		u2.setPassword("passwd2");
		u2.getRole().add(UserRole.CLERK);
		u2.getRole().add(UserRole.STOCKIST);

		User u3 = factory.createUser();
		u3.setName("tom");
		u3.setPassword("passwd3");
		u3.getRole().add(UserRole.SYSADMIN);

		User u4 = factory.createUser();
		u4.setName("james");
		u4.setPassword("passwd4");
		u4.getRole().add(UserRole.STOCKIST);
		u4.getRole().add(UserRole.CLERK);

		User u5 = factory.createUser();
		u5.setName("rumpelstilzchen");
		u5.setPassword("passwd5");
		u5.getRole().add(UserRole.SELLER);
		u5.getRole().add(UserRole.CLERK);

		users.getUsers().add(u1);
		users.getUsers().add(u2);
		users.getUsers().add(u3);
		users.getUsers().add(u4);
		users.getUsers().add(u5);

		return users;
	}

}
