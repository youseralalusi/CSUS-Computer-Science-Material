
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SJF implements SchedulingMethod {

    private ArrayList<Task> tasks;

    /**
     * constructor
     *
     * @param scanner input stream
     */
    public SJF(Scanner scanner) {
        // array list of task 
        tasks = new ArrayList<>();
        // read each line 
        while (scanner.hasNext()) {
            // parse line to task
            SJFTask task = new SJFTask(scanner.nextLine());
            // add to the list 
            tasks.add(task);
        }
    }

    @Override
    public void run(FileWriter fileWriter) {
        try {
            fileWriter.write("   SJF" + System.lineSeparator());
            int time = 0;
            int tick = 0;
            MyPriorityQueue<Task> mpq = new MyPriorityQueue<>();
            SJFTask current = null;
            int totalWatingTime = 0;
            int waitingCounter = 0;

            // stop the loop when all thing has been done
            while (current != null
                    || mpq.isEmpty() == false
                    || tasks.isEmpty() == false) {

                // add new tasks to the queue when its time come
                while (tasks.isEmpty() == false
                        && tasks.get(0).getaTime() <= time) {
                    SJFTask sjft = (SJFTask) tasks.remove(0);
                    mpq.enqueue(sjft);
                }

                // if the CPU is free and there is waiting task
                if (current == null && mpq.isEmpty() == false) {
                    // get the task
                    current = (SJFTask) mpq.dequeue();
                    // print a message to output 
                    fileWriter.write(
                            String.format("   %-4d%d",
                                    time, current.getpNumber())
                            + System.lineSeparator());
                    // sum up waiting time 
                    if (time >= current.getaTime()) {
                        waitingCounter++;
                        totalWatingTime += time - current.getaTime();
                    }
                }

                // run the task in CPU
                if (current != null) {
                    // burst time
                    if (tick >= current.getbTime()) {

                        current = null;
                        tick = 0;
                    } else {
                        // the task is running
                        tick++;
                        time++;
                    }
                } else {
                    // nothing is running
                    time++;
                }
            }

            // print avg time 
            if (waitingCounter > 0) {
                fileWriter.write(
                        String.format("AVG Waiting Time: %f",
                                (double) totalWatingTime / waitingCounter)
                        + System.lineSeparator());
            } else {
                fileWriter.write(
                        String.format("AVG Waiting Time: 0")
                        + System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
