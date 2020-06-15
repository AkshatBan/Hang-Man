import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Code for Hang Man
    static WordReader wr = new WordReader();
    static ArrayList<String> hiddenWordArrayList = new ArrayList<>();
    static String hiddenWordStr = "";
    static String word = wr.getRandomWord();
    static String usedLetters = "Used Letters: ";
    static int initializeArrayList = 0;
    static int livesLeft = 10;
    static int lettersLeft = word.length();

    public static void main(String[] args) {
        System.out.println("\nWelcome to Hangman!");
        gameplay();
    }

    public static void display() {
        String temp = "";
        while (initializeArrayList < 1) {
            for (int i = 0; i < word.length(); i++) {
                hiddenWordArrayList.add("_ ");
            }
            initializeArrayList++;
        }
        for (String s : hiddenWordArrayList) {
            temp += s;
            hiddenWordStr = temp;
        }
        System.out.println("\n" + "Hidden word: " + hiddenWordStr + "\n" + usedLetters + "\n" + "Lives Left: " + livesLeft);
    }

    public static void guessAndCheck() {
        boolean isInWord = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Type a letter: ");
        String guess = sc.nextLine().toUpperCase();
        for (int i = word.length(); i > 0; i--) {
            if (word.substring(i - 1, i).equalsIgnoreCase(guess)) {
                hiddenWordArrayList.set(i - 1, guess + " ");
                if (!usedLetters.substring(13).contains(guess)) {
                    lettersLeft--;
                }
                isInWord = true;
            }
        }
        usedLetters += guess + " ";
        if (!isInWord) {
            livesLeft--;
        }
        display();
    }

    public static void gameplay() {
        Scanner scan = new Scanner(System.in);
        display();

        while (true) {
            while (livesLeft > 0 && lettersLeft > 0) {
                guessAndCheck();
            }
            if (livesLeft == 0) {
                System.out.println("\nGAME OVER\nThe word was: " + word);
            } else {
                System.out.println("\nYou are victorious!");
            }
            System.out.println("Type \"y\" if you want to play again or \"n\" if you want to end the game.");
            String response = scan.nextLine().toLowerCase();
            if (response.equals("n")) {
                break;
            }
            word = wr.getRandomWord();
            livesLeft = 10;
            lettersLeft = word.length();
            usedLetters = "Used Letters: ";
            initializeArrayList = 0;
            hiddenWordArrayList.clear();
            display();
        }
        System.out.println("Thank you for playing! Goodbye!");
    }
}