package challenges.shapes;

public class Rectangle implements Shape {
    private int x;
    private int y;

    @Override
    public int getDimension() {
        return x*y;
    }
}
