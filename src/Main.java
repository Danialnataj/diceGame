/* Library for random numbers and user input */
import java.util.Random;
import java.util.Scanner;

/**
 * Declare Scanner for user input
 * Declare random number generator
 * Set the wins and losses to 0
 * LOOP:
 * Start by setting sum to 0
 *    Set diceRolled to 0
 *    Create an array to track which of the dice 1, 2, or 3 have been rolled
 *    While less than 3 dice rolled:
 * Ask user: "Which dice do you want to roll (1, 2, or 3), or 'q' to quit"
 *    Read the input
 *    If user inputs 'q':
 * Show the final score (wins and losses)
 *    Exit the program
 *    Try to convert input to an integer (die number)
 * If conversion fails or die number is not 1-3:
 * Display error message
 *    Continue to the next loop
 *    If this die has already been rolled:
 * SHow "You have already rolled that dice"
 *    Continue to next loop iteration
 *    Mark the chosen die as rolled
 * Increase diceRolled count
 * Generate a random number between 1 and 6
 * Add it to the sum
 * Show rolled value and current sum
 * If sum is exactly 12:
 * Show "You won this round!"
 *    Increase wins by 1*
 * Else if the sum is greater than 12:
 * Show "You lost this round!"
 *    Increase losses by 1
 *Else:
 * Show "neither won nor lost this round!"
 * Show current number of wins and losses
 * END LOOP
 * @author danmas-4
 */

public class Main {

    /**
     * It starts the dice game,
     * handles user input, rolls dice,
     * and determines the outcome.
     * @param args the command-line arguments passed to the program
     */
    public static void main(final String[] args) {
        final int maxVal = 6;
        final int targetSum = 12;
        Scanner scanner = new Scanner(System.in); // Handles user input
        Random random = new Random(); // Generates random dice rolls

        int wins = 0;
        int losses = 0;

        // Game loop continues until user quits
        while (true) {
            int sum = 0;
            int diceRolled = 0;

            // Track which dice have been rolled (no arrays used)
            boolean rolled1 = false;
            boolean rolled2 = false;
            boolean rolled3 = false;

            while (diceRolled < 3) {
                System.out.print(
                        "Which dice you want to roll "
                );
                String input = scanner.next();

                if (input.equals("q")) {
                    System.out.println(
                            "#win: " + wins + " #loss: " + losses
                    );
                    scanner.close();
                    return;
                }

                int die;
                try {
                    die = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Invalid input.");
                    continue;
                }

                if (die < 1 || die > 3) {
                    System.out.println(
                            "Invalid dice number. Choose between 1, 2, or 3."
                    );
                    continue;
                }

                if ((die == 1 && rolled1)
                        ||
                        (die == 2 && rolled2)
                        ||
                        (die == 3 && rolled3)) {
                    System.out.println(
                            "You have already rolled that dice."
                    );
                    continue;
                }

                // Mark this die as rolled
                if (die == 1) {
                    rolled1 = true;
                }
                if (die == 2) {
                    rolled2 = true;
                }
                if (die == 3) {
                    rolled3 = true;
                }

                diceRolled++;

                // Roll and add to sum
                int roll = random.nextInt(maxVal) + 1;
                sum += roll;
                System.out.println(
                        "You rolled: " + roll + " | Current sum: " + sum
                );
            }

            // Determine outcome
            if (sum == targetSum) {
                System.out.println("You won");
                wins++;
            } else if (sum > targetSum) {
                System.out.println("You lost");
                losses++;
            } else {
                System.out.println(
                        "You neither won nor lost this round."
                );
            }

            // Show current score
            System.out.println(
                    "#win: " + wins + " #loss " + losses
            );
            System.out.println();
        }
    }
}
