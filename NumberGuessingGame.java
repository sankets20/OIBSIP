import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        //Define Range 
        int minRange = 1;
        int maxRange = 100;
        //max attempt
        int maxAttempts = 5;
        int totalRounds = 3;
        int round = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!!");

        while (round <= totalRounds) {
            System.out.println("Round " + round);
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            int attempt = 1;
            while (attempt <= maxAttempts) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = input.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempt + 1;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }
                attempt++;
            }
            if (attempt > maxAttempts) {
                System.out.println("You failed to guess the number. The correct number was: " + targetNumber);
            }
            round++;
        }
        System.out.println("Game over! Your total score is: " + score);
        input.close();
    }
}
