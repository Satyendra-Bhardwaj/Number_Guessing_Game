/*  A Java console game where the computer generates a random number and the player tries to guess it.
    ## Technologies Used - Java,Random Class,Scanner,Exception Handling 
*/


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static int bestScore = Integer.MAX_VALUE;

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("===================================");

        boolean playAgain = true;

        while (playAgain) {

            int max = chooseDifficulty();
            int secretNumber = random.nextInt(max) + 1;

            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and " + max);

            while (!guessed) {

                try {

                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();

                    attempts++;

                    if (guess == secretNumber) {

                        System.out.println("\n🎉 Congratulations!");
                        System.out.println("You guessed the correct number.");

                        System.out.println("Attempts: " + attempts);

                        if (attempts < bestScore) {
                            bestScore = attempts;
                            System.out.println("🏆 New Best Score!");
                        }

                        System.out.println("Best Score: " + bestScore);

                        guessed = true;

                    } else if (guess < secretNumber) {

                        System.out.println("Too Low ⬆");

                    } else {

                        System.out.println("Too High ⬇");
                    }

                } catch (InputMismatchException e) {

                    System.out.println("Invalid Input!");
                    sc.nextLine();

                }

            }

            System.out.print("\nPlay Again? (Y/N): ");
            String ans = sc.next();

            playAgain = ans.equalsIgnoreCase("Y");
        }

        System.out.println("\nThank you for playing!");
        sc.close();
    }

    static int chooseDifficulty() {

        while (true) {

            try {

                System.out.println("\nSelect Difficulty");
                System.out.println("1. Easy (1-50)");
                System.out.println("2. Medium (1-100)");
                System.out.println("3. Hard (1-500)");

                System.out.print("Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        return 50;

                    case 2:
                        return 100;

                    case 3:
                        return 500;

                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException e) {

                System.out.println("Enter numbers only.");
                sc.nextLine();

            }

        }

    }

}