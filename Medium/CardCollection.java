import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class CardCollection {
    private static HashMap<String, ArrayList<String>> cards = new HashMap<>();

    public static void main(String[] args) {
        initializeCards();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. View Cards by Symbol");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            if (choice == 1) {
                System.out.print("Enter the symbol (Hearts, Spades, Diamonds, Clubs): ");
                String symbol = scanner.nextLine();
                viewCardsBySymbol(symbol);
            } else if (choice == 2) {
                System.out.println("Exiting the system.");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        
        scanner.close();
    }

    public static void initializeCards() {
        ArrayList<String> hearts = new ArrayList<>();
        hearts.add("Ace");
        hearts.add("2");
        hearts.add("3");
        hearts.add("4");
        hearts.add("5");
        hearts.add("6");
        hearts.add("7");
        hearts.add("8");
        hearts.add("9");
        hearts.add("10");
        hearts.add("Jack");
        hearts.add("Queen");
        hearts.add("King");

        ArrayList<String> spades = new ArrayList<>();
        spades.add("Ace");
        spades.add("2");
        spades.add("3");
        spades.add("4");
        spades.add("5");
        spades.add("6");
        spades.add("7");
        spades.add("8");
        spades.add("9");
        spades.add("10");
        spades.add("Jack");
        spades.add("Queen");
        spades.add("King");

        ArrayList<String> diamonds = new ArrayList<>();
        diamonds.add("Ace");
        diamonds.add("2");
        diamonds.add("3");
        diamonds.add("4");
        diamonds.add("5");
        diamonds.add("6");
        diamonds.add("7");
        diamonds.add("8");
        diamonds.add("9");
        diamonds.add("10");
        diamonds.add("Jack");
        diamonds.add("Queen");
        diamonds.add("King");

        ArrayList<String> clubs = new ArrayList<>();
        clubs.add("Ace");
        clubs.add("2");
        clubs.add("3");
        clubs.add("4");
        clubs.add("5");
        clubs.add("6");
        clubs.add("7");
        clubs.add("8");
        clubs.add("9");
        clubs.add("10");
        clubs.add("Jack");
        clubs.add("Queen");
        clubs.add("King");

        cards.put("Hearts", hearts);
        cards.put("Spades", spades);
        cards.put("Diamonds", diamonds);
        cards.put("Clubs", clubs);
    }

    public static void viewCardsBySymbol(String symbol) {
        if (cards.containsKey(symbol)) {
            System.out.println("\nCards of symbol " + symbol + ":");
            ArrayList<String> cardList = cards.get(symbol);
            for (String card : cardList) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for the symbol: " + symbol);
        }
    }
}
