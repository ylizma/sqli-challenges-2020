package challenges.train;

public class Cargo implements Wagon {
    private boolean isFilled;

    @Override
    public String getWagon() {
        return (!isFilled) ? "|____|" : "|^^^^|";
    }

    public Cargo(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
