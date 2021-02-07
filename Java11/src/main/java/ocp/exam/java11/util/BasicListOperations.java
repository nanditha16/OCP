package ocp.exam.java11.util;

import java.util.ArrayList;
import java.util.List;

public class BasicListOperations {

	public static List<Integer> sortIntegerList(List<Integer> list) {
		List<Integer> newList = new ArrayList<>(list); // To make it mutable 
		int multiplier = -1;
		try {
			newList.sort((x,y) -> multiplier * y.compareTo(x));
			return newList;
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
