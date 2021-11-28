import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class jUnitTestCase {
	
	// Test the value of random individual cards drawn
	
		@Test
		public void testcard() {
		
		HandDrawn hand = new HandDrawn();
	    hand.add(new Cards(2,3));
	    assertEquals(4, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(4,3));
	    assertEquals(4, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(3,10));
	    assertEquals(10, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(5,2));
	    assertEquals(3, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(6,3));
	    assertEquals(4, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(0,1));
	    assertEquals(2, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(4,12));
	    assertEquals(10, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(4,3));
	    assertEquals(4, hand.valueOfHandDrawn());
	    
	    hand = new HandDrawn();
	    hand.add(new Cards(4,7));
	    assertEquals(8, hand.valueOfHandDrawn());
	 	}
	
		// Test if its a Black jack 
		@Test
		
		public void testBlackJack() {
		 HandDrawn player = new HandDrawn();
		
		 player.add(new Cards(3,10));
		 player.add(new Cards(0,0));
		 assertEquals(21,player.valueOfHandDrawn());
		 assertTrue(player.hasBlackJack());	
		}
		
		// Test if Player wins and dealer is busted
		@Test
				
		public void testWinGame() {
		HandDrawn player = new HandDrawn();
		player.add(new Cards(2,3));
		player.add(new Cards(2,9));
		player.add(new Cards(1,6));
		HandDrawn dealer = new HandDrawn();
		dealer.add(new Cards(3,10));
		dealer.add(new Cards(4,11));
		dealer.add(new Cards(3,3));
		assertEquals(21,player.valueOfHandDrawn());	
		assertEquals(24,dealer.valueOfHandDrawn());
		assertTrue(dealer.isBusted());	
		assertFalse(player.valueOfHandDrawn() > dealer.valueOfHandDrawn());
				}
	
		// Test if the player is busted 
		
		@Test
		public void testBusted() {
		HandDrawn player = new HandDrawn();
		player.add(new Cards(3,10));
		player.add(new Cards(4,11));
		player.add(new Cards(3,3));
		assertEquals(24,player.valueOfHandDrawn());
		assertTrue(player.isBusted());
		}
	
		// Test if the player loses the game and dealer wins the game
		
		@Test
		public void testLoseGame() {
		HandDrawn Player = new HandDrawn();
		Player.add(new Cards(2,3));
		Player.add(new Cards(2,9));
		Player.add(new Cards(1,5));
		assertEquals(20,Player.valueOfHandDrawn()); 
		assertFalse(Player.isBusted());
		HandDrawn Dealer = new HandDrawn();
		Dealer.add(new Cards(3,10));
		Dealer.add(new Cards(0,0));
		assertEquals(21,Dealer.valueOfHandDrawn()); 
		assertTrue(Dealer.hasBlackJack());
		assertTrue(Dealer.valueOfHandDrawn()>Player.valueOfHandDrawn());
		}
		
		// Test if null values are drawn from card
		
		@Test
		public void testNotNullValues() {
		HandDrawn hand = new HandDrawn();
		hand.add(new Cards(2,3));
		assertNotNull(hand);
		}
			
		// Test if the dealer can pick another card 
		
		@Test	
		public void testPickAnotherCard() {
		HandDrawn hand = new HandDrawn();
		Decks deck=new Decks();
		hand.add(new Cards(2,3));
		hand.add(new Cards(2,9));
		assertEquals(14,hand.valueOfHandDrawn());  
		assertFalse(hand.isBusted());
		assertNotNull(deck.nextCards());
		}
		
		// Test if the game is draw when both player and dealer pick the same values of cards
		
		@Test	
		public void testDrawGame() {
		HandDrawn player = new HandDrawn();
		player.add(new Cards(2,3));
		assertEquals(4,player.valueOfHandDrawn());  
		HandDrawn Dealer = new HandDrawn();
		Dealer.add(new Cards(3,3));
		assertEquals(4,Dealer.valueOfHandDrawn());  
		assertSame(player.valueOfHandDrawn(),Dealer.valueOfHandDrawn());
		}
	}
