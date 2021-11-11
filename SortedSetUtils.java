package hw03;
/**
 * The purpose of this class is to add more functionality to the SortedSet class.
 *  @author Brian Contreras, 400400309, CS-2013, Sections 03 & 04
 *https://calstatela.instructuremedia.com/embed/65a903f7-92d3-45c2-a85b-e09439167ac8
 */
public class SortedSetUtils {
	
	//private default constructor
	/**
	 * This is private to not be able to instantiate this object.
	 */
	private SortedSetUtils() {
		
	}
	//All methods in the class must be generic
	/**
	 * The purpose of this method is to combine to SortedSets without duplicating the values.
	 * The first step is to create a new SortedSet with the size of both SortedSet sizes combined. This is done 
	 * so that the resize method will only be called under the circumstances that both SortedSets do not share any
	 * values at all. The SortedSet will use 2 for loops and add all the values of each SortedSet to 1 set.
	 * The add method from the SortedSet class is used to ensure that no duplicate values will be added into the new
	 * union SortedSet. Once the SortedSet is populated with all the values it will then be returned.
	 * @param <E> This is used to make a method accept generic values.
	 * @param s1 The first SortedSet used.
	 * @param s2 The second SortedSet used.
	 * @return A SortedSet with combined values.
	 */
	public static <E> SortedSet union(SortedSet s1, SortedSet s2) {
		SortedSet unionSet = new SortedSet(s1.size() + s2.size());
		for(int i = 0 ; i < s1.size();i++) {
			unionSet.add(s1.get(i));
		}
		for(int i = 0; i < s2.size();i++) {
			unionSet.add(s2.get(i));
		}
		
		
		return unionSet;
		
	}
	/**
	 * The purpose of this method is to use 2 SortedSets and only add the values of the sortedSets that are not in 
	 * the other SortedSet, for example if both sets contain the value 1, then 1 will be added into the SortedSet.
	 * <b>
	 * The first Step is to use a if else statement to determine which SortedSet has the bigger size, the reason for this 
	 * is if one SortedSet is large than the other then, we will just check the larger array for values of the smaller array to 
	 * ensure that all the values are accounted for. If the value exists in both SortedSets then it will be added into the new SortedSet,
	 * Once done it will return the new SortedSet.
	 * @param <E> generics method
	 * @param s1 The first SortedSet used.
	 * @param s2 The second SortedSEt used.
	 * 
	 * @return The new SortedSet that has values that both of the SortedSets compared had.
	 */
	public static <E> SortedSet intersection(SortedSet s1, SortedSet s2) {
		SortedSet intersectionSet = new SortedSet(s1.size() + s2.size());
		
		if(s1.size() > s2.size()) {
			for(int i = 0; i < s2.size();i++) {
				if(s1.exists(s2.get(i))) {
					intersectionSet.add(s2.get(i));
				}
					
			}
		}
		else {
			for(int i = 0; i < s1.size();i++) {
				if(s2.exists(s1.get(i))) {
					intersectionSet.add(s1.get(i));
				}
			}
		}
		return intersectionSet;
	}
}
