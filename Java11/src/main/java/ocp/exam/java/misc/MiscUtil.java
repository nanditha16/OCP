package ocp.exam.java.misc;

public class MiscUtil {

	public static void main(String[] args) {
		System.out.println(evenlySpaced(2, 4, 6)); 
		System.out.println(evenlySpaced(4, 6, 2)); 
		System.out.println(evenlySpaced(4, 6, 3)); 
		
		System.out.println(makeBricks(3, 1, 8) );
		System.out.println(makeBricks(3, 1, 9));
		System.out.println(makeBricks(3, 2, 10));
		
		System.out.println(blackjack(19, 21));
		System.out.println(blackjack(21, 19));
		System.out.println(blackjack(19, 22));
		System.out.println();
		
		 int[] numbers = {
		            951, 402, 984, 651, 360, 69, 408, 319, 601, 485, 980, 507, 725, 547, 544, 
		        615, 83, 165, 141, 501, 263, 617, 865, 575, 219, 390, 984, 592, 236, 105, 942, 941, 
		        386, 462, 47, 418, 907, 344, 236, 375, 823, 566, 597, 978, 328, 615, 953, 345, 
		        399, 162, 758, 219, 918, 237, 412, 566, 826, 248, 866, 950, 626, 949, 687, 217, 
		        815, 67, 104, 58, 512, 24, 892, 894, 767, 553, 81, 379, 843, 831, 445, 742, 717, 
		        958, 609, 842, 451, 688, 753, 854, 685, 93, 857, 440, 380, 126, 721, 328, 753, 470, 
		        743, 527};

		        // Your code goes here
		        
		 for(int i=1; i< numbers.length; i++) {
			 if(numbers[i-1] == 237) {
				 break;
			 } else if (numbers[i-1] %2 == 0){
				 System.out.println(numbers[i-1]);
			 }
		 }
		 System.out.println();
		 for (int i = 0; i < numbers.length; i++) {
	            int el = numbers[i];

	            if (el == 237) {
	                break;
	            }

	            // using the division remainder operator %
	            if (el % 2 == 0) {
	                System.out.println(el);
	            }

	        }
		 
	}

	/*
	 * Given three ints, a b c, one of them is small, one is medium and one is large. 
	 * Return true if the three values are evenly spaced, 
	 * so the difference between small and medium is the same as the difference
	 *  between medium and large.
	 * 	evenlySpaced(2, 4, 6) → true
	 * 	evenlySpaced(4, 6, 2) → true
	 * 	evenlySpaced(4, 6, 3) → false

	 */
	public static boolean evenlySpaced(int a, int b, int c) {
		  int large = Math.max(a,Math.max(b, c) ) ;
		  int small = Math.min(a,Math.min(b, c) ) ;
		  int medium = (a + b + c) - (large + small);
		  
		  return ((large - medium) == (medium - small));	
	}
	
	/*
	 * Ref : https://codingbat.com/doc/practice/makebricks-solution-code.html
	 * make a row of bricks that is goal inches long. 
	 * We have a number of small bricks (1 inch each) and big bricks (5 inches each). 
	 * Return true if it is possible to make the goal by choosing from the given bricks. 
	 * makeBricks(3, 1, 8) → true
	 * makeBricks(3, 1, 9) → false
	 * makeBricks(3, 2, 10) → true
	 */
	public static boolean makeBricks(int small, int big, int goal) {
		//Fail #1: not enough bricks 
		// Fail #2: not enough small bricks
		if((goal > big*5 + small) || (goal%5 > small)) {
			return false;
		}
		return true;
		  
	}
	
	/*
	 * Given 2 int values greater than 0, 
	 * return whichever value is nearest to 21 without going over. 
	 * Return 0 if they both go over.
	 *  blackjack(19, 21) → 21
	 *  blackjack(21, 19) → 21
	 *  blackjack(19, 22) → 19
	 *  
	 *  case 1: a,b < 21, a<b --> expected b : 21 - a > 21 - b : return b
	 *  case 2: a,b < 21, b<a --> return a : else return a
	 *  case 3: a,b > 21, return 0
	 *  case 4: a >21, b<21, return b
	 *  case 5: b >21, a<21, return a 
	 */
	public static int blackjack(int a, int b) {
		if(a>21 && b > 21) {
			return 0;
		}else if(b>21) {
		    return a;
		}else if(((21-a) >= (21-b)) || a>21) {
		    return b;
		} else return a;
	}

	

}
