package com.examOCP.chapThree.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang.ArrayUtils;

/**
 * Hello world!
 *
 */
public class ArraysAndArrayListConcepts 
{
	public class MyClass {
		public void arrayRelated() {
			/*
			 * Different ways to declare and initialize 
			 */
			initializeArrayExamples();
			
			// initializing memory allocation and declare with default values
			String[] stringArray2 = new String[2];
	    	
			/*
	    	 * Array literals - 
	    	 * where the size of the array and 
	    	 * variables of array are already known
	    	 */
	    	//String literals array
	    	String[] stringArray4 = new String[]{"cat","dog"};
	    	String[] stringArray5 = {"fat","ball"};
	    	
	    	int[] intArray3 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
	    	int[] intArray4 = { 1,2,3,4,5,6,7,8,9,10 };
	    	
	    	/*
	    	 * Cloning of arrays - should be initialized
	    	 * 
	    	 * for 1D - deep copy is one
	    	 * for MultiD - shallow copy -  sub-arrays are shared 
	    	 */
	    	int cloneArray[] = intArray4.clone(); 
	    	System.out.println("1D - deep copy is one : ");
	    	
	    	System.out.println("intArray4 == cloneArray : "+ (intArray4 == cloneArray)); //will be false
	    	System.out.println("Arrays.equals(intArray4, cloneArray) : " + (Arrays.equals(intArray4, cloneArray)));
	    	int intArray7[][] = {{1,2,3},{4,5}};
	    	int cloneArray2[][] = intArray7.clone(); 
	    	System.out.println("for MultiD - shallow copy -  sub-arrays are shared :");
	    	System.out.println("intArray7 == cloneArray2 : " + (intArray7 == cloneArray2)); //will be false
	    	System.out.println("intArray7[0] == cloneArray2[0] : " +(intArray7[0] == cloneArray2[0])); // will be true
	        System.out.println(Arrays.toString(intArray7));
	    	
	    	Arrays.toString(intArray7);   	
	    	Arrays.binarySearch(stringArray4, "cat");
	    	Arrays.copyOf(intArray3, 3);
	    	Arrays.copyOfRange(intArray3, 3, 4);
	    	Arrays.fill(stringArray2, "Example"); // filling in an initialized array
	    	
//	    	Arrays.spliterator(array)
//	    	Arrays.setAll(array, generator);
  	    	
	    	/*
	    	 * To access Array elements
	    	 */
	    	System.out.println("\nTo access Array elements : ");
	    	for (int i = 0; i < intArray4.length; i++) {
	    		  System.out.print(intArray4[i]+ " ");
	    	}
	    	
	    	System.out.println("\nBefore Sorting");
	    	
	    	for(String str : stringArray5) {
	    		 System.out.print(str + " "); //sorted earlier
	    	}
	    	
	    	System.out.println("\nAfter Sorting");
	    	Arrays.sort(stringArray5);
	    	Arrays.parallelSort(stringArray5);
	    	
	    	Arrays.stream(stringArray5) 
            .forEach(e->System.out.print(e + " "));
	    	
		}

		private void conversions() {
			int[] intArray = new int[] {1,2,3,4,5};
			Integer[] integerArray = { 1,2,3,4,5,6,7,8,9,10 };
			List<String> strList = new ArrayList<>();
	    	strList.add("Dat");
	    	strList.add("Fat");
	    	strList.add("Eat");
	    	strList.add("Bat");
	    	strList.add("Ant");
	    	strList.add("Cat");
	    	
			/*
			 * Convert int[] array to Integer[] array
			 */
			System.out.print("\n case 1: Converting int[] to Integer[] : ");
			//case 1:
			Integer[] integerArray1 = new Integer[intArray.length];
			// case 1 - display using loop
			for (int i = 0; i < intArray.length; i++) {
				integerArray1[i] = intArray[i]; //auto boxing
				System.out.print(integerArray1[i]+" ");
			}
			
			
			//case 2: using Apache lang library
			System.out.print("\n case 2: Converting int[] to Integer[] using Apache lang library : ");
			Integer[] integerArray2 = ArrayUtils.toObject(intArray);
			// case 2 - Arrays.toString
			System.out.print(Arrays.toString(integerArray2) + " ");
			
			
			//case 3: using Arrays.stream
			System.out.print("\n case 3: Converting int[] to Integer[] using Arrays.stream : ");
			Integer[] integerArray3 = Arrays.stream( intArray ).boxed().toArray( Integer[]::new );
			System.out.print(Arrays.toString(integerArray3) + " ");
			
			//case 4: using stream.IntStream
			System.out.print("\n case 4: Converting int[] to Integer[] using stream.IntStream : ");
			Integer[] integerArray4 = IntStream.of( intArray ).boxed().toArray( Integer[]::new );
			System.out.print(Arrays.toString(integerArray4) + " ");
			
			
			/*
			 * Convert Integer[] array to int[] array
			 */
			
			System.out.print("\n case 1: Convert Integer[] to int[] using Apache lang library : " );
			int[] intArray1 = ArrayUtils.toPrimitive(integerArray);
			System.out.print(Arrays.toString(intArray1) + " ");
			
			System.out.print("\n case 2: Convert Integer[] to int[] using Arrays.stream : " );
			int[] intArray2 = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
			System.out.print(Arrays.toString(intArray2) + " ");
				
			/*
			 * Convert int array to list of Integer
			 */
			//List<int> intPrimitiveList = Arrays.asList(intArray); // compiler error - cannot do this
			// case 1: without stream
			List<Integer> intList = new ArrayList<>(intArray.length);
			for(int i : intArray) {
				//intList.add(i); // autoboxing takes place
				intList.add(new Integer(i)); // explictly adding as Integer
			}
			System.out.print("\n case 1: Converted int[] to List<Integer> with Integer explictlywithout stream : " + intList + " ");
			
			// case 2: using Arrays.stream
			List<Integer> list11 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
			System.out.print("\n case 2: Converted int[] to List<Integer> using Arrays.stream with Integer autoboxing : "+ list11 + " ");
			
			// case 3: using stream.IntStream
			list11 = IntStream.of(intArray).boxed().collect( Collectors.toList() );
			System.out.print("\n case 3: Converted int[] to List<Integer> using stream.IntStream with Integer autoboxing : "+ list11 + " ");
			
			
			/*
	    	 * Convert Integer array to list of Integer
	    	 */
			List<Integer> intList2 = Arrays.asList(integerArray);  
			
			System.out.println("\n\n Case 1: Converted Integer[] to List<Integer> with Integer  : "+intList2); 
			
			//intList.add(11); // UnsupportedOperationException - add operation is not supported by this list
			//intList.remove(0); // UnsupportedOperationException - remove operation is not supported by this list
			
			/*
	    	 * Convert string list to array
	    	 */
			// Case 1: Naive - Adding one by one
			System.out.print("\n Case 1: Converted List<String> to String[] by Adding one by one: ");
	    	String strArr1[] = new String[strList.size()];
	    	for(int i =0; i < strList.size(); i++) {
	    		strArr1[i] = strList.get(i);
	    	}
	    	System.out.print(Arrays.toString(strArr1) + " "); 
		  	
	    	// Case 2 : Arrays.toString with typeCasting
	    	System.out.print("\n Case 2: Converted List<String> to String[] using Arrays.toString with typeCasting: ");
		    String[] strArr2 = (String[]) strList.toArray(new String[0]);	
	    	System.out.print(Arrays.toString(strArr2) + " ");

	    	// Case 3 : list.stream()
	    	System.out.print("\n Case 3: Converted List<String> to String[] using list.stream(): ");
	    	 String[] strArr3 = strList.stream().toArray(String[]::new);
	    	 System.out.print(Arrays.toString(strArr3) + " ");
	    	 
	    	// Case 4 : Arrays.copyOf()
	    	 System.out.print("\n Case 4: Converted List<String> to String[] using Arrays.copyOf(): ");
	    	 String[] strArr4 = Arrays.copyOf(strList.toArray(), strList.size(), String[].class);
	    	 System.out.print(Arrays.toString(strArr4) + " ");
		    	
	    	// Case 5 : System.arraycopy
	    	 System.out.print("\n Case 5: Converted List<String> to String[] using System.arraycopy: ");
	    	 String[] strArr5 = new String[strList.size()];
	    	 System.arraycopy(strList.toArray(), 0, strArr5, 0, strList.size());
	    	 System.out.print(Arrays.toString(strArr5) + " ");
		    
		}

		public void arrayListRelated() {
			System.out.println("\n\n ARRAYLIST");
			
			/*
			 * Different ways to declare and initialize 
			 */
			initializeArrayListExamples();
			
			//Empty List default to null and 0
			List<String> strList = new ArrayList<>();
			ArrayList<Integer> intList = new ArrayList<>();
		
			// adding elements Empty List, initializing
			strList.add("Ant");
			strList.add("Bat");
			strList.add("Cat");
			
			//strList.add(5, "Dat"); // Will through IndexOutOfBoundsException: Index: 5, Size: 3
			strList.add(0, "Dat"); 
			System.out.println("strList " + strList.size() + " : " +strList);
			
	    	
			for(int i = 0; i < 5; i++) {
				intList.add(i); //autoboxing
			}
			
			//Overridden toString
			System.out.println("strList " + strList.size() + " : " +strList);
			System.out.println("intList " + intList.size() + " : " +intList);
			
			//To remove an element by index
			intList.remove(0);
			System.out.println("intList " + intList.size() + " : " +intList);
			
			//To remove an element vy it's value
			intList.remove(new Integer(4));
			System.out.println("intList " + intList.size() + " : " +intList);
			
			// remove on condition
			//strList.removeIf(filter);
			
			//Set 2nd element to Hat
			strList.set(2, "Hat");
			
			System.out.println("Sublist from 0-2 excluding 2: " + strList.subList(0, 2));
			
			//To access element using get()
			System.out.print("list.get(index) : "+ strList.get(0)+" "+ intList.get(0));
			
			
			// To sort
			Collections.sort(strList);
			System.out.println("\nstrList sorted " + strList.size() + " : " +strList);
			
			// Binary search on sorted List
			System.out.println("Binary Search of \"Dat\": " + Collections.binarySearch(strList, "Dat"));
			
			// To reverse
			Collections.reverse(strList);
			System.out.println("strList reversed " + strList.size() + " : " +strList);

			// Rotate a list
			Collections.rotate(strList, 2);
			System.out.println("Rotate of 2 on list: " + strList);
			
			//Swap
			Collections.swap(strList, 0, 3);
			System.out.println("swap of 0 with 3 on list: " + strList);
			
			//shuffle - Randomly permutes the specified list using a default source of randomness.
			Collections.shuffle(strList);
			System.out.println("shuffle on list: " + strList);
			
			//replaceAll
			Collections.replaceAll(strList, "Dat", "Eat");
			System.out.println("replaceAll on list: " + strList);
			
			
		}
		
		/*
		 * Unused variables, arrayList declaration practice only
		 */
		@SuppressWarnings("unused")
		private void initializeArrayListExamples() {
			/*
	         * Declaring an Array
	         */
			List<String> stringList;
			ArrayList<Integer> intList;
			List<Boolean> boolList;
			List<Long> longList;
			List<Double> doubleList;
			List<Character> charList;
			
			// an arrayList of references to objects of a class 
			List<MyClass> myclassList;
			
			// arrayList of Objects
			List<Object> objList;
			
			// arrayList of Collections
	    	List<Collection<Integer>> collList;
	    	
	    	// List of List
	    	List<List<Integer>> intList2;
	    	
	    	/*
	    	 * Instantiating an ArrayList while declaring with some capacity
	    	 * i.e empty list 
	    	 * 
	    	 */
	    	List<String> strList = new ArrayList<>();
	    	ArrayList<Integer> intList3 = new ArrayList<Integer>(5);
	    	ArrayList<Integer> intList4 = new ArrayList<>(5);
	    	
		}

		/*
		 * Unused variables, array declaration practice only
		 */
		@SuppressWarnings("unused")
		private void initializeArrayExamples() {
			/*
	         * Declaring an Array
	         */
	    	// primitives
	    	int intArray[]; 
	    	int[] intArray2; 
	    	boolean booleanArray[];
	    	long longArray[];
	    	float floatArray[];
	    	double doubleArray[];
	    	char charArray[];
	    	
	    	// an array of references to objects of a class 
	    	MyClass myClassArray[];
	    	
	    	// array of Objects
	    	Object[]  ao;
	    	
	    	// array of Collections
	    	Collection<String>[] ca;
	    	
	    	// 2D array
	    	int[][] intArray5 = new int[10][20];
	    	
	    	// 3D array
	    	int[][][] intArray6 = new int[10][20][10];
	    
	    	// String array
	    	String[] stringArray;
	    	String[] stringArray3 = new String[]{};
	    	
	    	/*
	    	 * Instantiating an Array while declaring with some capacity
	    	 * var-name = new type [size];
	    	 * 
	    	 */
	    	byte byteArray[] = new byte[2];
	    	
	    	/*
	    	 * Declare and then initialize
	    	 */
	    	short shortsArray[];
	    	shortsArray = new short[2];
	    	
		}
	
	}
	
    public static void main( String[] args )
    {
    	MyClass innerClass = new ArraysAndArrayListConcepts().new MyClass();
    	innerClass.arrayRelated();
    	innerClass.arrayListRelated();
    	innerClass.conversions();
    }
}
