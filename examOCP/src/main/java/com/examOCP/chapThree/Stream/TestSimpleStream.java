package com.examOCP.chapThree.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TestSimpleStream {

	public static void main(String[] args) {
		generateIntegers().forEach(x -> System.out.print(x+", "));
		System.out.println();
		generateOddIntegers().forEach(x -> System.out.print(x+", "));
		System.out.println();
		System.out.println(generateSumOnStream());
		System.out.println();

		Map<String, String> bookAlgos = new HashMap<>();
		bookAlgos.put("555", "abc");
		bookAlgos.put("666", "Algo");
		bookAlgos.put("777", "valid");

		processMapUsingFilter(bookAlgos);
		System.out.println();

		Map<String, String> bookFics = new HashMap<>();
		bookFics.put("555", "abc");
		bookFics.put("666", "Fic");
		bookFics.put("777", "valid");

		List<Map> listMaps;
		listMaps = new ArrayList<>(Arrays.asList(bookAlgos, bookFics));

	}

	public Boolean concatenate(String one, String two){
		if(one.equalsIgnoreCase("Yes")) {
			one += two;
			return true;
		}
		return false;
	}

	public static void processMapUsingFilter(Map<String, String> books) {
		// get the value of the specified key (using filter)
		Optional<String> keySet = books.entrySet().stream()
				.filter(e -> e.getKey().equals("666"))
				.map(Map.Entry::getValue)
				.findFirst();
		System.out.println((String) keySet.get());

	}

	// Are meant to be private and not exposed, so no testing for private
	private static int generateSumOnStream() {
		return IntStream.range(1, 21).filter(x -> x % 2 != 0).sum();
		
	}

	private static Stream<Integer> generateIntegers() {

		IntStream intStream = IntStream.range(1, 21);
		Stream<Integer> boxed = intStream.boxed();
		return boxed;
	}
	
	private static Stream<Integer> generateOddIntegers() {	
		return IntStream.range(1, 21).filter(x -> x % 2 != 0).boxed();
	}
	
}