// Notepad notes provided

import java.util.Scanner;
public class NameMain {

	public static void main(String[] args) {
		Scanner y = new Scanner(System.in);
		String formattedName = NameHelper.getFormattedName(y);
		System.out.println(formattedName);
		
		
		String formattedData = NameHelper.getStudentData(y);
		System.out.println(formattedData);
}

}
