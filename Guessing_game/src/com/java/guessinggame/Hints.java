package com.java.guessinggame;

public class Hints {

	int lowerBound = 0;
	int upperBound = 100;
	
	 String levelOneHint (int userNum , int generatedNum) {
		if (userNum < generatedNum) {
            lowerBound = userNum + 1;
            return "Hint: The correct number is between " + lowerBound + " and " + upperBound +" . ";
        } else {
            upperBound = userNum - 1;
            return "Hint: The correct number is between " + lowerBound + " and " + upperBound+" . ";
        }
		
	}
	
	 String levelTwoHint(int userNum, int generatedNum) {
		    int sum = userNum + generatedNum;
		    return "The sum of your last guessed number and the generated number is: " + sum + ".";
	}

}
