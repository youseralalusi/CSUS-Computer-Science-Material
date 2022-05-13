
public class SJFTask  extends Task{

    public SJFTask(String line) {
        super(line);
    }

    @Override
    public int compareTo(Task o) {
        if (this.getbTime() == o.getbTime()) {
            return this.getaTime() - o.getaTime();
        }
        return this.getbTime() - o.getbTime();
    }
    
}
