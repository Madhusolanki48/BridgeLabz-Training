package scenario_based;
import java.util.*;
public class SnakeAndLadderGame {
	public static void main(String[] args) {
		System.out.println("----------------- Let's Play Snake & Ladder Game -----------------");
		
		// Use Case-1 : Single player at start position 0
		
        int playerPosition = 0;   // start position
        
        System.out.println("Game starts with single player at position : " + playerPosition);

        // Use Case-2 : The Player rolls the die to get a number between 1 to 6 using Random

        Random random = new Random();
        int diceValue = random.nextInt(6) + 1;
        System.out.println("Player rolls the die");
        System.out.println("Dice value : " + diceValue);

        
    }
}
	
	    
