package hw03;

import java.util.Arrays;
/**
 * This class is created to demonstrate the use of a Dynamic  List and all the additional features that can be added
 * into this data structure. This class created a Generic Dynamic List class that contains Generic constructors
 * and Generic methods.
 *  
 * @author Brian Contreras, 400400309, CS-2013, Sections 03 & 04
 *https://calstatela.instructuremedia.com/embed/65a903f7-92d3-45c2-a85b-e09439167ac8
 * @param <E> refers to E being any data type being accepted and represented as E
 */
public class SortedSet<E extends Comparable<E>> {
	//data fields
	/**
	 * There are 2 data fields, the purpose of the size data field is to be able to have a data field in 
	 * the array that can track the size, if we were to use a method that tracks the size when used throughout the code
	 * it will be very inefficient way of running code.
	 *<b>
	 *The set constructor is essentially the data inside these sortedSets however it is set as private to ensure 
	 *that it can only be used inside this class, setting it to public would not show good practice if using the set 
	 *methods inside the main class.
	 */
	  private int size;
	  private E[] set = (E[])(new Comparable[size]);

	//default constructor
	  /**
	   * This is the default constructor and it will not accept any parameter and just create a 
	   * SortedSet object with a size of 0, no set values, and with a capacity of 10.
	   */
	  public SortedSet() {
		  this.set = (E[])(new Comparable[10]);
		  this.size= 0;
	  }
	  
	  //constructor with capacity parameter
	  /**
	   * This constructor is similar to the default constructor as it essentially creates a empty SortedSet object 
	   * however this constructor accepts a parameter that can set the initial capacity of the data inside the object.
	   * This would be useful if you plan on adding a big data set using a method and if you create a big enough capacity
	   * the resize method will not need to be called.
	   * @param capacity The set capacity.
	   */
    public SortedSet(int capacity) {
        this.set = (E[])(new Comparable[capacity]);
        this.size = 0;
    }
    /**
     * This constructor is accepting a array of values either as an array variable or as a list of objects inside the parameter.
     * This constructor will then determine the capacity by determining the length of the array, or the amount of values placed inside the
     * parameter. This constructor will also use the same value as the capacity to assign the size variable.
     * <b>
     * Once the data fields are set and the capacity and size are set then we will use the Arraycopy method in order to assign all the values 
     * into the set data field.
     * @param values Values entered as either a list of an array variable.
     */
    public SortedSet(E ... values) {
   	 Arrays.sort(values, 0, values.length);
        this.set = (E[])(new Comparable[values.length]);
        this.size = values.length;
        //Make a deep copy to prevent shared references.
        System.arraycopy(values, 0, this.set, 0, values.length);
    }
    /**
     * This constructor will essentially copy another SortedSet by accepting a SortedSet as the parameter. This constructor will use the same
     * capacity and size to create this constructor. 
     * <b>
     * Once the capacity and size is copied we will be using the addAll method in order to copy all of the data from
     * the SortedSet inside the parameter to the newly created SortedSet.
     * @param S
     */
    public SortedSet(SortedSet S) {
    	//the array sort method is not added to this constructor because we are assuming that the array is already sorted from the previous construcotr
    	this.set = (E[])(new Comparable[S.set.length]);
    	this.addAll((E[]) S.set);
    }
    /**
     * This method took me a little while to create but to create this method I used a binary search 
     * Algorithm in order to make the runtime Olog(n).The general explanation is that the data set is separated into 
     * 2 parts initially. Assuming that the set is sorted the first values of the array will contain the lower values 
     * and the second values of the array will contain the higher values. The value that separated these values is known as the middle 
     * value, This value is determined by adding the indexes of the values farthest to the Left and Right, and dividing these values by 2 to 
     * establish a middle point.
     * <b>
     * The first test that is ran is if the middle point is the value we are looking for, if it is then we simply return true and end the 
     * method.
     * <b>
     * If the middle point is not the value that we are looking for then we check if the value is higher or lower than the middle value
     * the reason for this is that we can determining what section of the array is worth checking, since the sections are split into 2.
     * This makes the runtime more efficient.
     * <b>
     * First off since these methods are using generic, the way that we determine if values are greater than, lower than, or equal is 
     * by using the CompareTo method. This method will return a negative number if the value being compared is higher than the first value,
     * if the value is equal it will return a 0, and if the value is less than the first value it will return a positive.
     * <b>
     * So now the middle point is compared to the value that is given by the user. If the middle point has a greater value than 
     * the value given, then values being searched will be cut in half because we will be setting the right boundary, instead of being at 
     * the end of the data set it will be where the midpoint was located, to minimize the values the need to be sorted.
     * <b>
     * If the middle point is less than the value given then it'll essentially be the same process of cutting the values searched in half 
     * except the boundary from the left array will be assigned to the middle point as opposed to the right boundary.
     * <b>
     * If  you look under the else if and else parts of the code you will notice that there are 2 if statements placed inside the code.
     * This is to account for if the value given does not exist, if the value does not exist then as the loop continues the indexR integer
     * that is used will eventually become -1 and this will throw a OutOfBounds exception, so to counter this I decided to use a if statement
     * that checks for the value of -1 and then it will call break in the while loop leaving the method to return false. The same thing is done 
     * for the Left index except instead of the value being -1 it is the length of the array.
     * 
     * @param value The value that is being searched to see if the value exists.
     * @return True if the value exists and false if the  value doesn't.
     */
    public  boolean exists(E value) {
    	if(size > 0) {
    	//First step to this is to try and solve this using a binary search
    	int indexL = 0;
    	int indexR = size-1;
    	E l = this.set[indexL];
    	E r = this.set[indexR];
    	while(l.compareTo(r) <0 || l.compareTo(r) ==0) {
    		E mid = this.set[(indexL + indexR)/2];
    		if (mid.compareTo(value) == 0) {
    			return true;
    		}
    		else if(value.compareTo(mid) <0){
    			indexR = ((indexL + indexR)/2) -1;
    			if(indexR == -1) {
    				break;
    			}
    			r = this.set[indexR];
    		}
    		else {
    			indexL = ((indexL + indexR)/2) +1;
    			if(indexL == size) {
    				break;
    			}
    			l = this.set[indexL];
    		}
    	}
    	}
    	return false;
    }
    /**
     * This method will use the add method multiple times, this will be done by using a for loop
     * with the length of the values chosen. This will allow for the add method fucntionality to be used on a bigger scale
     * while still checking for duplicates and sorting the SortedSet.
     * @param values values added into the SortedSet.
     */
    public void addAll(E ... values) {
    	for(int i = 0 ; i < values.length;i++) {
    		this.add(values[i]);
    	}
    }
    /**
     * This method is used to add a single value into the SortedSet. This is done by first checking 
     * if the value already exists within the array, this is done to make sure than duplicates are not 
     * created. If the value does not exist then we will check if the size is the same as the capacity, which
     * then calls the resize method to be able to add more data into the set witout losing any data. Once resized
     * the value is put into the end of the array, the size data field increases by 1 to account for the new value, and the 
     * Arrays sort method is called to sort the method to make sure all the values are in the right place.
     * @param value the value that is being added into the array.
     */
    public void add(E value) {
    	if(this.exists(value) == false) {
    		if(size == this.set.length) {
    			this.resize();
    		}
    		this.set[size] = (E)value;
    		size++;
    		Arrays.sort(set, 0, size);
    		
    	}
    }
    /**
     * The purpose of this method is to take a value out of a SortedSet.
     * This is done by first checking if the value even exists, if the value doesn't exist then nothing will happen.
     * If the value does exists then it will be placed into a for loop that will check each individual value in the 
     * SortedSet to find the exact index of this value. Once the value is found then it will be set to null and then another for loop will be called
     * to shift the elements to the left to fill in the null. One the value is removed and the SortedSet is shifted the size will just be 
     * subtracted by 1.
     * <b>
     * Since there are 2 for loops inside this method you would think that the runtime is O(n^2), However the runtime is actually O(n),
     * since essentially what is happening here is that the first for loop is finding the index based of N and once it is found the second
     * for loop will complete the rest of the length of N just with a different operation. So this nested for loop is actually O(n).
     * @param value The value that is being removed.
     */
    public void remove(E value) {
    	if(this.exists(value) == true) {
    		for(int i = 0 ; i < this.size;i++) {
    			if(this.set[i].compareTo(value) == 0) {
    				this.set[i] = null;
    				//shift the elements to the left
    				for(int j = i ; j < (this.size - i) ;j++) {
    					int nextIndex = j+1;
    					int currentIndex = j;
    					this.set[j] = this.set[nextIndex];
    					this.set[j+1] = this.set[currentIndex];
    				}
    				break;
    			}
    		}
    		size--;
    	}
    }
    /**
     * The purpose of this array is to get a value from the SortedSet, the only thing that is checked is if 
     * the index is out of bounds and if it is a IndexOutOfBoundsException will be thrown and the method will not return a value.
     * If the index is in bounds then this method becomes a simple getter method.
     * @param index the index in the array where the value wants to be received.
     * @return the E value at a given index 
     */
    public E get(int index) {
    	if(index > size) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	return this.set[index];
    }
    /**
     * This method is essentially a get method for the size of the SortedSet since the Size is a data field
     * @return the Size of the SortedSet.
     */
    public int size() {
    	return this.size;
    }
    /**
     * The purpose of this method is to check if 2 SortedSets are equal.
     * This is done by checking both the size and the values( in the same order).
     * The size is checked by comparing the size data fields from both SortedSets. 
     * Since all the sortedSets will always be sorted from least to greatest then 
     * in order to compare the values there is a count integer created that will go up 
     * for every value that is the same and if the count integer is equal to the size integer then the 
     * second test  Value test becomes true and the method returns true.
     * @param valueSet The SortedSet that wants to be compared.
     * @return True if the SortedSEts are equal
     */
    public boolean equals(SortedSet valueSet) {
    	boolean finalAnswer = false;
    	boolean sizeTest = false;
    	boolean valueTest = false;
    	if(this.size == valueSet.size) {
    		sizeTest = true;
    		int count = 0;
    		for(int i = 0; i < this.size;i++) {
    			if(this.get(i) == valueSet.get(i)) {
    				count++;
    			}
    		}
    		if(count == this.size) {
    			valueTest = true;
    		}
    	}
    	if(sizeTest == true && valueTest == true) {
    		finalAnswer = true;
    	}
    	return finalAnswer;
    }
    /**
     * This toString method will return {} if the SortedSet is empty and if not 
     * the values will be returned separated by commas and will not have a trailing comma.
     * 
     * returns This method returns a String.
     */
    @Override
    public String toString() {
    	String answer = "";
    	if(this.size == 0) {
    		answer = "{ }";
    	}
    	else {
    		for(int i = 0; i < this.size ;i++) {
    			answer += this.set[i];
    			if(i < this.size-1) {
    				answer += ", ";
    			}
    		}
    	}
		return answer;
    	
    }
    /**
     * This resize method is called whenever a value wants to be added and the capacity needs to be increased.
     * This method increases the capacity by creating a resize Set with double the capacity, this is better for 
     * runtime since the resize method will be called less since the capacity increases greatly everytime it is called.
     * <b>
     * Once the set is created with double the capacity then the arraycopy method is called and it will copy all the
     * values from the current set data to the new set data.
     * Once the data is copied this objects set data is now the new set data.
     */
    private void resize() {
    	E[] resizeSet = (E[])(new Comparable[this.set.length * 2 ]);
    	System.arraycopy(this.set, 0, resizeSet, 0, this.set.length);
    	this.set = resizeSet;
    }
}

