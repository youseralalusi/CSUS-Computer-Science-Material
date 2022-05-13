
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoundRobin implements SchedulingMethod {

    private int quantum;
    private ArrayList<Task> tasks;

    /**
     * constructor
     *
     * @param scanner input stream
     * @param quantum
     */
    public RoundRobin(Scanner scanner, int quantum) {
        // array list of task 
        tasks = new ArrayList<>();
        // time to run a task
        this.quantum = quantum;
        // read each line 
        while (scanner.hasNext()) {
            // parse line to task
            RRTask task = new RRTask(scanner.nextLine());
            // add to the list 
            tasks.add(task);
        }
    }

    /**
     * run all tasks
     *
     * @param fileWriter output stream
     */
    @Override
    public void run(FileWriter fileWriter) {
        try {
            fileWriter.write("   RR " + quantum + System.lineSeparator());
            int time = 0;
            int tick = 0;
            MyPriorityQueue<Task> mpq = new MyPriorityQueue<>();
            RRTask current = null;
            int totalWatingTime = 0;
            int waitingCounter = 0;

            // stop the loop when all thing has been done
            while (current != null
                    || mpq.isEmpty() == false
                    || tasks.isEmpty() == false) {

                // add new tasks to the queue when its time comes
                while (tasks.isEmpty() == false
                        && tasks.get(0).getaTime() <= time) {
                    RRTask rrt = (RRTask) tasks.remove(0);
                    mpq.enqueue(rrt);
                }

                // if the CPU is free and there is waiting task
                if (current == null && mpq.isEmpty() == false) {
                    // get the task
                    current = (RRTask) mpq.dequeue();
                    // print a message to output 
                    fileWriter.write(
                            String.format("   %-4d%d",
                                    time, current.getpNumber())
                            + System.lineSeparator());
                    // sum up waiting time 
                    if (time > current.getaTime()) {
                        waitingCounter++;
                        totalWatingTime += time - current.getaTime();
                    }
                }

                // run the task in CPU
                if (current != null) {
                    // burst time or run out of quantum
                    if (tick >= quantum 
                            || tick >= current.getbTime()) {
                        // update burst time
                        current.setbTime(current.getbTime() - tick);
                        if (current.getbTime() > 0) {
                            current.setaTime(time);
                            mpq.enqueue(current);
                        }
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
            System.out.println(ex.getMessage());
        }
    }

}
