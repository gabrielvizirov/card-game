package cardgame;

import java.util.Scanner;

public class Game {
	private PlayerSet playerSet = new PlayerSet(2,4);	//players allowed from  2-4
	private Deck deck = new Deck();
	private String winner = "No One";
	private int winPointsValue = 2;
	private int penaltyPointsValue = -1;
	
	public Game() {
		this.playerSet = new PlayerSet(2,4);
		this.deck = new Deck();
		this.winner = "No One";
		this.winPointsValue = 2;
		this.penaltyPointsValue = -1;
	}
	
	public Game(int winPointsValue, int penaltyPointsValue) {
		this.playerSet = new PlayerSet(2,4);
		this.deck = new Deck();
		this.winner = "No One";
		this.winPointsValue = 2;
		this.penaltyPointsValue = -1;
	}
	
	public void startGame(Scanner scanner) {
		
		initializeGame(scanner);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		playGame(scanner);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		endGame(scanner);
	}
	
	private void initializeGame(Scanner scanner) {
		
		
		this.playerSet.askPlayerCount(scanner);
		this.playerSet.askPlayerNames(scanner);
		
		
		//for testing purposes
		/*
		this.playerSet.printPlayers();
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		
		this.deck.printDeck();
		System.out.println("---------------------------------------");
		this.deck.shuffleCards();
		this.deck.printDeck();
		*/
	}
	
	private void playGame(Scanner scanner) {
		
		
		int roundNumber = 1;
		
		//keep playing the game till we have a winner
		boolean haveWinner = false;
		while(!haveWinner) {
			
			//tells the users how many rounds have been played
			System.out.println("ROUND " + roundNumber);
			
			//shuffle the deck after every round
			System.out.println("Shuffling the Deck...\n");
			this.deck.shuffleCards();
		
			//get all the cards drawn for each player
			for(int i=0; i<this.playerSet.getAmountPlayers(); i++) {
				System.out.print("It is " +  this.playerSet.getPlayers().get(i).getName() + "\'s turn. Press \'ENTER\' to draw a card.");
				
				//////////////////////////////////////////////////////////////////
				//comment this out if u want all rounds done automatically without a key press from each player
				//THIS IS NEEDED TO PRESS ENTER TO DRAW A CARD
				scanner.nextLine();
				///////////////////////////////////////////////////////////////////
				
				//tell the users what card they received
				//if penalty card drawn, print this
				if(this.deck.getCardList().get(i).getNumberValue() == 0) {
					System.out.println(this.playerSet.getPlayers().get(i).getName() + " has drawn the Penalty card.\n"); 
				}
				//otherwise print the card value and suit that was drawn
				else {	
					System.out.println(this.playerSet.getPlayers().get(i).getName() + " has drawn the card " + 
						this.deck.getCardList().get(i).getValue() +" of " + this.deck.getCardList().get(i).getSuit() + ".\n" );
				}
			}
			
			int roundWinner = 0;	//roundWinner starts with Player 1 first
			for(int i=0; i<this.playerSet.getAmountPlayers(); i++) {
				
				//if the roundWinner is still the highest card do this
				if(this.deck.getCardList().get(roundWinner).getNumberValue() > this.deck.getCardList().get(i).getNumberValue()) {
					//do nothing since the roundWinner in the search is still on top
				}
				//if the roundWinner has a lower card than the other player being checked at the moment, switch th new player as the round winner
				else if(this.deck.getCardList().get(roundWinner).getNumberValue() < this.deck.getCardList().get(i).getNumberValue()) {
					roundWinner = i;
				}
				//if the roundWinner and the person being checked with have the same card value, check the Suit of the card to see who is the winner
				else if(this.deck.getCardList().get(roundWinner).getNumberValue() == this.deck.getCardList().get(i).getNumberValue()) {
					//check the suit card value and compare
					//if the roundWinner has the highest Suit, do nothing
					if(this.deck.getCardList().get(roundWinner).getNumberSuit() > this.deck.getCardList().get(i).getNumberSuit()) {
						//do nothing
					}
					//if the other player being checked has the same card value and the highest Suit, that player is the new round winner
					else if(this.deck.getCardList().get(roundWinner).getNumberSuit() < this.deck.getCardList().get(i).getNumberSuit()) {
						roundWinner = i;
					}
				}
				
				//if any player gets a penalty card, subtract a point for the score
				if(this.deck.getCardList().get(i).getNumberValue() == 0) {
					
					//if the players score is 0, dont subtract any points
					if(this.playerSet.getPlayers().get(i).getScore() >= 1) {
						this.playerSet.getPlayers().get(i).updateScore(this.penaltyPointsValue);
					}
				}
			}
			
			//if the roundWinner has a NumberValue of 0, that means that all the players received penalty cards so they all get negative points
			if(this.deck.getCardList().get(roundWinner).getNumberValue() == 0) {
					//we have no winner so do not add any points to any players and print we have no winners
					System.out.println("\nNo winner this round.");
			}
			//since we have an obvious winner, give that player 2 points towards the score
			else {
				this.playerSet.getPlayers().get(roundWinner).updateScore(this.winPointsValue);
				//print the winner of the round since we have one
				System.out.println("\n" + this.playerSet.getPlayers().get(roundWinner).getName() + " is the winner of this round." );
			}
			
			
			//print the scores of each player
			printScoreBoard();
			
			//check if we have a winner for the entire game
			//counter to make sure the winner beat every player by 2 points
			//start counter at 1, instead of 0, for when player checks itself because winner checking score to itself would be 0 and fail the counter and not win the game (ex. score-score = 0)
			int defeatedOtherPlayers = 0;
			for(int i=0; i<this.playerSet.getAmountPlayers(); i++) {
				//if the roundWinner has a score greater than 21 and leading the other players by 2 points, then that person is the game winner
				if(this.playerSet.getPlayers().get(roundWinner).getScore() >= 21 && (this.playerSet.getPlayers().get(roundWinner).getScore()-this.playerSet.getPlayers().get(i).getScore()) >= 2 ) {
				
				//if(this.playerSet.getPlayers().get(roundWinner).getScore() >= 21) {
					defeatedOtherPlayers++;
				}
			}
			
			//if the roundWinner defeated all the other players, except for self, declare the winner and stop the loop and stop playing the game
			if(defeatedOtherPlayers == (this.playerSet.getAmountPlayers()-1) ) {
				//set the roundWinner to gameWinner and end the while loop for playing the game
				this.winner = this.playerSet.getPlayers().get(roundWinner).getName();
				haveWinner = true;
			}
			
			//next round counter
			roundNumber++;
		}
		
	}
	
	private void endGame(Scanner scanner) {
		System.out.println("GAME OVER");
		System.out.println(this.winner + " is the WINNER of the game");
		System.out.print("Thank You For Playing! \nPlease press \'ENTER\' to Exit the game.");
		scanner.nextLine();
	}
	
	public void printScoreBoard() {
		
		System.out.println("------------");
		System.out.println("Scoreboard");
		System.out.println("------------");
		this.playerSet.printPlayers();
		System.out.println("------------\n");
		
	}
}
