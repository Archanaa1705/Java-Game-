import java.awt.*;
import java.util.*;

public class HandDrawn{
	public int count = 0;
	private Cards[] HandValue;
	
	public HandDrawn() {
		HandValue = new Cards[20];
	}
	public void add(Cards card){
		HandValue[count++] = card;
	}
	public Cards getTopCard(){
		return HandValue[0];
	}
	
	// returns the total value of cards picked by player or dealer
	public int valueOfHandDrawn(){
		int sum=0;
		int ranks=0;
		int countNo2= count;
		int aces = 0;
		for(int i=0; i< countNo2; i++){
			ranks = HandValue[i].valueOfHandDrawn();
			
			sum += ranks;
			/*
			 * if( rank == 11){ aces++; }
			 */
		}
		/*
		 * while (aces > 0 && sum >21){ sum -= 10; aces--; }
		 */		
		return sum;
	} // Calculate if its a blackjack
	public boolean hasBlackJack(){
		int total = HandValue[0].valueOfHandDrawn() + HandValue[1].valueOfHandDrawn();
		//System.out.println(total);
		return total ==21;
	}

	public boolean isBusted(){
		return valueOfHandDrawn() > 21;
	}
	public String toString(){
		String string ="";
		int count3 = count;
		for(int i=0; i< count3; i++){
			string += HandValue[i].toString();
			string += "\n";
		}
		if(isBusted()){
			string += "\n\n";
			string += "Bust";
		}
		if(hasBlackJack()){
			string += "\n\n";
			string += "Black Jack";
		}
		return string;
	}
	public static void main(String[] args){
		Decks deck = new Decks();
		deck.shuffle();
		HandDrawn a = new HandDrawn();
		a.add(deck.nextCards());
		a.add(deck.nextCards());
		a.add(deck.nextCards());
		System.out.println(a.toString());
		System.out.println(a.valueOfHandDrawn());
	}
	
	}
		
		