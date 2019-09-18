package be.ucll.introduction.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;

import be.ucll.introduction.annotations.ImASecuredClass;

@Test
public class Exercise2 {

	public void scanForClassesWithSecuredAnnotations() throws Exception {
		List<String> include = new ArrayList<String>();
		include.add(".*");

		Object[] results = new Object[2];
		for (String processorClassName : PackageUtils.findClassesInPackage("be.ucll.introduction.annotations", include, new ArrayList<String>())) {
			Class<?> clazz = Class.forName(processorClassName);

			// Create an annotation called "Secured" (put it in the already existing 'annotations' package), give it a property "role"
			// Put the annotation on the already existing "ImASecuredClass" also in the annotations package, and give the role property a value "admin".

			// Filter the classes here with reflection so that when the "clazz" variable is the 'ImASecuredClass', the annotation is read from that class.
			// Add it's class name (which will of course be 'ImASecuredClass') to the first position of the arrray and the 'role' property (read from the annotation)
			// is added to the second position of the array.

			//So basically (in pseudo)
			// if clazz equals the 'ImASecuredClass' clazz
			// then: read the annotation 'Secured' from that class
			// 		 and: retrieve the class from that annotation, assign it to results[0]
			// 		 and: retrieve the property 'role' from that annotation and assign it's value to results[1]

			// Resume:
			// results[0] = the class which has the annotation (which will of course be 'ImASecuredClass')
			// results[1] = the value of the 'role' property parsed from the annotation on the class

			//Note: of course you can simply do: results[0]=ImASecuredClass.class and results[1]="admin", and the test will succeed. The goal is however
			//not to do that but to use the API for getting the annotation of the ImASecuredClass class, using the API to get the classname and the 'role' property
		}

		Assert.assertEquals(results[0], ImASecuredClass.class);
		Assert.assertEquals(results[1], "admin");
	}
}
