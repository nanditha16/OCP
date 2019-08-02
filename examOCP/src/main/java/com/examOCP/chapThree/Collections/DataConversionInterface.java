package com.examOCP.chapThree.Collections;

import java.util.List;

public interface DataConversionInterface {

	public Integer[] toConvertIntToIntegerArray(int[] intArray);
	public int[] toConvertIntegerToIntArray(Integer[] integerArray);
	public List<Integer> toConvertIntArrayToList(int[] intArray);
	public List<Integer> toConvertIntegerArrayToList(Integer[] intArray);
	public String[] toConvertStringListToArray(List<String> strList);
}
