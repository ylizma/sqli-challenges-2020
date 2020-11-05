package challenges.shapes;

public class Square implements Shape {

    private int x;

    @Override
    public int getDimension() {
        return x*x;
    }
}
