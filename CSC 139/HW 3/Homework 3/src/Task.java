
public abstract class Task implements Comparable<Task>{

    private int pNumber;  // process number
    private int aTime; // arrivel time
    private int bTime; // cpu butst time
    private int prior; // priority

    public Task(String line) {
        // split by space 
        String[] sp = line.split("\\s+");
        // assume that input are all legal
        pNumber = Integer.parseInt(sp[0]);
        aTime = Integer.parseInt(sp[1]);
        bTime = Integer.parseInt(sp[2]);
        prior = Integer.parseInt(sp[3]);
    }

    public int getpNumber() {
        return pNumber;
    }

    public int getaTime() {
        return aTime;
    }

    public int getbTime() {
        return bTime;
    }

    public int getPrior() {
        return prior;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }

    public void setaTime(int aTime) {
        this.aTime = aTime;
    }

    public void setbTime(int bTime) {
        this.bTime = bTime;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

}
