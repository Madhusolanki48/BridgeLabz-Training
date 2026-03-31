package scenario_based;
import java.util.*;
public class SnakeAndLadderGame {
	public static void main(String[] args) {
		System.out.println("----------------- Let's Play Snake & Ladder Game -----------------");
		System.out.println("------------------------------------------------------------------");
		// Use Case-1 : Single player at start position 0
        // Use Case-7 :Play the game with 2 Players
        int player1Position = 0;
        int player2Position = 0;
        int currentPlayer = 1;   // 1 for Player1, 2 for Player2

        // System.out.println("Game starts with single player at position : " + playerPosition);
        System.out.println("Game starts with two players at position : 0");
        System.out.println("------------------------------------------------------------------");
        // Use Case-2 : The Player rolls the die to get a number between 1 to 6 using Random

        Random random = new Random();
        int diceRollCount=0;           //-----for use case-6
        // Use Case-4 : Repeat till the Player reaches the winning position 100 
        while (player1Position < 100 && player2Position < 100) {
            diceRollCount+=1;
        int diceValue = random.nextInt(6) + 1;
        System.out.println("\nPlayer" + currentPlayer + " rolled the die");
        System.out.println("Dice value : " + diceValue);
        // Use Case-3 : Check Option — No Play / Ladder / Snake
        int option = random.nextInt(3);  // options: 0 = No Play, 1 = Ladder, 2 = Snake
        int playerPosition = (currentPlayer == 1) ? player1Position : player2Position;
        switch (option) {
            case 0:    // No play
                System.out.println("Option selected : NO PLAY");
                System.out.println("\nPlayer stays at the same position.");
                break;
            case 1:   // Ladder
                System.out.println("Option selected : LADDER");
                playerPosition += diceValue;
        // Use Case-5 : Ensure the player gets to exact winning position 100
                if (playerPosition>100){
                    System.out.println("Move exceeds 100, so stay at the same position");
                    playerPosition-=diceValue;
                }else{
                System.out.println("\nLadder! Player" + currentPlayer + " climbs to position " + playerPosition+" & gets another turn!");
     
                }
                break;
            case 2:   // Snake
                System.out.println("Option selected : SNAKE");
                playerPosition -= diceValue;
                if (playerPosition < 0)
                playerPosition = 0;
                System.out.println("\nPlayer bitten by snake! New Position : " + playerPosition);
                break;
            } 
            //update position
            if (currentPlayer == 1)
            player1Position = playerPosition;
            else
            player2Position = playerPosition;
            System.out.println("------------------------------------------------------------------");
            System.out.println("Player1 Current Position = " + player1Position);
            System.out.println("Player2 Current Position = " + player2Position);

            //switch turn only if it was not  a ladder
            if (option != 1) {
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
                System.out.println("\nSwitching turn to Player" + currentPlayer);
            }
    }
        // Use Case-6 : Report the number of times the dice was played to win the game   
        // System.out.println("\nNumber of times the dice was played to win the game = " + turn);
        // System.out.println("\nHurray ! Player reached WINNING POSITION 100");

        System.out.println("\n------------------------    Game Over    -------------------------");
        System.out.println("+++++++++++++ Congratulations!! Player" + (player1Position == 100 ? 1 : 2) + " won the Game +++++++++++++");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Total Dice Rolls = " + diceRollCount);
        System.out.println("-----------------------  Thanks for playing!  --------------------");

    }
}
