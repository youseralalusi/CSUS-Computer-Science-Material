/** Youser Alalusi
 * CSC15
 * Ben White
 */
import java.util.Arrays;

public class HokeemonMain {

	public static void main(String[] args) {
		
		Hokeemon frodo = new Hokeemon("Frodo", "hobbit", 17);
		Hokeemon unknown = new Hokeemon();
		Hokeemon logolas = new Hokeemon("Legolas", "Elf", 77);
		
		
		//System.out.println(frodo);
		//System.out.println(unknown);
		
		
		if(frodo.isFriends(unknown)) {
			System.out.println("We are friends!");
			
		}
		else {
			//System.out.println("We are NOT friends");
		}
		Hokeemon[] myHokeemon = Hokeemon.getData("Data.txt");
		System.out.println(Arrays.toString(myHokeemon));
		System.out.println();
		System.out.println(Hokeemon.getBio(myHokeemon));
	}

}
