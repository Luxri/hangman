import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] guesses = {"youtube", "good", "karate", "june", "rose", "albion"};

        boolean weArePlaying = true;

        while (weArePlaying) {
            System.out.println("Welcome to the game!"); //youtube -> y,o,u,t,u,b,e
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
            int amountOfGuesses = randomWordToGuess.length;
            char[] playerGuess = new char[amountOfGuesses];

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfGuesses) {
                System.out.println("Current guesses: ");
                printArray(playerGuess);
                System.out.printf("you have %d tries left.\n", amountOfGuesses - tries);
                System.out.println("Enter a single character");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if (input == '-') {
                    weArePlaying = false;
                    wordIsGuessed = true;
                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("You are the winner!");
                    }
                }
            }
            if (!wordIsGuessed) System.out.println("Seems you are out of guesses :/");
            System.out.println("Do you wanna play again? (yes/no)");
            String anotherGame = scanner.nextLine();
            if (anotherGame.equals("no")) weArePlaying = false;
        }

        System.out.println("Game Over");

    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");


        }

        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') return false;
        }
        return true;

    }
}







