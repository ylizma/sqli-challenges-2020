package challenges.train;

public class TrainDecorator implements Wagon {

    Wagon wagon;

    public TrainDecorator(Wagon wagon) {
        this.wagon = wagon;
    }

    @Override
    public String print() {
        return wagon.print();
    }
}
