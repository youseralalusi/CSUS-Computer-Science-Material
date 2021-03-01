/**
 * @author Youser Alalusi
 * Ben White - CSC15
 * 3/11/2020
 */
import java.util.Scanner;

public class Lab4Helper {
	// Method returns what the season is due to what the user's input is of the temperature
	public static String probableSeason(double temp) {
		if(temp >= 90 && temp < 110)
			return "Summer";
		else if(temp >= 70 && temp < 90)
			return "Spring";
		else if(temp >= 50 && temp < 70)
			return "Fall";
		else if(temp >= 110 || temp < -5)
			return null;
		else
			return "Winter";
		}
	
	// Method declares what type of sentence user inputs
	public static String sentenceAnalyser(String sentence) {

		if(sentence.endsWith("."))
			return "declarative";
		else if(sentence.endsWith("?"))
			return "interrogative";
		else if(sentence.endsWith("!"))
			return "exclamatory";
		else
			return "unknown sentence type";

	}
	
	// Method shows options to user of what kind of sentence they want to input
	public static String getOption(Scanner kb) {
		System.out.println("Choose one of the following options:");
		System.out.println("1.Sentence analyzer");
		System.out.println("2.Probable Season");
		System.out.print("Enter your option-->");
		String input = kb.nextLine();
		if(input.equalsIgnoreCase("sentence analyzer"))
			return "Sentence analyzer";
		else if(input.equalsIgnoreCase("probable season"))
			return "Probable Season";
		else
			return "unknown choice";

	}

}
