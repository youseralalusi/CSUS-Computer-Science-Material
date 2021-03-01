
/** 
 * Youser Alalusi
 * CSC 15 Ben White
 * Project 1 - This project creates a picture of a rocket that can change in size by unputting a different number in the constant.
 * February 16, 2020
 */


//Main class to draw the rocket
public class DrawRocket {
		
	public static void main(String[] args) {
		// Prints top tirangle part of the rocket
		RocketHelper.top();
		
		// Prints the horizontal line of the rocket
		RocketHelper.line();
		
		// Prints the top part of the box
		RocketHelper.topHalf();
		
		//Prints the bottom half of the box
		RocketHelper.bottomHalf();
		
		// Prints the horizontal line of the rocket
		RocketHelper.line();
		
		//Prints the bottom half of the box
		RocketHelper.bottomHalf();
		
		// Prints the top part of the box
		RocketHelper.topHalf();
		
		// Prints the horizontal line of the rocket
		RocketHelper.line();
		
		// Prints top tirangle part of the rocket
		RocketHelper.top();
		
	}

}
