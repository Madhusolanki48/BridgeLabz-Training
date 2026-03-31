package strings;
import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games : ");
        int games = sc.nextInt();
        //method call
        playGames(games);
    }
    //method to play given number of games
    public static void playGames(int games) {
        Scanner sc = new Scanner(System.in);
        int userWin = 0;
        int computerWin = 0;

        for (int i = 1; i <= games; i++) {
            System.out.print("Enter your choice (0-rock, 1-paper, 2-scissors): ");
            int choice = sc.nextInt();
            //convert number to string choice
            String user;
            if (choice == 0)
                user = "rock";
            else if (choice == 1)
                user = "paper";
            else
                user = "scissors";
            // computer choice
            String computer = generatecomputerChoice();
            // method call to find winner
            String winner = findWinner(user, computer);
            //count number of wins
            if (winner.equals("You win the match !"))
                userWin++;
            else if (winner.equals("Computer wins the match !"))
                computerWin++;

            System.out.println("Computer has chosen : " + computer +" | Winner : " + winner);
        }
        System.out.println("\nUser Wins: " + userWin);
        System.out.println("Computer Wins: " + computerWin);
        System.out.println("User Win %: " + (userWin * 100 / games));
        System.out.println("Computer Win %: " + (computerWin * 100 / games));
    }

    //method to generate computer choices
    public static String generatecomputerChoice() {
        int r = (int) (Math.random() * 3);
        if (r == 0)
        	return "rock";
        if (r == 1)
        	return "paper";
        return "scissors";
    }
    //method to find winner
    public static String findWinner(String user, String comp) {
        if (user.equals(comp)) {
            return "Match is draw !";
        }
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "You win the match !";
        
        return "Computer wins the match !";
    }
}
