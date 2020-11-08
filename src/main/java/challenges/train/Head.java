package challenges.train;

public class Head implements Wagon {

    private boolean isTail;

    public Head(boolean isTail) {
        this.isTail = isTail;
    }

    @Override
    public String getWagon() {
        return (isTail) ? "HHHH>" : "<HHHH";
    }

}
