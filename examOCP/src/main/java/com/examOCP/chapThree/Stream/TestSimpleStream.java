package com.examOCP.chapThree.Stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestSimpleStream {

	public static void main(String[] args) {
		generateIntegers().forEach(x -> System.out.print(x+", "));
		System.out.println();
		generateOddIntegers().forEach(x -> System.out.print(x+", "));
		System.out.println();
		System.out.println(generateSumOnStream());
		
	}

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