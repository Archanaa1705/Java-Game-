/**
* The BlackJack program implements a game application where a player and a dealer 
* play against each other.

* @author  Archanaa Arun**/


import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

//Intializing the game when the java program is executed

public class BlackJackGame{
	public HandDrawn players;
	public HandDrawn dealer;
	public Decks decks;
	private int play = 0;
	private int hit = 0;
	public BlackJackGameGUI CardGUI;
	private int stand =0;
	
	// Setting up the User interface buttons and enabling it.
	
	public BlackJackGame(){
	CardGUI =  new BlackJackGameGUI();
	CardGUI.setPlayAction(new PlayAction());
	CardGUI.setHitAction(new HitAction());
	CardGUI.setStandAction(new StandAction());
	CardGUI.enablePlayButton();
	}
	
	// black jack game begins here
	
	class PlayAction implements ActionListener {
	 public void actionPerformed (ActionEvent e) {
	 decks = new Decks();   	// arrange the entire card values as deck
	 decks.shuffle();		
	 players = new HandDrawn();
	 dealer = new HandDrawn();
	 players.add(decks.nextCards());
	 dealer.add(decks.nextCards());
	 players.add(decks.nextCards());
	 dealer.add(decks.nextCards());
	 CardGUI.displayPlayers(players);
	 CardGUI.displayDealerCard(dealer.getTopCard());
	if(!players.hasBlackJack() && !dealer.hasBlackJack() && !players.isBusted()){
	CardGUI.enableHitAndStandButtons();} // to continue the game
	 if(players.hasBlackJack() || dealer.hasBlackJack() || players.isBusted()){
		 finishGame();
	 }
	 }
	}

	
	class HitAction implements ActionListener{ 
	 public void actionPerformed (ActionEvent e) {

		 if(!players.isBusted() && players.valueOfHandDrawn() !=21){
			 players.add(decks.nextCards());
			 CardGUI.displayPlayers(players);
		 }
		 if(players.isBusted() || players.valueOfHandDrawn()==21){
		 finishGame();}
	 }
	}
	class StandAction implements ActionListener{
	public void actionPerformed (ActionEvent e) {
	
		finishGame();
	}
	}

	 private void finishGame(){
		if(players.hasBlackJack()){
		CardGUI.displayDealer(dealer);
		CardGUI.displayPlayers(players);
		CardGUI.displayOutcome("Vinner");}
		else if (dealer.hasBlackJack() && players.hasBlackJack()){
		CardGUI.displayDealer(dealer);
		CardGUI.displayPlayers(players);
		CardGUI.displayOutcome("Draw");}
		else if(dealer.hasBlackJack()){
		CardGUI.displayDealer(dealer);
		CardGUI.displayPlayers(players);
		CardGUI.displayOutcome("Tapt");}
		else if (players.isBusted()){
		CardGUI.displayDealer(dealer);
		CardGUI.displayPlayers(players);
		CardGUI.displayOutcome("Tapt");}
		else {
			while( dealer.valueOfHandDrawn()<17 && !dealer.isBusted() ){
			 dealer.add(decks.nextCards());
			}
		   if(dealer.isBusted())
			   {CardGUI.displayDealer(dealer);
		           CardGUI.displayPlayers(players);
			   CardGUI.displayOutcome("Vinner");}
                  else if (dealer.hasBlackJack()){
			   CardGUI.displayDealer(dealer);
		           CardGUI.displayPlayers(players);
		           CardGUI.displayOutcome("Tapt");
			   } 
		   else if (dealer.valueOfHandDrawn() == players.valueOfHandDrawn())
			   {CardGUI.displayDealer(dealer);
			   CardGUI.displayPlayers(players);
			   CardGUI.displayOutcome("Game Draw");}
		   else if (dealer.valueOfHandDrawn() > players.valueOfHandDrawn()){
			   CardGUI.displayDealer(dealer);
	                   CardGUI.displayPlayers(players);
		   	   CardGUI.displayOutcome("Tapt");}
		   else if (players.valueOfHandDrawn() > dealer.valueOfHandDrawn()){
			   CardGUI.displayDealer(dealer);
		           CardGUI.displayPlayers(players);
		           CardGUI.displayOutcome("Vinner");}
			 
		}
		CardGUI.enablePlayButton();
	}	
	 
	/* The main method is where execution of the code begins. */
	public static void main(String[] args){
		new BlackJackGame();
	}

}