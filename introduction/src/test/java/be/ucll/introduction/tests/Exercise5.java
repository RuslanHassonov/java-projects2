package be.ucll.introduction.tests;

import java.util.concurrent.Callable;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Exercise5 {

	//A
	public void testLambda() throws Exception {

		//This is an anonymous inner class. This is the way you would pass in an implementation of an interface
		//or an extension from a (abstract) class pre Java8. From now on you can write the exact same using less
		//code when using Lambda's. Even more, you an use an 'expression' lambda. Rewrite this code using a lambda
		//and make sure the test still works if you run it. If you don't know how, do you see that it is printed in light gray
		//by intellij? Maybe IntelliJ can do this for you?
		executeSomething(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "testing123";
			}
		});
	}

	//B
	public void testMethodReference() throws Exception {

		//Replace the 'null' with a method reference to an EXISTING METHOD within the
		//Java API. Note: you do NOT have to write a lambda or an implementation of the
		//interface, the goal is to use a method expression to an already existing method
		//witin the Java API. the test should run after your modification
		Assert.assertEquals("TESTING123", toUpperCase("testing123", null));
	}

	//------
	//------
	//------ Internal helpers - do not touch - -----
	//------
	//------
	private void executeSomething(Callable<String> callable) throws Exception {
		String s = callable.call();
		Assert.assertEquals(s, "testing123");
	}

	private String toUpperCase(String s, ToUpperCaseFunction toUpperCaseFunction) {
		if (toUpperCaseFunction == null) {
			return s;
		}
		return toUpperCaseFunction.toUpperCase(s);
	}

	@FunctionalInterface
	public interface ToUpperCaseFunction {

		String toUpperCase(String s);
	}
}
