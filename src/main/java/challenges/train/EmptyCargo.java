package challenges.train;

public class EmptyCargo extends TrainDecorator {

    public EmptyCargo(Wagon wagon) {
        super(wagon);
    }
    public String print(){
        return wagon.print() + "|____|";
    }
}
