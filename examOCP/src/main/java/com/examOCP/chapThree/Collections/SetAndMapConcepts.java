package com.examOCP.chapThree.Collections;

import java.util.*;
import java.util.stream.Collectors;

public class SetAndMapConcepts {
	enum Gfg {
		CODE, LEARN, CONTRIBUTE, QUIZ, MCQ
	};

	class Comparatorbuff implements Comparator<StringBuffer> {

		@Override
		public int compare(StringBuffer s1, StringBuffer s2) {
			return s1.toString().compareTo(s2.toString());

		}

	}

	public static void main(String[] args) {
		System.out.println("\nSET using :");

		// Set demonstration using HashSet
		hashSetPractice();
		// Set demonstration using LinkedHashSet
		linkedHashSetPractice();
		// Set demonstration using EnumSet
		enumSetPractice();
		// Set demonstration using TreeSet
		treeSetPractice();

		System.out.println("\nMAP using :");
		hashMapPractice();

	}

	private static void hashMapPractice() {
		// Set demonstration using HashSet
		System.out.println("\nHashMap :");
		Map<String, Integer> hm = new HashMap<String, Integer>();

		hm.put("a", new Integer(100));
		hm.put("b", new Integer(200));
		hm.put("c", new Integer(300));
		hm.put("d", new Integer(400));

		// Returns Set view
		Set<Map.Entry<String, Integer>> st = hm.entrySet();

		for (Map.Entry<String, Integer> me : st) {
			System.out.print(me.getKey() + ":");
			System.out.println(me.getValue());
			
		}
		
		//If the specified key is not already associated with a value 
		//(or is mapped to null) associates it with the given value and 
		//returns null, else returns the current value.
		hm.putIfAbsent("a", new Integer(1000)); //wont add this, as key is present
		hm.putIfAbsent("e", new Integer(2000));
		System.out.println("putIfAbsent : ex");
		for (Map.Entry<String, Integer> me : st) {
			System.out.print(me.getKey() + ":");
			System.out.println(me.getValue());
			
		}

		testNestedMapPractice();

	}

	private static void testNestedMapPractice() {
		System.out.println("\nNested Map test :");
		Map<String, Map<String, String>> nestedMap = new HashMap<>();

		//test data
		Map<String, String> map1 = new HashMap<>();
		map1.put("100", "type");
		map1.put("200", "algo");
		map1.put("300", "value");

		Map<String, String> map2 = new HashMap<>();
		map2.put("100", "type2");
		map2.put("200", "algo2");
		map2.put("300", "value2");

		Map<String, String> map3 = new HashMap<>();
		map3.put("100", "type3");
		map3.put("200", "algo3");
		map3.put("300", "value3");

		nestedMap.put("1", map1);
		nestedMap.put("2", map2);
		nestedMap.put("3", map3);

		// returns null but if key has null value then using
		// containsKey to validate is much better
		String value = map3.get(4);
		//check this to validate only only non-null values

		try
		{
			if ( map3.containsKey(4)){
				map3.get(4);
			}
		}
		catch (NullPointerException npe)
		{
			System.out.println(npe);
		}

		//flatMap and look for only one particular value
		Optional<Map.Entry<String, String>> flatMapList = nestedMap.entrySet().stream()
				.flatMap(e -> e.getValue().entrySet().stream())
				.filter(e -> e.getKey().equals("300")) //filter on key
				.filter(e-> e.getValue().equals("value")) //filter on value
				.findFirst(); //efficiently stops after finding one item
			//	.collect(Collectors.toList());
		System.out.println(flatMapList);
		System.out.println(flatMapList.get().getValue());

	}

	private static void treeSetPractice() {
		System.out.println("\nTreeSet :");

		TreeSet<String> ts = new TreeSet<String>(); // String implements Comparable already

		// Elements are added using add() method
		ts.add("B");
		ts.add("A");
		ts.add("C");

		// Duplicates will not get insert
		ts.add("C");

		// Sorting Order(Ascending)
		System.out.println(ts);

		// Displaying the lowest element of the set
		System.out.println("The first element is: " + ts.first());

		// Retrieving and removing Last element of the set
		System.out.println("The Last element of the set: " + ts.pollLast());

		/*
		 * StringBuffer Doesn't implement Comparable We will get RunTimeException
		 * :ClassCastException if we use - TreeSet() constructor
		 * 
		 * Should use - TreeSet(Comparator<? super E> comparator) constructor where we
		 * implements Comparator<StringBuffer>
		 * 
		 */
		// TreeSet<StringBuffer> ts1 = new TreeSet<StringBuffer>();

		TreeSet<StringBuffer> ts1 = new TreeSet<StringBuffer>(new SetAndMapConcepts().new Comparatorbuff()); // StringBuffer
																												// Doesn't
		// Elements are added using add() method
		ts1.add(new StringBuffer("A"));
		ts1.add(new StringBuffer("Z"));
		ts1.add(new StringBuffer("L"));
		ts1.add(new StringBuffer("B"));
		ts1.add(new StringBuffer("O"));

		System.out.println(ts1);

	}

	private static void enumSetPractice() {
		System.out.println("\nEnumSet :");
		// Creating a set
		EnumSet<Gfg> set1, set2, set3, set4;

		set1 = EnumSet.of(Gfg.QUIZ, Gfg.CONTRIBUTE, Gfg.LEARN, Gfg.CODE);

		set2 = EnumSet.complementOf(set1);
		set3 = EnumSet.allOf(Gfg.class);
		set4 = EnumSet.range(Gfg.CODE, Gfg.CONTRIBUTE);
		System.out.println("Enum Set 1: " + set1);
		System.out.println("Enum Set 2: " + set2);
		System.out.println("Enum Set 3: " + set3);
		System.out.println("Enum Set 4: " + set4);

	}

	private static void linkedHashSetPractice() {
		System.out.println("\nLinkedHashSet :");

		LinkedHashSet<String> linkedset = new LinkedHashSet<String>();

		// Adding element to LinkedHashSet
		linkedset.add("A");
		linkedset.add("B");
		linkedset.add("C");
		linkedset.add("D");

		// This will not add new element as A already exists
		linkedset.add("A");
		linkedset.add("E");

		System.out.println("Size of LinkedHashSet = " + linkedset.size());
		System.out.println("Original LinkedHashSet:" + linkedset);
		System.out.println("Removing D from LinkedHashSet: " + linkedset.remove("D"));
		System.out.println("Trying to Remove Z which is not " + "present: " + linkedset.remove("Z"));
		System.out.println("Checking if A is present=" + linkedset.contains("A"));
		System.out.println("Updated LinkedHashSet: " + linkedset);

	}

	private static void hashSetPractice() {
		System.out.println("\nHashSet :");

		// Set demonstration using HashSet
		Set<String> h = new HashSet<String>();

		// Adding elements into HashSet usind add()
		h.add("India");
		h.add("Australia");
		h.add("South Africa");
		h.add("India");// adding duplicate elements - will not add again

		// Displaying the HashSet
		System.out.println(h);
		System.out.println("List contains India or not:" + h.contains("India"));

		// Removing items from HashSet using remove()
		h.remove("Australia");
		System.out.println("List after removing Australia:" + h);

		// Iterating over hash set items
		System.out.print("Iterating over list:");
		Iterator<String> i = h.iterator();
		while (i.hasNext())
			System.out.print(i.next() + "\t");

		// Sorting HashSet using List
		List<String> list = new ArrayList<String>(h);
		Collections.sort(list);
		// Print the sorted elements of the HashSet
		System.out.println("\nHashSet elements " + "in sorted order " + "using List: " + list);
		// Check for the empty set
		System.out.println("Is the set empty: " + h.isEmpty());

		Integer arr[] = { 5, 6, 7, 8, 1, 2, 3, 4, 3 };
		// Set demonstration using HashSet Constructor
		Set<Integer> set = new HashSet<>(Arrays.asList(arr));

		// Duplicate elements are not printed in a set.
		System.out.print("\nDuplicate elements: ");
		System.out.println(set);

		// Set demonstration using Collections.addAll
		set = Collections.<Integer>emptySet();
		Collections.addAll(set = new HashSet<Integer>(Arrays.asList(arr)));
		System.out.println(set);

		// initializing set using Collections.unmodifiable set
		set = Collections.unmodifiableSet(new HashSet<Integer>(Arrays.asList(arr)));

		// Duplicate elements are not printed in a set.
		System.out.println(set);

	}

}
