package Lanterns;
//Youser Alalusi
//February 5, 2020
//Chapter 2 part 1
//Runs everything in the Helper class
public class DrawingMain {

	public static void main(String[] args) {
		draw();
		
	}
	/**
	 * Draws the chapter 2 lab image
	 */
	public static void draw() {
		//print a line
		DrawingHelper.line();
		//print two top protions
		DrawingHelper.top();
		DrawingHelper.top();
		//print another line
		DrawingHelper.line();
		//print two bottom portions
		DrawingHelper.bottom();
		DrawingHelper.bottom();
		//print the last line
		DrawingHelper.line();
	}
}
