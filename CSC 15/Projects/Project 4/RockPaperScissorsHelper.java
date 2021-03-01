/**
 *@author Youser Alalusi
 *CSC 15 Ben White
 *April 12, 2020
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsHelper {
	/**
	 * This method is the most important method for the whole game play.This method
	 * uses all the user(),comChoice(), choice() methods and calculates the number
	 * of wins,looses,Ties in the total match and prompts the user to play again at
	 * the end of the game,if interested.
	 */
	public static void play() {
		//Initializing Random variable
		Random x = new Random();
		//initializing Scanner
		Scanner scan = new Scanner(System.in);
		//integer value which counts of ties
		int ties = 0;
		//integer value which counts of wins
		int wins = 0;
		//integer value which counts of losses
		int loses = 0;
		while (true) {
			//printing the statement
			System.out.print("\nYour choices are \n\tRock\r\n \tPaper\n \tScissors\n \tStop\nEnter your choice: ");
			//sending scanner object
			String us = user(scan);
			//taking a random computer's number and assigning the corresponding string value
			String compChoice = choice(comChoice(x));
			//checking all the conditions
			if (us.toUpperCase().equalsIgnoreCase("ROCK") && compChoice.toUpperCase().equalsIgnoreCase("ROCK")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.print("There is a tie ");
				//if equal tie count is incremented
				ties++;
			} else if (us.toUpperCase().equalsIgnoreCase("PAPER")
					&& compChoice.toUpperCase().equalsIgnoreCase("PAPER")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.print("There is a tie ");
				//if equal tie count is incremented
				ties++;
			} else if (us.toUpperCase().equalsIgnoreCase("SCISSORS")
					&& compChoice.toUpperCase().equalsIgnoreCase("SCISSORS")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.print("There is a tie ");
				//if equal tie count is incremented
				ties++;
			} else if (us.toUpperCase().equalsIgnoreCase("ROCK")
					&& compChoice.toUpperCase().equalsIgnoreCase("PAPER")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Oh No, you lost");
				//if equal looses count is incremented
				loses++;
			} else if (us.toUpperCase().equalsIgnoreCase("ROCK")
					&& compChoice.toUpperCase().equalsIgnoreCase("SCISSORS")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Hurray! You won.");
				//if equal wins count is incremented
				wins++;
			} else if (us.toUpperCase().equalsIgnoreCase("PAPER")
					&& compChoice.toUpperCase().equalsIgnoreCase("ROCK")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Hurray! You won.");
				//if equal wins count is incremented
				wins++;
			} else if (us.toUpperCase().equalsIgnoreCase("PAPER")
					&& compChoice.toUpperCase().equalsIgnoreCase("SCISSORS")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Oh No, you lost");
				//if equal looses count is incremented
				loses++;
			} else if (us.toUpperCase().equalsIgnoreCase("SCISSORS")
					&& compChoice.toUpperCase().equalsIgnoreCase("ROCK")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Oh No, you lost");
				//if equal looses count is incremented
				loses++;
			} else if (us.toUpperCase().equalsIgnoreCase("SCISSORS")
					&& compChoice.toUpperCase().equalsIgnoreCase("PAPER")) {
				System.out.println("Computer selected: " + compChoice + " You selected : " + us.toUpperCase());
				System.out.println("Hurray! You won.");
				//if equal wins count is incremented
				wins++;
			} else if (us.toUpperCase().equalsIgnoreCase("STOP")) {
				System.out.println("---------------");
				System.out.println("Here is the result of the play:\r\n" + "Times played: " + (wins + loses + ties)
						+ "\r\n" + "wins: " + wins + "\r\n" + "Losses: " + loses + "\r\n" + "Ties : " + ties);
				if (wins > loses) {
					System.out.println("Congratulations! You won.");
					break;
				} else if (wins < loses) {
					System.out.println("Sorry computer won this time. Try again");
					break;
				} else if (wins == loses) {
					System.out.println("Tied Try Again");
					break;
				}

			}
		}
	}

	/**
	 * This method is used to take User input and validate it
	 * @param scan is a Scanner object to take input from the user
	 * @return a String value if valid either "rock","paper","scissors" or "stop"
	 */
	public static String user(Scanner scan) {
		//taking user input
		String s = scan.next();
		while (true) {
			//converting the string to uppercase and comparing them
			if (s.toUpperCase().equalsIgnoreCase("ROCK") || s.toUpperCase().equalsIgnoreCase("PAPER")
					|| s.toUpperCase().equalsIgnoreCase("SCISSORS") || s.toUpperCase().equalsIgnoreCase("STOP")) {
				//if input given is correct breaks out of the loop
				break;
				//else asks the user until valid input is given
			} else {
				System.out.print("Your choices are\n \tRock\r\n" + "\tPaper\n \tScissors\n \tStop\n" + "\r\n" + "Enter your choice: ");
				s = scan.next();
			}
		}
		//returns the entered input
		return s.toUpperCase();
	}

	/**
	 * comChoice is computers choice which takes a random object and return 0, 1 or 2
	 * @param x is a Random object
	 * @return an integer value randomly either 0,1 or 2
	 */
	public static int comChoice(Random x) {
		//returns a random number from 0 to 2
		return x.nextInt((2 - 0) + 1) + 0;
	}

	/**
	 * this method is used to return a String according to its corresponding number
	 * either "rock","paper"or"scissors"
	 * @param x is a number to switch in between string values
	 * @return a String either "ROCK","PAPER" OR "SCISSORS" depending on the number
	 *	else returns "Something went wrong" by default
	 */
	public static String choice(int x) {
		switch (x) {
		case 0:
			//if x =0 "Rock" is returned as String
			return "Rock";
		case 1:
			//similarly if case = 1returns Paper
			return "Paper";
		case 2:
			//and so on
			return "Scissors";
		default:
			//if number is not correct prints this statement
			System.out.println("Something went wrong");
			//return this
			return "Something went wrong";
		}
	}  
}
