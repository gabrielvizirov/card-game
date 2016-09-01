package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerSet {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int amountPlayers = 2;
	private int minPlayersAllowed = 2;
	private int maxPlayersAllowed = 4;
	
	public PlayerSet() {	//default values
		this.amountPlayers = 2;
		this.minPlayersAllowed = 2;
		this.maxPlayersAllowed = 4;
	}
	
	public PlayerSet(int amountPlayers) {
		this.amountPlayers = amountPlayers;
	}
	
	public PlayerSet(int minPlayersAllowed, int maxPlayersAllowed) {
		this.amountPlayers = 2;
		this.minPlayersAllowed = minPlayersAllowed;
		this.maxPlayersAllowed = maxPlayersAllowed;
	}
	
	public PlayerSet(int amountPlayers, int minPlayersAllowed, int maxPlayersAllowed) {
		this.amountPlayers = amountPlayers;
		this.minPlayersAllowed = minPlayersAllowed;
		this.maxPlayersAllowed = maxPlayersAllowed;
	}
	
	//ask for the amount of players to add to the game
	public void askPlayerCount(Scanner scanner) {
		System.out.print("Please type how many players you would like to play (Enter a number from " +
				minPlayersAllowed + " to " + maxPlayersAllowed + "): ");
		
		int playerCount = 0;
	
		//keep asking the user for a number specified till you get a valid input
		while (playerCount < minPlayersAllowed || playerCount > maxPlayersAllowed) {	//keep asking for the amount of players till we get a number between 2 to 4
			try {
				
				playerCount = Integer.parseInt(scanner.nextLine());
				if (playerCount < minPlayersAllowed || playerCount > maxPlayersAllowed) {
					System.out.print("You did not enter a valid value, please type in a number from " +
							minPlayersAllowed + " to " + maxPlayersAllowed + " for the number of players: ");
				}
				else {
					this.amountPlayers = playerCount;
					System.out.println("Player Count = " + playerCount);
				}
			}
			catch(Exception e) {	//make sure we get an int value and not a string or some other value
				System.out.print("You did not enter a valid value, please type in a number from " +
						minPlayersAllowed + " to " + maxPlayersAllowed + " for the number of players: ");
			}
		}
		
	}
	
	public void askPlayerNames(Scanner scanner) {
		
		//get names for every player
		for(int i=0; i< this.amountPlayers; i++) {
			
			//keep asking for a name until it is unique
			System.out.print("Please type player" + (i+1) + " name: ");
			boolean isDuplicate = true;
			while (isDuplicate) {

				
				String nameGiven = scanner.nextLine();
				
				//get rid of leading and trailing whitespaces
				nameGiven = nameGiven.trim();
				
				//System.out.println("NameGiven: " + nameGiven);
				if(isDuplicateNameCheck(nameGiven) == false && !nameGiven.equals(""))
				{
					addPlayer(nameGiven);
					isDuplicate = false;
				}
				else {
					System.out.print("Name has already been used or invalid. Please type another name for player " + (i+1) + ": ");
				}
			}
		}
		
	}
	
	//return true if the name has been used and a duplicate
	//return false is the name is unique
	private boolean isDuplicateNameCheck(String name) {
		for(int i=0; i<players.size(); i++) {
			if( name.compareTo( players.get(i).getName() ) == 0 ) {
				return true;
			}
		}
		return false;
	}
	
	//add a player to the players list without a name
	public void addPlayer() {
		this.players.add(new Player());
	}
	
	//add a player to the players list with a name
	public void addPlayer(String name) {
		this.players.add(new Player(name));
	}

	//print the entire deck
	public void printPlayers() {
		for(int i=0; i<this.players.size(); i++) {
			System.out.println(this.players.get(i).getName() + " = " + this.players.get(i).getScore() );
		}
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void setAmountPlayers(int amountPlayers) {
		this.amountPlayers = amountPlayers;
	}
	
	public void setMinPlayersAllowed(int minPlayersAllowed) {
		this.minPlayersAllowed = minPlayersAllowed;
	}
	
	public void setMaxPlayersAllowed(int minPlayersAllowed) {
		this.minPlayersAllowed = minPlayersAllowed;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public int getAmountPlayers() {
		return this.amountPlayers;
	}
	
	public int getMinPlayersAllowed() {
		return this.minPlayersAllowed;
	}
	
	public int getMaxPlayersAllowed() {
		return this.minPlayersAllowed;
	}
	
}
