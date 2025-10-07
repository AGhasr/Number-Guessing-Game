import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        int maxAttempts;

        switch (choice) {
            case 1:
                maxAttempts = 10;
                break;
            case 2:
                maxAttempts = 5;
                break;
            case 3:
                maxAttempts = 3;
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                return;
        }

        Random r = new Random();
        int secret = r.nextInt(100) + 1;
        int guess;
        int attempts = 0;
        Boolean guessed = false;
        System.out.println("Let's start!\n");
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < secret) {
                System.out.printf("Incorrect! The number is greater than %d.%n", guess);
            } else if (guess > secret) {
                System.out.printf("Incorrect! The number is less than %d.%n", guess);
            }
            else{
                System.out.printf("Congratulations! You guessed the correct number in %d attempt%s.%n",
                        attempts, (attempts > 1 ? "s" : ""));
                guessed = true;
                break;
            }
        }
        if (!guessed) {
            System.out.printf("Out of chances! The correct number was %d.%n", secret);
        }
        sc.close();

    }
}
