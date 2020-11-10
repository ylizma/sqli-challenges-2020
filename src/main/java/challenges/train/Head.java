package challenges.train;

public class Head extends TrainDecorator {

    public Head(Wagon wagon) {
        super(wagon);
    }

    @Override
    public String print() {
        return wagon.print()+"<HHHH";
    }
}
