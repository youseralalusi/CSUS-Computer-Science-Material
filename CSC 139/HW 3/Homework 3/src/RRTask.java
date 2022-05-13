
public class RRTask extends Task{
    
    public RRTask(String line) {
        super(line);
    }

    @Override
    public int compareTo(Task o) {
        return this.getaTime() - o.getaTime();
    }
    
}
