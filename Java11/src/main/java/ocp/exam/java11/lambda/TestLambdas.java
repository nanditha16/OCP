package ocp.exam.java11.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
