
import java.awt.*;
import java.util.*;

public class Cards {
      private int cardSuit;
	private int cardRank;
	private static final String[] cardSuits = {"C", "D", "H", "S"};
        private static final String[] cardRanks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public Cards(int cardSuit, int cardRank){
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}
	public int valueOfHandDrawn(){
		//returns  value of the Card
		if (this.cardRank ==0){
		return 11;
		}
		if (this.cardRank < 10){
		return cardRank + 1;
		}
		if(this.cardRank >=10){
		return 10;
		}
		else{
		return 0;
		}
	}
	public String toString(){
		//returns a String represents the Card in form "Ace/Queen of Hearts"
	        return cardRanks[this.cardRank] + " of " + cardSuits[this.cardSuit];
	}
	public static void main(String[] args){
		Cards card1 = new Cards(0,1);
		System.out.println("Card a has a value of " + card1.valueOfHandDrawn() + " and is a " + card1.toString());
		Cards card2 = new Cards(3,4);
		System.out.println("Card a has a value of " + card2.valueOfHandDrawn() + " and is a " + card2.toString());
		}
	
}