package com.java.guessinggame;

import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

    	int attempts =0 ;
        // Create Scanner for user input
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
            	System.out.println("\n----- Guessing Game -----");
            	
                // Generate a random number
                RandomGenerator obj = new RandomGenerator();
                int generatedNum = obj.generateRandomNum();
                
                Hints hits = new Hints();

                System.out.println("A random number has been generated between 0 and 100.");

                boolean result = false; // Initialize result

                while (!result) {
                    // Prompt the user to guess the number
                	attempts ++;
                    System.out.print("Enter your guess: ");
                    int userNum = sc.nextInt();

                    // Check the user's guess
                    UsersGuess userObj = new UsersGuess();
                    result = userObj.userResult(userNum, generatedNum);

                    // Display the result
                    System.out.println("generated num"+generatedNum);
                    System.out.println("You guessed: " + userNum);

                    if (result) {
                        System.out.println("Congratulations! You guessed the number correctly.");
                        System.out.println("Number of Attempts : " + attempts);
                        
                    } else {
                        System.out.println("Sorry, your guess was incorrect. Try again!");
                        
                        if(attempts == 2) {
                        	System.out.println(hits.levelOneHint(userNum, generatedNum));
                        }
                        if(attempts == 4) {
                        	System.out.println(hits.levelTwoHint(userNum, generatedNum));
                        }  
                    }
                }
                attempts =0;

                // Ask if the user wants to play again
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = sc.next();

                if (!playAgain.equalsIgnoreCase("yes")) {
                	
                    System.out.println("Thank you for playing!");
                    break;
                }
            }
        }
    }
}
