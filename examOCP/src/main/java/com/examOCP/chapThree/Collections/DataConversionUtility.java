package com.examOCP.chapThree.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang.ArrayUtils;

public class DataConversionUtility implements DataConversionInterface{

	/*
	 * Convert int array to array of Integer
	 */
	@Override
	public Integer[] toConvertIntToIntegerArray(int[] intArray) {
		// Case 1: Naive
//		Integer[] integerArray = new Integer[intArray.length];
//		for (int i = 0; i < intArray.length; i++) {
//			integerArray[i] = intArray[i]; //autoboxing
//		}
		
		//OR Case 2: Apache lang library
//		Integer[] integerArray = ArrayUtils.toObject(intArray);
		
		//OR Case 3: Arrays.stream
//		Integer[] integerArray =  Arrays.stream( intArray ).boxed().toArray( Integer[]::new );
		
		//OR Case 4: stream.IntStream
		Integer[] integerArray = IntStream.of( intArray ).boxed().toArray( Integer[]::new );		
		return integerArray;
	}

	/*
	 * Convert Integer array to array of int 
	 */
	@Override
	public int[] toConvertIntegerToIntArray(Integer[] integerArray) {
		//Case 1: Apache lang library
//		int[] intArray = ArrayUtils.toPrimitive(integerArray);
		
		//Case 2: using Arrays.stream 
		int[] intArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
		
		return intArray;
	}

	/*
	 * Convert int array to List of Integers
	 */
	@Override
	public List<Integer> toConvertIntArrayToList(int[] intArray) {
		// case 1: without stream
//		List<Integer> intList = new ArrayList<>(intArray.length);
//		for (int i : intArray) {
//			 intList.add(i); // autoboxing takes place
//			// intList.add(new Integer(i)); // explictly adding as Integer
//		}
		
		// case 2: using Arrays.stream
//		List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		
		// case 3: using stream.IntStream
		List<Integer> intList = IntStream.of(intArray).boxed().collect( Collectors.toList() );			
					
		return intList;
	}

	/*
	 * Convert Integer array to List of Integers
	 */
	@Override
	public List<Integer> toConvertIntegerArrayToList(Integer[] intArray) {
		List<Integer> intList = Arrays.asList(intArray);  
		
		return intList;
	}

	
	/*
	 * Convert string list to array
	 */
	@Override
	public String[] toConvertStringListToArray(List<String> strList) {
		// Case 1: Naive
//		String strArr[] = new String[strList.size()];
//		for(int i =0; i < strList.size(); i++) {
//    		strArr[i] = strList.get(i);
//    	}
		
		// Case 2 : toArray with typeCasting
//		 String[] strArr = (String[]) strList.toArray(new String[0]);	
	    	
		// Case 3 : Arrays.copyOf()
//		String[] strArr = Arrays.copyOf(strList.toArray(), strList.size(), String[].class);

		// Case 4 : System.arraycopy
//		String[] strArr = new String[strList.size()];
//   	 	System.arraycopy(strList.toArray(), 0, strArr, 0, strList.size());
   	 
		// Case 5 : List.stream()
		 String[] strArr = strList.stream().toArray(String[]::new);
   	 	 
		 //System.out.print(Arrays.toString(strArr) + " ");
		return strArr;
	}
	
}
