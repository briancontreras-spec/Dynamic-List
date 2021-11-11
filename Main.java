package hw03;
/**
 * The purpose of this class is to effectively display every method in the SortedSet class.
 *  @author Brian Contreras, 400400309, CS-2013, Sections 03 & 04
 *https://calstatela.instructuremedia.com/embed/65a903f7-92d3-45c2-a85b-e09439167ac8
 */
public class Main {
	public static void main(String[] args) {
		//creating Variables to test with a custom class.
		Person p1 = new Person(1, "Brian");
		Person p2 = new Person(2, "Leslie");
		Person p3 = new Person(3, "Domincik");
		Person p4 = new Person (4, "Mother");
		Person p5 = new Person(5, "Father");
		Person p6 = new Person(6 , "Jessica");
		Person p7 = new Person(10, "Carlos");
		//creating integer variables to test with integers.
		Integer[] intArr = {1,2,3,4,5};
		Integer[] intArr1 = {6,7,8,9,10};
		//creating String variables to test with String values.
		String[] stringArr = {"Leslie", "Brian", "Dominick","Mother","Father"};
		String[] stringArr1 = {"noName", "Leslie", "Brian", "RandomName", "PlaceHolder"};	
		//testing the  Custom Class Array;
		Person[] personArr = {p1,p2,p3,p4,p5};
		Person[] personArr1 = {p1,p3,p5,p6,p7};
		//Testing the Double variables to test with double values.
		Double[] doubleArr = {1.0,2.0,3.0,4.0,5.0};
		Double[] doubleArr1 = {6.0,7.0,8.0,9.0,10.0};
		
		/**
		 * Testing the Constructors
		 */
		//default Constructor
		SortedSet defaultConstruct = new SortedSet();
		//Constructor with capacity parameter.
		SortedSet capacityConstructor = new SortedSet(10);
		//Constructor with comma separated list of generic values
		//Test with array
		SortedSet commaSetConstructor = new SortedSet(intArr);
		//Test with comma separated list
		SortedSet commaSetConstructor1 = new SortedSet(10,20,30,40,50);
		//Constructor with SortedSet parameter
		SortedSet sortedConstructor = new SortedSet(commaSetConstructor);
		
		/**
		 * Testing the public methods
		 */
		//testing the exists method
		SortedSet intSet = new SortedSet(intArr);
		System.out.println("Testing the Exists method: \n" +intSet + "\n");
		//checking if the the value of 1 and 6 exists
		System.out.println("Does 1 exist in the SortedSet: " + intSet.exists(1));
		System.out.println("Does 6 exists in the SortedSet: " + intSet.exists(6));
		System.out.println();
		//Testing the add value
		System.out.println("Testing the add method \nOriginal Set:\n"+ intSet);
		//adding 10 to the list
		intSet.add(10);
		System.out.println("Adding 10 to the list:\nNew Set:\n"+intSet + "\n");
		//Testing the addAll value
		System.out.println("Testing the addAll method\nUsing a empty SortedSet:\n"+defaultConstruct);
		defaultConstruct.addAll(doubleArr1);
		System.out.println("Adding the doubleArr1 to the empty SortedSet\nSame SortingSet with added values:\n" + defaultConstruct + "\n");
		//Testing the remove value
		System.out.println("Testing the remove method\nWe will test this method by removing values from the first index, last index, and a index in the middle, To ensure functionality.\nUsing the SortedSet with added values from the previous method:\n" + defaultConstruct + "\n");
		defaultConstruct.remove(6.0);
		System.out.println("removing the 6.0 value from the set\nNew List with removed first index:\n" + defaultConstruct + "\n\nremoving the 10.0 from the set");
		defaultConstruct.remove(10.0);
		System.out.println("New List with removed last index\n"+defaultConstruct+"\n\nremoving the 8.0 value from the set\nNew list with removed middle index");
		defaultConstruct.remove(8.0);
		System.out.println(defaultConstruct + "\n");
		//Testing out the get methods
		SortedSet stringSet = new SortedSet(stringArr);
		System.out.println("Testing the get method\nHere is the complete SortedSet of strings\n" + stringSet+"\nI am going to get the index of 3:\n" + stringSet.get(3) + "\n");
		System.out.println("Testing the get method with a index that is out of bounds(10)");
		try {
			System.out.println(stringSet.get(10));
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e + "\n");
		}
		//Testing the size method
		System.out.println("Testing out the size method\nhere is the array I will be using as reference\n" + intSet + "\nHere is the size of the SortedSet: " + intSet.size() + "\n");
		//Testing the equals method
		System.out.println("Testing out the equals method by comparing the same SortedSet, and the comparing 2 different SortedSets\nThe set I will compare to itself is the intSet:\n" + intSet);
		System.out.println("intSet equals to intSet is: " + intSet.equals(intSet) +"\nNow I will be comparing intSet to default constructor from the previous methods\n" + defaultConstruct);
		System.out.println("intSet equals defaultConstruct: " + intSet.equals(defaultConstruct) + "\n");
		//Testing the toString method
		System.out.println("I will be testing the toString method however I have been using throughout all these examples, but I will use it again just as a example\nI will print out the sortedConstructor: \n" + sortedConstructor + "\n");
		//Testing the resizeMethod
		System.out.println("This method is a little difficult to demonstrate since I dont' have access to the set data field in the main method\nSo I hope that the description  in the SortedSet class using the resize method is a good example of testing.\n" );
		//Testing the union method
		System.out.println("Now I will be testing the union method in the SortedSetUtil class\nThe sortedSet that I will be using are the example SortedSets");
		SortedSet unionTest1 = new SortedSet(1, 2, 3, 4, 5);
		SortedSet unionTest2 = new SortedSet(1, 3, 5, 6, 10);
		System.out.println("I will be using these SortedSet objects: " + unionTest1 + " and " + unionTest2 );
		SortedSet unionTestComplete = SortedSetUtils.union(unionTest1, unionTest2);
		System.out.println(unionTestComplete + "\n");
		//Testing the intersection method
		System.out.println("Now I will be testing the intersection method in the SortedSetUtil class\nI will be using the examples provided");
		SortedSet intersectionTest1 = new SortedSet(1, 2, 3, 4, 5);
		SortedSet intersectionTest2 = new SortedSet(1, 3, 5, 6, 10);
		System.out.println("I will be using these sets for the first example: " + intersectionTest1 + " and " + intersectionTest2);
		SortedSet intersectionExample1 = SortedSetUtils.intersection(intersectionTest1, intersectionTest2);
		System.out.println("Here is the answer: " + intersectionExample1 + "\n\n");
		SortedSet intersectionTest3 = new SortedSet(1, 2, 3);
		SortedSet intersectionTest4 = new SortedSet(7, 20, 42);
		System.out.println("This is the next set of SortedSets I'll test the intersection method with " + intersectionTest3 + " and " + intersectionTest4);
		SortedSet intersectionExample2 = SortedSetUtils.intersection(intersectionTest3, intersectionTest4);
		System.out.println("Here is the answer: " + intersectionExample2);
		
		
		
	}
}
