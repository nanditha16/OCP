package com.examOCP.chapThree.Collections;

import java.util.Arrays;

public class ArraysConcepts {

	public static void main(String[] args) {
		fillConcept();
		sortConcept();
		
	}

	private static void sortConcept() {
		// TODO Auto-generated method stub
		
	}

	public static void fillConcept() {
		// Filling - int[], long[], short[], char[], byte[], float[], double[], boolean[], Object[]
		
		int[] a = new int[5];
		fillSimpleConcept(a);
		System.out.println("fill(int[] a, int val) : " + Arrays.toString(a));
		fillRangeConcept(a);
		System.out.println("fill(int[] a, int fromIndex, int toIndex, int val) : " + Arrays.toString( a));
		
		long[] b = new long[5];
		fillSimpleConcept(b);
		System.out.println("fill(long[] b, long val) : " + Arrays.toString(b));
		fillRangeConcept(b);
		System.out.println("fill(long[] b, long fromIndex, long toIndex, long val) : " + Arrays.toString(b));
		
		short[] c = new short[5];
		fillSimpleConcept(c);
		System.out.println("fill(short[] c, short val) : " + Arrays.toString(c));
		fillRangeConcept(c);
		System.out.println("fill(short[] c, short fromIndex, short toIndex, short val) : " + Arrays.toString(c));
	
		char[] d = new char[5];
		fillSimpleConcept(d);
		// with range 
		System.out.println("fill(char[] d, char val) : " + Arrays.toString(d));
		fillRangeConcept(d);
		System.out.println("fill(char[] d, char fromIndex, char toIndex, char val) : " + Arrays.toString(d));

		byte[] e = new byte[5];
		fillSimpleConcept(e);
		System.out.println("fill(byte[] e, byte val) : " + Arrays.toString(e));
		fillRangeConcept(e);
		System.out.println("fill(byte[] e, byte fromIndex, byte toIndex, byte val) : " + Arrays.toString(e));
	
		float[] f = new float[5];
		fillSimpleConcept(f);
		System.out.println("fill(float[] f, float val) : " + Arrays.toString(f));
		fillRangeConcept(f);
		System.out.println("fill(float[] f, float fromIndex, float toIndex, float val) : " + Arrays.toString(f));
	
		double[] g = new double[5];
		fillSimpleConcept(g);
		System.out.println("fill(double[] g, double val) : " + Arrays.toString(g));
		fillRangeConcept(g);
		System.out.println("fill(double[] g, double fromIndex, double toIndex, double val) : " + Arrays.toString(g));

		boolean[] h = new boolean[5];
		fillSimpleConcept(h);
		System.out.println("fill(boolean[] h, boolean val) : " + Arrays.toString(h));
		fillRangeConcept(h);
		System.out.println("fill(boolean[] h, boolean fromIndex, boolean toIndex, boolean val) : " + Arrays.toString(h));
	 
		
		Object[] j = new Object[5];
		fillSimpleConcept(j);
		System.out.println("fill(Object[] j, Object val) : " + Arrays.toString(j));
		fillRangeConcept(j);
		System.out.println("fill(Object[] j, Object fromIndex, Object toIndex, Object val) : " + Arrays.toString(j));
		
	}
	private static <T> void fillRangeConcept(T a) {
		/*
		 * Assigns the specified value to each element of the specified array of .
		 * Assigns the specified long value to each element of the specified 
		 * range of the specified array of longs. 
		 */
		if (a instanceof int[]){
			Arrays.fill((int[]) a, 0, 1, 3);
			Arrays.fill((int[]) a, 2, 3, 4);
			Arrays.fill((int[]) a, 3, 4, 5);
		}
		
		if (a instanceof long[]){
			Arrays.fill((long[]) a, 0, 1, 3);
			Arrays.fill((long[]) a, 2, 3, 4);
			Arrays.fill((long[]) a, 3, 4, 5);
		}
		
		
		if (a instanceof short[]){
			Arrays.fill((short[]) a, 0, 1, (short) 3);
			Arrays.fill((short[]) a, 2, 3, (short) 4);
			Arrays.fill((short[]) a, 3, 4, (short) 5);
		}
		
		if (a instanceof char[]){
			Arrays.fill((char[]) a, 0, 1, (char) 'b');
			Arrays.fill((char[]) a, 2, 3, (char) 'c');
			Arrays.fill((char[]) a, 3, 4, (char) 'd');
		}
		
		if (a instanceof byte[]){
			Arrays.fill((byte[]) a, 0, 1, (byte) 3);
			Arrays.fill((byte[]) a, 2, 3, (byte) 4);
			Arrays.fill((byte[]) a, 3, 4, (byte) 5);
			
		 }
		
		if (a instanceof float[]){
			Arrays.fill((float[]) a, 0, 1, (float) 3);
			Arrays.fill((float[]) a, 2, 3, (float) 4);
			Arrays.fill((float[]) a, 3, 4, (float) 5);
			
		 }
		
		if (a instanceof double[]){
			Arrays.fill((double[]) a, 0, 1, (double) 3);
			Arrays.fill((double[]) a, 2, 3, (double) 4);
			Arrays.fill((double[]) a, 3, 4, (double) 5);
			
		 }
		
		if (a instanceof boolean[]){
			Arrays.fill((boolean[]) a, 0, 1, false);
			Arrays.fill((boolean[]) a, 2, 3, false);
			Arrays.fill((boolean[]) a, 3, 4, false);
		}
		
		if (a instanceof Object[]){
			Arrays.fill((Object[]) a, 0, 1, "ead");
			Arrays.fill((Object[]) a, 2, 3, "cad");
			Arrays.fill((Object[]) a, 3, 4, "fad");
			
		 }
		
	}

	private static <T> void fillSimpleConcept(T a) {
		/*
		 * Assigns the specified value to each element of the specified array of .
		 * Assigns the specified long value to each element of the specified 
		 * range of the specified array of longs. 
		 */
		if (a instanceof int[]){
			Arrays.fill((int[]) a, 2);
		}
		
		if (a instanceof long[]){
			Arrays.fill((long[]) a, 2);
		}
		
		
		if (a instanceof short[]){
			Arrays.fill((short[]) a, (short) 2);
		}
		
		if (a instanceof char[]){
			Arrays.fill((char[]) a, (char) 'a');
		}
		
		if (a instanceof byte[]){
			Arrays.fill((byte[]) a, (byte) 2);
		}
		
		if (a instanceof float[]){
			Arrays.fill((float[]) a, (float) 2);
		}
		
		if (a instanceof double[]){
			Arrays.fill((double[]) a, (double) 2);
		 }
		
		if (a instanceof boolean[]){
			Arrays.fill((boolean[]) a, true);
		}
		
		if (a instanceof Object[]){
			Arrays.fill((Object[]) a, "abc");	
		 }
	}

}
