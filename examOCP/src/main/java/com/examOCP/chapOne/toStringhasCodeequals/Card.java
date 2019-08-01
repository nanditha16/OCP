package com.examOCP.chapOne.toStringhasCodeequals;

public class Card {

	private String rank;
	private String suit;
	
	public Card(String r, String s) {
		if(r == null || s == null) throw new IllegalArgumentException();
		rank = r;
		suit = s;
	}
	
	@Override
	public String toString() {
		return "Rank: " + rank + ", Suit: " + suit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {
			return false;
		}
		Card c = (Card) obj;
		return rank.equals(c.rank) && suit.equals(c.suit);
	}
	
	public int hashCode() {
		return rank.hashCode();
	}
	public static void main(String[] args) {
		Card card = new Card("1", "Heart");
		System.out.println( "Card1 " + card );
		System.out.println( "Card1 hashCode " + card.hashCode() );
		Card card2 = new Card("2", "Heart");
		System.out.println( "Card2 " + card2 );
		System.out.println( "Card2 hashCode " + card2.hashCode() );
		
		Card card3 = card2;
		System.out.println( "Card3 " + card3 );
		System.out.println( "Card3 hashCode " + card3.hashCode() );
		System.out.println();
		
		System.out.println("card.equals(card2): "+(card.equals(card2)));
		System.out.println("card3.equals(card2): "+(card3.equals(card2)));
		
		card3 = new Card("2", "Heart"); // false
		System.out.println("card3 == card2: " + (card3 == card2));
		
	}

}
