/**
 * 
 */
package cardgame;

/**
 * @author Vizirov, Gabriel
 * @date last modified August 20, 2016
 */
import java.util.Scanner;

public class cardgame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//allow input reading
		Scanner scanner = new Scanner(System.in);
		
		//create the game
		Game game = new Game();
		
		//start the game
		game.startGame(scanner);
		
		//close input reading
		scanner.close();
	
	}

}
