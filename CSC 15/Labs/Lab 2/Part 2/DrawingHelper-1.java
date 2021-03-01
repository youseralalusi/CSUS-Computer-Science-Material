
//Youser Alalusi
//February 5, 2020
// Chapter 2 part 1
// Has methods that support the main class


public class DrawingHelper {
	
	public static final int SIZE = 6;
	
	//produces a solid line
	public static void line() {
		System.out.print("+");
		for(int i = 1; i <= SIZE * 2; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	//produces top half
	public static void top() {
		
		//Loop 3 times for the 3 rows 
		for(int i = 1; i <= SIZE; i++) {
			// Print pipe
			System.out.print("|");
	
			// Print 3 - i spaces
			for(int j = 1; j <= SIZE - i; j++) {
				System.out.print(" ");
			}
			
			// Print caret
			System.out.print("^");
			
			// Print 2 * i - 2 spaces
			for(int j = 1; j <= 2 * i - 2; j++) {
				System.out.print(" ");
			}
			//Print another caret
			System.out.print("^");
			
			// Print 3 - i spaces 
			for(int j = 1; j <= SIZE - i; j++) {
				System.out.print(" ");
			}
			
			// Print final pipe character and go to next line
			System.out.print("|\n"); //Println or \n
			
		}
		
	}
	public static void bottom() {
		//Loop 3 times for the 3 rows
		for(int i = 1; i <= SIZE; i++) {
			
			//Print pipe
			System.out.print("|");
			
			//Print spaces
			for(int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			//Print caret
			System.out.print("V");
			
			//Print more spaces
			for(int k = 1; k <= -2 * i + ( SIZE * 2 ); k++) {
				System.out.print(" ");
			}
			//print another caret
			System.out.print("V");
			
			//Print more spaces
			for(int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			//print final pipe
			System.out.print("|\n");
				
		}

	}
}
	
