
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Scheduler {

    public static void main(String[] args) {
        // read input file 
        SchedulingMethod method = readFile("input.txt");

        if (method != null) {
            FileWriter fileWriter = null;
            try {
                // create output stream
                fileWriter = new FileWriter("output.txt");
                // write result to the stream
                method.run(fileWriter);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            
        }
    }

    /**
     * read file 
     * @param fileName
     * @return the algorithm
     */
    private static SchedulingMethod readFile(String fileName) {

        String title = "";
        Scanner scanner = null;
        SchedulingMethod method = null;
        try {
            // open file 
            scanner = new Scanner(new File(fileName));
            // get title of the algorithm
            title = scanner.nextLine();
            
            // skip number of task for we are using java 
            String num = scanner.nextLine();
            
            // rounf robin
            if (title.contains("RR")) {
                String[] sp = title.split("\\s+");
                int quantum = Integer.parseInt(sp[1]);
                method = new RoundRobin(scanner, quantum);
            } 
            // shortest job first
            else if (title.contains("SJF")) {
                method = new SJF(scanner);
            } 
            // without premp
            else if (title.contains("PR_noPREMP")) {
                method = new PR_noPREMP(scanner);
            } 
            // with premp
            else if (title.contains("PR_withPREMP")) {
                method = new PR_withPREMP(scanner);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return method;
    }
}
