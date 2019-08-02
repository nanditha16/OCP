package com.examOCP.chapThree.ArraysAndArrayList;

import java.util.Arrays;
import java.util.Collection;

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
	    	 * Convert array to list
	    	 */
	    	Arrays.asList(intArray4);
	    	
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

		public void arrayListRelated() {
			
		}
		/*
		 * Unused variables, array declaration practice only
		 */
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
	    	Collection[] ca;
	    	
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
    }
}
