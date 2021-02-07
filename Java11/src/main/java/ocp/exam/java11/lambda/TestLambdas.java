package ocp.exam.java11.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import ocp.exam.java11.util.BasicListOperations;


public class TestLambdas {

	public static void main(String[] args) {
		
		//PREDICATE: 1 parameter, boolean return 
		List<String> list = new ArrayList<>();
		list.add("Nand");
		list.add("Sush");
		list.add("Kant");
		list.add("Chan");
		list.add("Ratn");
		testPredicateConsumerOnStringList(list);
		testcallingAPIWithLambda(list);
	}

	private static void testcallingAPIWithLambda(List<String> list) {
		// removeIf() --> sets and Lists , no Maps
		System.out.println("list.removeIf() : removes if predicate results in true");
		List<String> newList = new ArrayList<>(list);
		System.out.println("Input (remove if charAt(0) != 'C') - " + newList);
		newList.removeIf(s -> s.charAt(0) != 'C');
		System.out.println(newList);
		// sort() --> only List(indexed/ordered) , no Set or Map
		
		// directly using list object instead of Collections using Comparator
		System.out.println("list.sort() vs Collections.sort : sorted using Comparator (neg,pos,0) ");
		list.sort((s1, s2) -> -1* s1.compareTo(s2));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		// forEach() --> sets Lists same way (using Consumer), 
		// Maps (using BiConsumer)- ketSet and values (using Consumer as its a a set)
		System.out.println("list.forEach() : using Consumer prints for each elem in list");
		list.forEach(s -> System.out.print(s + " "));
		System.out.println();
		Set<String> fam = Set.of("Mom", "Me", "Sis", "Grandmom", "Aunt");
		fam.forEach(s -> System.out.print(s + " ")); //result is not ordered
		System.out.println();
		Map<String, Integer> map = new HashMap<>();
		map.put("Mom", 65);
		map.put("Me", 35);
		map.put("Sis", 34);
		map.put("Grandmom", 95);
		map.put("Aunt", 66);
		map.forEach((x,y) -> System.out.print(x + "-" + y + ";")); 
		System.out.println();
		map.keySet().forEach(x -> System.out.print(x + " "));
		System.out.println();
		map.values().forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private static void testPredicateConsumerOnStringList(List<String> list) {
		/* 
		 * CASE 1 - Predicate Interface :: checks, validations on parameter sent
		 *  abstract method:: 	boolean test(T t);
		 *  Example with String
		 *  equals signature: 	boolean java.lang.String.equals(Object anObject)
		 *  contains signature: boolean java.lang.String.contains(CharSequence s)
		 *  etc., as we are trying to do some checks on String we are looking for methods within String
		 *  Similarly can create your own class, having methods with similar signature to check
		 *   on the field interest of that particular Class
		 */
		System.out.println("Predicate : (util.function) ");
		print(list, a -> a.equals("Nand"));	 
		print(list, a -> a.contains("K"));
		System.out.println();
		/*
		 * CASE 2 - Consumer interface :: do some actions on the parameter sent
		 * abstract method :: void accept(T t)
		 * Example with string
		 * use the parameter to print like System.out.print
		 */
		System.out.println("Consumer : (util.function) ");		
		Consumer<String> consumer = x -> System.out.print(x);
		print(list, a -> a.contains("K"), consumer);
		
		Consumer<String> consumer2 = x -> System.out.print(x+=x);
		print(list, a -> a.contains("K"), consumer2);
		System.out.println();
		/*
		 * CASE 3 - Supplier interface :: do some actions, no parameter is sent, but returns some data
		 * abstract method :: T get()
		 * Example with string, Integer
		 * return some random value, 
		 */
		System.out.println("Supplier : (util.function) ");
		Supplier<Object> supplier = () -> "Nanditha";
		System.out.println((String)print(supplier));
		Supplier<Object> supplier2 = () -> new Random().nextInt((10 - 1) + 1) + 1; //((max - min) + 1) + min) --> 1-10
		System.out.println((Integer)print(supplier2));
		System.out.println();
		/*
		 * CASE 4 - Comparator interface (util) :: do compare actions on same type 2 parameter is sent, and returns int(-1(less),0(same),+1(more))
		 * abstract method :: int compare(T o1, T o2)
		 * Example with string
		 * 
		 */
		System.out.println("Comparator (util):");
		System.out.println("Input - " + list);
		list.sort((x,y) -> 1 * y.compareTo(x)); //desc
		System.out.println(list);
		list.sort((x,y) -> -1 * y.compareTo(x)); //asc
		System.out.println(list);
		List<Integer> listInt = List.of(99,66,77,88, 0, 1, -8, -99 ); // returns immutable object
		System.out.println("Input - " + listInt);
		System.out.println(BasicListOperations.sortIntegerList(listInt));
		System.out.println();
	}

	private static Object print(Supplier<Object> supplier) {
		return supplier.get();
	}

	private static void print(List<String> list, Predicate<String> checker) {
		for(String eachName : list) {
			if(checker.test(eachName)) {
				System.out.print(eachName  + " ");
			}
		}
		System.out.println();	
	}

	private static void print(List<String> list, Predicate<String> checker, Consumer<String> consumer) {
		for(String eachName : list) {
			if(checker.test(eachName)) {
				consumer.accept(eachName);
			}
		}
		System.out.println();	
	}
	
}
