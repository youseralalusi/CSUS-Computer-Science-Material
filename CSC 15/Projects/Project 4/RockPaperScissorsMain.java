//importing Scanner
import java.util.Scanner;

/**
 *@author Youser Alalusi
 *CSC 15 Ben White
 *April 12, 2020
 */

public class RockPaperScissorsMain {
	//main method
	public static void main(String[] args) {//main method

		// Scanner class object which is used to get the inputs entered by the user.
		Scanner kb = new Scanner(System.in);
		//while loop which iterates infinite times
		while (true) {
			//intro method which prints introduction
			intro();
			//play method to play and see the score
			RockPaperScissorsHelper.play();
			//printing a dash line
			System.out.println("------------------");
			//prompting user to play again
			System.out.print("Do you want to play again? ");
			//if yes nothing happens and loop runs again
			if (kb.next().equalsIgnoreCase("Yes")) {
			} else {
				//else prints this statement
				System.out.println("GOOD BYE. COME BACK SOON");
				//breaks out of the loop
				break;
			}
		}
	}

	// This method prints the introduction with all rules of the game

	public static void intro() {
		System.out.println("Using this app you can play Rock-Paper-Scissors game against the\ncomputer. When played between two people, each person picks one of\nthe three options at the same time, and the winner is determined. The\nprogram should randomly choose one of the three options, then prompt\nfor the user�s selection. At that point,the program reveals both\nchoices and print a statement indicating if the user won, the\ncomputer won, or if it was a tie. Continue playing until the user\nchoose to stop. Then print the total number of the games played,\ntotal wins, total losses, and total ties.");
		//printing statement where "\n" breaks the line "\r" moves cursor to the beginning of the line
		System.out.println("\nReady, Set, Go");
	}
}