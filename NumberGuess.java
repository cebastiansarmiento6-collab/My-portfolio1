import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int secretNumber = rand.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 7;
        boolean won = false;

        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess;

            // Input validation
            if (input.hasNextInt()) {
                guess = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a whole number.\n");
                input.next(); // discard bad input
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("Please guess between 1 and 100.\n");
                continue;
            }

            attempts++;

            if (guess == secretNumber) {
                won = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Attempts left: " + (maxAttempts - attempts) + "\n");
            } else {
                System.out.println("Too high! Attempts left: " + (maxAttempts - attempts) + "\n");
            }
        }

        if (won) {
            System.out.println("Congratulations! You guessed it in " + attempts + " attempt(s).");
        } else {
            System.out.println("Out of attempts! The number was " + secretNumber + ".");
        }

        input.close();
    }
}