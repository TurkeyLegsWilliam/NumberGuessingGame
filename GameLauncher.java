import java.util.*;
import java.util.Arrays;
import java.util.List;


class GuessGame {
	int number = (int)(Math.random()*10); // number to be guessed
	List<Player> players = new ArrayList<Player>();	// list of players
	// Guessing Game
	boolean startGame (int numPlayers) {
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player());	
		}
		
		for (int i = 0;i < 1000; i++) {
			// iterates
			for (int j = 0; j < players.size(); j++) {
				// prints old guess, gets new and prints new
				System.out.println("------------------------------------------");
				System.out.println("---Player " + (j+1) + "---");
				System.out.println("Current Guess: " + players.get(j).number);

				players.get(j).number = players.get(j).guess();
				// System.out.println("New Guess: " + players.get(j).number + "\n");
				if (players.get(j).number == number) {
					System.out.println("\nYou guessed right! The number is " + number + "\n");
					return true;
				}
				else {
					System.out.println("\nWRONG!\n");
				}
			}
		}
		
		// game did not complete
		return false;
	}
}

class Player {
	int number = -1; // guessed number
	int guess() {
		int playerGuessNum = -1;
		
		for (;;) {
			// check for valid input
			
			// prompts player for guess
			System.out.print("Enter Guess: ");
			
			playerGuessNum = Integer.parseInt(System.console().readLine());
			if (playerGuessNum >= 0 && playerGuessNum <= 9) {
				break;
			}
			System.out.println("INVALID INPUT: must be from 0 through 9");
			
		}
		
		return playerGuessNum;
	}
}

public class GameLauncher {
	public static void main (String[] args) {
		GuessGame game1 = new GuessGame();
		
		int numberPlayers = 0;
		
		for (;;) {
			System.out.print("Enter number of players: ");
			numberPlayers = Integer.parseInt(System.console().readLine());
			
			if (numberPlayers >= 1) {
				break;
			}
			System.out.println("INVALID INPUT: must be greater or equal to 1");
		}
		
		boolean gameFinished = game1.startGame(numberPlayers);
		
		if (gameFinished == false) {
			System.out.println("Game did not finish.");
		}
		else {
			System.out.println("Game over.");
		}
	}
}

