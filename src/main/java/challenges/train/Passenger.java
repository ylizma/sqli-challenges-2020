package challenges.train;

public class Passenger extends TrainDecorator {

    public Passenger(Wagon wagon) {
        super(wagon);
    }

    public String print() {
        return wagon.print() + "|OOOO|";
    }
}
