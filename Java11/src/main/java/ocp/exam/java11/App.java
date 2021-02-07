package ocp.exam.java11;

import java.util.ArrayList;
import java.util.List;

import ocp.exam.java11.util.BasicListOperations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        listOperations();
        
        
    }

	private static void listOperations() { 
		List<Integer> list = List.of(99,66,77,88, 0, 1, -8, -99 ); // returns immutable object
		list =  BasicListOperations.sortIntegerList(list);
		System.out.println(list);
	}
}
