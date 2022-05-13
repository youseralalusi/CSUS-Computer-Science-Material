
/**
 *
 * @author 
 */
public class PRTask extends Task{

    public PRTask(String line) {
        super(line);
    }

    @Override
    public int compareTo(Task o) {
        return this.getPrior() - o.getPrior();
    }
    
}
