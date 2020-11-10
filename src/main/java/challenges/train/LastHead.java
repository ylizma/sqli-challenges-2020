package challenges.train;

public class LastHead extends TrainDecorator {
    public LastHead(Wagon wagon) {
        super(wagon);
    }

    @Override
    public String print() {
        return wagon.print() + "HHHH>";
    }
}
