---
Title: Black Jack Java game
Description: Java game application
Author: Archanaa Arun Prasad
Tags: Blackjack, java, game
Created:  2021 Nov 16
Modified: 2021 Nov 17

---

# Black-jack

![](https://github.com/Archanaa1705/Black-jack/blob/main/image/cards.jpg "Black Jack")

==============================================


Description
-------------
Black Jack is a Java (text) based game implementation.
Read about [Black Jack Game](https://en.wikipedia.org/wiki/Blackjack).

Project Background
-------------
It is created as a technical interview round for candidates who have applied for developer position at NAV.


### Contributors ###

1.[Archanaa Arun Prasad](https://github.com/Archanaa1705)

Project Status
--------------
1.  This project is in a alpha status. There are 1 player and a dealer in charge of running all aspects of the game, from shuffling and dealing the cards.
2.  The player/dealer can play through the game, Hit cards(Hit means draw a random card) and stand (Stop drawing a card from the deck) and display total score of both player and dealer.

Rules of Game
-------------
Click to read about the rules to play the game(https://navikt.github.io/fors-kodeoppgaver/oppgave1.html#/).

Setting Up The Game For Development or Gameplay
-----------------------------------------------

### Gameplay
1. Download the game from [here](https://github.com/Archanaa1705/Black-jack-NAV-oppgaven).
2. Extract the game files.

### Run with Eclipse IDE - Developers
1. Install [Eclipse](http://www.eclipse.org/downloads).
2. Go to Eclipse and  `open projects from the existing workplace`.
3. To run the game project->download the Black jack game source code[here] (https://github.com/Archanaa1705/Black-jack-NAV-oppgaven) and right click on the project -> select run as `Java application`.
4.	An Applet application opens and is ready to run.

Testing the Game using jUnit
----------------------------

1. Download 2 external jar files in eclipse [link](https://github.com/junit-team/junit4/wiki/Download-and-Install).
2. Right click on the game project and select run as `jUnit Test`.

Playing the Game
----------------
1.  `Play` : When the game application opens, The player selects the button `Play` to begin the game.
2.  `Hit`: The player can choose to draw more cards.  
3.  `Stand`: The player stops to draw the card and the dealer draws the card.

Finishing the Game
------------------
The game is finished of any one of the below works:
1.  The player/dealer loses the game when the total value of the cards exceeds 21.
2.  The cards drawn values are equal to 21 (It's a black Jack).
3.  The game is draw when both the player and dealer has the same value of cards.
4.  When the player card values are greater than the Dealer card values or vice versa.

Future Enhacements
------------------
1.  Few more players can be included in the game.
2.  More than 1 deck can be used to play the game depending upon the player's size.


Coding Standard/Convention/Style
--------------------------------
To help make code more readable, understandable, and consistent, each
contributor should follow the set guidelines laid out below. If you disagree
with something or come across a style that has not been decided upon, make an
issue or a pull request respectively for discussion on the best style. The
standard will be decided based on either majority rule or official documentation
(i.e. oracle coding standard).

 1. Spaces not tabs
 1. Space width is 4
 1. No beginning/trailing empty lines
 1. Each file should start with an import statement if necessary single-spaced
 1. After class declaration and between class methods, there should be a space.
 1. Within methods, there should be no spaces unless to separate specific chunks
    of code (i.e not for if statements, return values, or loops)
 1. Opening curly braces appear a space after the closing parentheses, not
    directly after.
 1. Closing curly braces appear on own line unless followed by an else etc.
    which will be a space after the curly brace.
 1. Comments should have one space after "//"
 1. Comments 4 lines or greater in length should be multi-line commented.

