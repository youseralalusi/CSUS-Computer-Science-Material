
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PR_withPREMP implements SchedulingMethod {

    private ArrayList<Task> tasks;

    /**
     * constructor
     *
     * @param scanner input stream
     */
    public PR_withPREMP(Scanner scanner) {
        // array list of task 
        tasks = new ArrayList<>();
        // read each line 
        while (scanner.hasNext()) {
            // parse line to task
            PRTask task = new PRTask(scanner.nextLine());
            // add to the list 
            tasks.add(task);
        }
    }

    /**
     *
     * @param fileWriter output stream
     */
    @Override
    public void run(FileWriter fileWriter) {

        try {
            // first message
            fileWriter.write("   PR_withPREMP" + System.lineSeparator());
            int time = 0;
            int tick = 0;
            MyPriorityQueue<Task> mpq = new MyPriorityQueue<>();
            PRTask current = null;
            int totalWatingTime = 0;
            int waitingCounter = 0;

            // stop the loop when all thing has been done
            while (current != null
                    || mpq.isEmpty() == false || tasks.isEmpty() == false) {

                // add new tasks to the queue when its time comes    
                while (tasks.isEmpty() == false
                        && tasks.get(0).getaTime() <= time) {
                    PRTask prt = (PRTask) tasks.remove(0);
                    mpq.enqueue(prt);
                }

                // if the CPU is free and there is waiting task
                if (current == null && mpq.isEmpty() == false) {
                    current = (PRTask) mpq.dequeue();
                    fileWriter.write(
                            String.format("   %-4d%d",
                                    time, current.getpNumber())
                            + System.lineSeparator());

                    // sum up waiting time 
                    if (time >= current.getaTime()) {
                        waitingCounter++;
                        totalWatingTime += time - current.getaTime();
                    }
                } // check a case when a higher priority task appear
                else if (current != null && mpq.isEmpty() == false) {
                    // if the new task has higher prioiry than the current one 
                    if (current.compareTo(mpq.front()) > 0) {
                        // put the current back to the queue
                        // update it burst time . arrival time                        
                        current.setbTime(current.getbTime() - tick);
                        if (current.getbTime() > 0) {
                            current.setaTime(time);
                            mpq.enqueue(current);
                        }
                        // reset running time of the task ini CPU
                        tick = 0;
                        // get the new task
                        current = (PRTask) mpq.dequeue();
                        // print it out
                        fileWriter.write(
                                String.format("   %-4d%d",
                                        time, current.getpNumber())
                                + System.lineSeparator());
                    }
                }

                // if CPu is running a task
                if (current != null) {
                    // if its time is over 
                    if (tick >= current.getbTime()) {
                        // remove it 
                        current = null;
                        // reset running time of the task ini CPU
                        tick = 0;
                    } else {
                        // other wise update tick and time 
                        tick++;
                        time++;
                    }
                } else {
                    // other wise update time 
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
            System.out.println(ex.getMessage());
        }

    }

}
