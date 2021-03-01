/* Youser Alalusi
 * CSC 15 Lab 1 
 * Ben White
 * January 28, 2020
 * Chapter 1 Part 2 (Lanterns)-printing 3 different lanterns
 */
package Lanterns;
public class Lanterns {

	public static void main(String[] args) {
		topHat();
		System.out.println();
		topHat();
		rocketBody();
		line();
		topHat();
		System.out.println();
		topHat();
		lantern();
		rocketBody();
		rocketBody();
		lantern();
		lantern();
	}
	public static void topHat() {
		System.out.println("     *****           *****     ");
		System.out.println("   *********       *********   ");
		line();
	}
	public static void rocketBody() {
		System.out.println(" * | | | | | *   * | | | | | * ");
		
	}
	public static void lantern() {
		System.out.println("     *****           *****     ");
	}
	public static void line() {
		System.out.println(" *************   ************* ");
	}
}
