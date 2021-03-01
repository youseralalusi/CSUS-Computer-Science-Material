/** Youser Alalusi
 * CSC15
 * Ben White
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hokeemon {
	//Fields
	private String name;
	private String type;
	private int age;
	
	public Hokeemon() {
		name = "";
		type = "";
		age = 0;
	}
	
	public Hokeemon(String initName, String initType, int initAge) {
		name = initName;
		type = initType;
		age = initAge;
	}
	//Accessors
	public  String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getAge() {
		return age;
	}
	
	//Mutators
	public void setName(String newName) {
		name = newName;
	}
	public void setType(String newType) {
		type = newType;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public boolean isFriends(Hokeemon other) {
		//Hokeemons of the same type are friends
		if(type.equalsIgnoreCase(other.type)) {
			return true;
		}
		
		//Also, dwarves and elves are friends
		//and hobbits and fairies are friends
		String type1 = type.toLowerCase();
		String type2 = other.type.toLowerCase();
		
		return type1.equals("dwarf") && type2.equals("elf")
		|| type2.equals("dwarf") && type1.equals("elf") 
		|| type1.equals("hobbit") && type2.equals("fairy")
		|| type2.equals("hobbit") && type1.equals("fairy");
		
		
	}
	
	public String toString() {
		String result = String.format("\nName: %s, Type: %s, Age: %d", name, type, age);
		return result;
	}
	
	public static Hokeemon[] getData(String filename) {
		File f = new File(filename);
		try {
			Scanner fileReader = new Scanner(f);
			int numRecords = fileReader.nextInt();
			Hokeemon[] myHokeemon = new Hokeemon[numRecords];
			
			for(int i = 0; i < myHokeemon.length; i++) {
				String name = fileReader.next();
				String type = fileReader.next();
				int age = fileReader.nextInt();
				
				myHokeemon[i] = new Hokeemon(name, type, age);
				
			}
			
			fileReader.close();
			return myHokeemon;
			
		
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		return null;
		}
	
	public String liveIn() {

		if (this.type.equalsIgnoreCase("dwarf")) {

			return "Mountain";
	    } 
		else if (this.type.equalsIgnoreCase("elf")) {

	        return "Dale";
	    } 
		else if (this.type.equalsIgnoreCase("fairy")) {

	        return "Forest";
	    } 
		else {

	        return "Shire";
	    }
	}
	
	public static String getBio(Hokeemon[] myHokeemons) {

		String s = "";
	    for (Hokeemon hokeemon : myHokeemons) {

	    	s += "I am " + hokeemon.getName() + ": Type " + hokeemon.getType() + ": Age=" + hokeemon.getAge()
	                   + ", I live in the " + hokeemon.liveIn() + "\n";
	        s += "My friends are: ";
	        for (Hokeemon hokeemon2 : myHokeemons) {

	        	if (hokeemon.isFriends(hokeemon2) && !hokeemon.equals(hokeemon2)) {

	        		s += (hokeemon2.getName() + " ");

	            }
	        }
	        s += "\n";
	    }

	       return s;
	}
}
