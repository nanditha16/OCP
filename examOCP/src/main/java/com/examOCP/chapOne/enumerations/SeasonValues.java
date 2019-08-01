package com.examOCP.chapOne.enumerations;

public enum SeasonValues {
	// Enum Types with values / field
	WINTER("low"), SPRING("high"), SUMMER("low"), FALL("medium");
	
	//Instant Variables
	private String liking;
	//private constructure
	private SeasonValues(String liking) {
		this.liking = liking;
		System.out.println("Constructing");
	}
	
	//Method
	public void printLikings() {
		System.out.println(liking);
	}
	
	//main class
	public static void main(String[] arg) {
		SeasonValues sea1 = SeasonValues.SPRING; //Constructs all the enums only for first time
		System.out.print("Season Value" + SeasonValues.SPRING + " : ");
		sea1.printLikings();
		System.out.println();
		SeasonValues sea2 = SeasonValues.WINTER; 
		System.out.println("sea1 == SeasonValues.SPRING --> " + (sea1 == SeasonValues.SPRING));
		System.out.println("sea1 == SeasonValues.WINTER --> "  +(sea1 == SeasonValues.WINTER));
		//System.out.println("SeasonValues.WINTER == 2 --> "  +(SeasonValues.WINTER == 2)); // Compilatin error
	
		System.out.println();
		SeasonMethod1 sea3 = SeasonMethod1.FALL;
		System.out.println("Season abstract Methhod");
				
		sea3.printHours();
		

		System.out.println();
		SeasonMethod2 sea4 = SeasonMethod2.FALL;
		System.out.println("Season default Methhod");
		sea4.printHours();
		sea4 = SeasonMethod2.WINTER;
		sea4.printHours();
	}
	
	//one more enum
	public enum SeasonMethod1{
		// Enum Types with method  Must overriding if abstract.
		WINTER{

			@Override
			public void printHours() {
				System.out.println("Nov-Jan" );
				
			}}, SPRING{

			@Override
			public void printHours() {
				System.out.println("March-July");
				
			}}, SUMMER{

			@Override
			public void printHours() {
				System.out.println("July-Sept");
				
			}}, FALL{

			@Override
			public void printHours() {
				System.out.println("Sept-Oct");
				
			}};
		
		public abstract void printHours();
		
	}
	
	//another enum
	public enum SeasonMethod2{
		// Enum Types with method overriding only specific when we have default method.
		WINTER{

			public void printHours() {
				System.out.println("Nov-Jan");
				
			}}, SPRING{

			public void printHours() {
				System.out.println("March-July");
				
			}}, SUMMER, FALL;
		
		public void printHours() {
			System.out.println("Default time" );
		};
		
	}
}
