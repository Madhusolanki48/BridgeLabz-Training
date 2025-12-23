package strings;
import java.util.Scanner;
public class DeckOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
        // total number of cards
        int numberOfCards = suits.length * ranks.length;
        // initialize deck
        String[] deck = initializeDeck(suits, ranks);
        //shuffle deck
        shuffleDeck(deck);
        //user input
        System.out.print("Enter number of players : ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player : ");
        int cardsPerPlayer = sc.nextInt();
        //distribute cards
        String[][] distributed = distributeCards(deck, players, cardsPerPlayer);

        if (distributed != null) {
            printPlayers(distributed);
        }
    }

    //method to initialize deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int index = 0;
        String[] deck = new String[suits.length * ranks.length];

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }
    //method to shuffle deck
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)
            		(Math.random() * (n - i));
            // swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    //method to distribute cards
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        int totalCardsNeeded = players * cardsPerPlayer;
        if (totalCardsNeeded > deck.length) {
            System.out.println("Cards cannot be distributed.");
            return null;
        }
        String[][] playerCards = new String[players][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[cardIndex++];
            }
        }

        return playerCards;
    }

    //method to print players and their cards
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }
}
