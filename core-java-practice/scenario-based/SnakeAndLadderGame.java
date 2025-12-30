package scenario_based;
import java.util.*;
public class SnakeAndLadderGame {
	public static void main(String[] args) {
		System.out.println("----------------- Let's Play Snake & Ladder Game -----------------");
		System.out.println("------------------------------------------------------------------");
		// Use Case-1 : Single player at start position 0
		
        int playerPosition = 0;   // start position
        
        System.out.println("Game starts with single player at position : " + playerPosition);
        System.out.println("------------------------------------------------------------------");
        // Use Case-2 : The Player rolls the die to get a number between 1 to 6 using Random

        Random random = new Random();
        int turn=0;           //-----for use case-6
        // Use Case-4 : Repeat till the Player reaches the winning position 100 
        while (playerPosition < 100) {
            turn+=1;
        int diceValue = random.nextInt(6) + 1;
        System.out.println("Player rolled the die");
        System.out.println("Dice value : " + diceValue);
        // Use Case-3 : Check Option — No Play / Ladder / Snake
        int option = random.nextInt(3);  // options: 0 = No Play, 1 = Ladder, 2 = Snake
        switch (option) {
            case 0:    // No play
                System.out.println("Option selected : NO PLAY");
                System.out.println("Player stays at the same position.");
                break;
            case 1:   // Ladder
                System.out.println("Option selected : LADDER");
                playerPosition += diceValue;
        // Use Case-5 : Ensure the player gets to exact winning position 100
                if (playerPosition>100){
                    System.out.println("Move exceeds 100, so stay at the same position");
                    playerPosition-=diceValue;
                }else{
                System.out.println("Player climbs the ladder! New position : " + playerPosition);
                }
                break;
            case 2:   // Snake
                System.out.println("Option selected : SNAKE");
                playerPosition -= diceValue;
                if (playerPosition < 0)
                playerPosition = 0;
                System.out.println("Player bitten by snake! New Position : " + playerPosition);
                break;
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Current Player Position = " + playerPosition);   //the position after every die role
    }
        // Use Case-6 : Report the number of times the dice was played to win the game   
        System.out.println("\nNumber of times the dice was played to win the game = " + turn);
        System.out.println("\nHurray ! Player reached WINNING POSITION 100");
    }
}
