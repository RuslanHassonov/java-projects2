package be.ucll.introduction.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * See the exercises PDF for instructions
 * <p>
 * Bottom line: only ADD code, do NOT CHANGE or DELETE code. After your modifications, the tests should all run
 */

@Test
public class Exercise6 {
	public void testSortLastNameAZ() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Georgia", "Gonzalez"));
		persons.add(new Person("John", "Doe"));
		persons.add(new Person("Scott", "Tiger"));
		persons.add(new Person("Kimberley", "McCormick"));
		persons.add(new Person("Ryan", "Hatfield"));
		persons.add(new Person("Maria", "Bartley"));

		//TODO Sort the list (See the exercises PDF for instructions)

		Assert.assertEquals(persons.get(0), new Person("Maria", "Bartley"));
		Assert.assertEquals(persons.get(1), new Person("John", "Doe"));
		Assert.assertEquals(persons.get(2), new Person("Georgia", "Gonzalez"));
		Assert.assertEquals(persons.get(3), new Person("Ryan", "Hatfield"));
		Assert.assertEquals(persons.get(4), new Person("Kimberley", "McCormick"));
		Assert.assertEquals(persons.get(5), new Person("Scott", "Tiger"));
	}

	public void testSortLastNameZA() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Georgia", "Gonzalez"));
		persons.add(new Person("John", "Doe"));
		persons.add(new Person("Scott", "Tiger"));
		persons.add(new Person("Kimberley", "McCormick"));
		persons.add(new Person("Ryan", "Hatfield"));
		persons.add(new Person("Maria", "Bartley"));

		//TODO Sort the list (See the exercises PDF for instructions)

		Assert.assertEquals(persons.get(5), new Person("Maria", "Bartley"));
		Assert.assertEquals(persons.get(4), new Person("John", "Doe"));
		Assert.assertEquals(persons.get(3), new Person("Georgia", "Gonzalez"));
		Assert.assertEquals(persons.get(2), new Person("Ryan", "Hatfield"));
		Assert.assertEquals(persons.get(1), new Person("Kimberley", "McCormick"));
		Assert.assertEquals(persons.get(0), new Person("Scott", "Tiger"));
	}

	public void testSortFirstNameWithinLastNameAZ() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Georgia", "Gonzalez"));
		persons.add(new Person("Anna", "Gonzalez"));
		persons.add(new Person("John", "Doe"));
		persons.add(new Person("Scott", "Tiger"));
		persons.add(new Person("Kimberley", "McCormick"));
		persons.add(new Person("Ryan", "Hatfield"));
		persons.add(new Person("Maria", "Bartley"));
		persons.add(new Person("Evan", "Doe"));

		//TODO Sort the list (See the exercises PDF for instructions)

		Assert.assertEquals(persons.get(0), new Person("Maria", "Bartley"));
		Assert.assertEquals(persons.get(1), new Person("Evan", "Doe"));
		Assert.assertEquals(persons.get(2), new Person("John", "Doe"));
		Assert.assertEquals(persons.get(3), new Person("Anna", "Gonzalez"));
		Assert.assertEquals(persons.get(4), new Person("Georgia", "Gonzalez"));
		Assert.assertEquals(persons.get(5), new Person("Ryan", "Hatfield"));
		Assert.assertEquals(persons.get(6), new Person("Kimberley", "McCormick"));
		Assert.assertEquals(persons.get(7), new Person("Scott", "Tiger"));
	}

	public void testSortLastNameReduceCharsAZ() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Georgiä", "Gonzaléz"));
		persons.add(new Person("John", "Ðoê"));
		persons.add(new Person("Scott", "Tíger"));
		persons.add(new Person("Kimberley", "McCormick"));
		persons.add(new Person("Ryàn", "Ĥatfïeld"));
		persons.add(new Person("Maria", "Bartley"));

		//TODO Sort the list. Yes, this is a tricky one :-) (See the exercises PDF for instructions)

		Assert.assertEquals(persons.get(0), new Person("Maria", "Bartley"));
		Assert.assertEquals(persons.get(1), new Person("John", "Ðoê"));
		Assert.assertEquals(persons.get(2), new Person("Georgiä", "Gonzaléz"));
		Assert.assertEquals(persons.get(3), new Person("Ryàn", "Ĥatfïeld"));
		Assert.assertEquals(persons.get(4), new Person("Kimberley", "McCormick"));
		Assert.assertEquals(persons.get(5), new Person("Scott", "Tíger"));
	}

	//TODO complete this class
	private class Person {

		public Person(String firstName, String lastName) {
		}
	}
}

