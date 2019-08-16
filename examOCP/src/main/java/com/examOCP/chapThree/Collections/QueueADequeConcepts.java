package com.examOCP.chapThree.Collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class QueueADequeConcepts {

	public static void main(String[] args) {
		
		System.out.println("LINKEDLIST as Queue / Deque : ");
		// Adds elements {0, 1, 2, 3, 4} to queue 
		Queue<Integer> q = new LinkedList<>();  
		for (int i=0; i<5; i++) 
		     q.add(i); 
		
		// Adds elements {0, 1, 2, 3, 4} to dequeue 
		Deque<Integer> d = new LinkedList<>();  
		for (int i=0; i<5; i++) 
		     d.add(i); 
		
		// Display contents of the queue. 
	    System.out.println("Elements of queue-"+q); 
	    System.out.println("Elements of deque-"+d); 
		  
	    // To remove the head of queue and deque. 
	    int removedele = q.remove(); 
	    System.out.println("removed element-" + removedele); 
	  
	    removedele = q.poll();
	    System.out.println("removed poll element-" + removedele); 
		  
	    		
	    removedele = d.removeFirst();
	    removedele = d.removeLast();
	    System.out.println("removed poll element-" + removedele); 
	    
	    removedele = d.pollFirst();
	    removedele = d.pollLast();
	    System.out.println("removed poll element-" + removedele); 
	    
	    System.out.println(q); 
	    System.out.println(d); 
	    
	    
	    // To view the head of queue : Peek returns the head, without deleting 
	    int head = q.peek(); 
	    System.out.println("head of queue-" + head); 
	  
	    head = d.peek(); 
	    System.out.println("head of queue-" + head); 
	  
	    head = d.peekFirst();
	    System.out.println("head of queue-" + head); 
	  
	    head = d.peekLast();
	    System.out.println("head of queue-" + head); 
	  
	    // adding using offer of queue and deque
	    q.offer(6);
	    System.out.println("Elements of queue-"+q); 
	    
	    d.offer(7);
	    d.offerFirst(8);
	    d.offerLast(9);
	    System.out.println("Elements of deque-"+d); 
	    
	    //Examine elements - head in queue
	    System.out.println("Elements of qeque-"+q.element()); 
		
	    //Examine elements - head in dequeue
	    System.out.println("Elements of qeque-"+d.getFirst()); 
	    System.out.println("Elements of qeque-"+d.getLast()); 
		
	    //Collection interface method:
	    int size = q.size(); 
	    System.out.println("Size of queue-" + size); 
	    
	    size = d.size();
	    System.out.println("Size of queue-" + size); 
	    
	    // Iterate through the queue elements. 
        System.out.println("Standard Iterator"); 
        Iterator iterator = q.iterator(); 
        while (iterator.hasNext()) 
            System.out.print("\t" + iterator.next()); 
  
  
        // Reverse order iterator 
        Iterator reverse = d.descendingIterator(); 
        System.out.println("\nReverse Iterator"); 
        while (reverse.hasNext()) 
            System.out.print("\t" + reverse.next()); 
  
        System.out.println("\n\nPRIORITYQUEUE : ");
        // Creating empty priority queue 
        PriorityQueue<String> p = new PriorityQueue<String>(); 

        // Adding items to the pQueue using add() 
        p.add("C"); 
        p.add("C++"); 
        p.add("Java"); 
        p.add("Python"); 
        
        // Printing the most priority element 
        System.out.println("Head value using peek :"
                                           + p.peek()); 
  
        // Printing all elements 
        System.out.println("The queue elements:"); 
        Iterator itr = p.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
  
        // Removing the top priority element (or head)
        p.poll(); 
        System.out.println("After removing an element" + 
                           "with poll function:"); 
        itr = p.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
  
        
        // Removing Java using remove() 
        p.remove("Java"); 
        System.out.println("after removing Java with" + 
                           " remove function:"); 
        itr = p.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
  
        // Check if an element is present using contains() 
        boolean b = p.contains("C"); 
        System.out.println ( "Priority queue contains C " + 
                             "or not?: " + b); 
        
        // Getting objects from the queue using toArray() 
        // in an array and print the array  
        Object[] arr = p.toArray(); 
        System.out.println ( "Value in array: "); 
        for (int i = 0; i<arr.length; i++) 
          System.out.println ( "Value: " + arr[i].toString()) ; 
        
        
        System.out.println("\nARRAYDEQUEUE as Queue / Deque :");
		
        // Intializing an ArrayDeque 
        Deque<Integer> a = new ArrayDeque<Integer>(10); 
        Queue<Integer> aq = new ArrayDeque<Integer>(10); 
        
        // Adds elements {0, 1, 2, 3, 4} to dequeue 
     	for (int i=0; i<5; i++) 
     		a.add(i); 
     		
     	for (Integer element : a) 
        { 
            System.out.println("Element : " + element); 
        }
  
     	System.out.println("Using clear() "); 
     	// clear() method 
        a.clear(); 
        
        // addFirst() method to insert at start 
        a.add(1);
        a.addFirst(1); 
        a.addFirst(3);
       
        // addLast() method to insert at end 
        a.addLast(2); 
        
        System.out.println("Above elements are removed now"); 
        a.removeFirstOccurrence(1);
   
        // Iterator() : 
        System.out.println("Elements of deque using Iterator :"); 
        for(Iterator iter = a.iterator(); itr.hasNext();) 
        { 
            System.out.println(iter.next()); 
        } 
   
        // descendingIterator() : to reverse the deque order 
        System.out.println("Elements of deque in reverse order :"); 
        for(Iterator dItr = a.descendingIterator();  
                                               dItr.hasNext();) 
        { 
            System.out.println(dItr.next()); 
        } 
        
        //examine
        // element() method : to get Head element 
        System.out.println("\nHead Element using element(): " + 
                                             a.element()); 
   
        // getFirst() method : to get Head element 
        System.out.println("Head Element using getFirst(): " +  
                                               a.getFirst()); 
   
        // getLast() method : to get last element 
        System.out.println("Last Element using getLast(): " +  
                                                a.getLast()); 
   
        
        // toArray() method : 
        arr = a.toArray(); 
        System.out.println("\nArray Size : " + arr.length); 
   
        System.out.print("Array elements : "); 
        for(int i=0; i<arr.length ; i++) 
            System.out.print(" " + arr[i]); 
        
        // peek() method : to get head 
        System.out.println("\nHead element : " + a.peek()); 
          
        // poll() method : to get head 
        System.out.println("Head element poll : " + a.poll()); 
          
        // push() method : 
        a.push(265); 
        a.push(984); 
        a.push(2365); 
        
        // remove() method : to get head 
        System.out.println("Head element remove : " + a.remove()); 
        
        System.out.println("The final array is: "+a); 
         
	}

	
}

