package challenges.train;

public class Restaurant extends TrainDecorator {

    public Restaurant(Wagon wagon) {
        super(wagon);
    }

    @Override
    public String print() {
        return wagon.print() + "|hThT|";
    }
}
