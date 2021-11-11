package hw03;
/**
 * This class is just used to be able to test the generic methods with a custom Object.
 *  @author Brian Contreras, 400400309, CS-2013, Sections 03 & 04
 *
 */
public class Person implements Comparable<Person> {
	/**
	 * creates a basic int age and String name data field.
	 */
	private int age;
	private String name;
	/**
	 * default constructor
	 */
	public Person() {
		this.age = 20;
		this.name = "The No name";
	}
	/**
	 * Constructor of Person that accepts name and age parameters.
	 * @param age: the age of the person.
	 * @param name: the name of the person.
	 */
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	/**
	 * Overriding to String method to display data better.
	 */
	public String toString() {
		String result = "";
		result += "Hello my name is "+ this.name + " and I am "+this.age+" years old.";
		return result;
	}
	/**
	 * using the compare method to compare Person objects by age 
	 * in order to function properly with other MyArrayMethods
	 * @param o: Person being compared
	 * @return int value of comparison
	 */

	@Override
	public int compareTo(Person o) {
		int returnInt = 0;
		if(this.age > o.age) {
			returnInt = 1;
		}
		if(this.age< o.age) {
			returnInt = -1;
		}
		return returnInt;
	}
}

