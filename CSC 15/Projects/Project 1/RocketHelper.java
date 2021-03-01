
/** 
 * Youser Alalusi
 * CSC 15 Ben White
 * Project 1 - This project creates a picture of a rocket that can change in size by unputting a different number in the constant.
 * February 16, 2020
 */

public class RocketHelper {
	
	// Class constant
	public static final int HEIGHT = 3;
	
	//Prints top part of image and the tail
	public static void top() {
		// Loop 9 times in a row
		for(int line = 1; line <= ((HEIGHT * 2) -1); line++) {
			// Print spaces
			System.out.print(" ");
			
			// Print spaces
			for(int i = 2; i <= -1 * line + (HEIGHT * 2) ; i++) {
		
				System.out.print(" ");
			}
			
			// Print forward slash "/"
			for(int i = 1; i <= 1 * line; i++) {
				System.out.print("/");
			}
			
			// Print stars
			for(int i = 1; i <= 0 * line + 2; i++) {
				System.out.print("*");
			}
			
			//Print backward slash "\"
			for(int i = 1; i <= 1 * line; i++) {
				System.out.print("\\");
			}
			System.out.println("");
			}

		}
	
	//Prints horizontal line
	public static void line() {
		//Print +
		System.out.print("+");
		
		//Prints =*
		for(int i = 1; i <= (HEIGHT * 2); i++) {
			System.out.print("=*");
		}
		System.out.println("+");
	}
	
	//Print top part                    
	public static void topHalf() {
		//Print loop for 5 rows
		for(int line = 1; line <= HEIGHT; line++) {
			System.out.print("|");
			
			//Print dots
			for(int i = 1; i <= -1 * line + HEIGHT; i++) {
				System.out.print(".");
			}
			//Print /\
			for(int i = 1; i <= 1 * line; i++) {
				System.out.print("/\\");
			}
			//Print dots
			for(int i = 1; i <= -1 * line + HEIGHT; i++) {
				System.out.print(".");
			}
				//Print dots
				for(int i = 1; i <= -1 * line + HEIGHT; i++) {
					System.out.print(".");
				}
				//Print /\
				for(int i = 1; i <= 1 * line; i++) {
					System.out.print("/\\");
				}
				//Print dots
				for(int i = 1; i <= -1 * line + HEIGHT; i++) {
					System.out.print(".");
				}
				//Print loop for 5 rows
				for(int  i = 1; i <= line * 0 + 1; i++) {
					System.out.print("|");
				}
			    System.out.println("");
		}
				
		
	}
	//Print bottom half
	public static void bottomHalf() {
		//Print loop for 5 rows
				for(int line = 1; line <= HEIGHT; line++) {
					System.out.print("|");
					
					//Print dots
					for(int i = 1; i <= 1 * line - 1; i++) {
						System.out.print(".");
					}
					//Print \/
					for(int i = 1; i <= -1 * line + HEIGHT + 1; i++) {
						System.out.print("\\/");
					}
					//Print dots
					for(int i = 1; i <= 1 * line - 1; i++) {
						System.out.print(".");
					}
					//Print dots
					for(int i = 1; i <= 1 * line - 1; i++) {
						System.out.print(".");
					}
					
					//Print \/
					for(int i = 1; i <= -1 * line + HEIGHT + 1; i++) {
						System.out.print("\\/");
					}
					
					//Print dots
					for(int i = 1; i <= 1 * line - 1; i++) {
						System.out.print(".");
					}
					// Print pipe
					for(int i = 1; i <= 1; i++) {
						System.out.print("|");
					}
					
					
					System.out.println(" ");	
		}
				
	}
	
	
	}

