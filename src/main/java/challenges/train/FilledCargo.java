package challenges.train;

public class FilledCargo extends TrainDecorator {

    public FilledCargo(Wagon wagon) {
        super(wagon);
    }

    public String print() {
        return wagon.print() + "|^^^^|";
    }
}
