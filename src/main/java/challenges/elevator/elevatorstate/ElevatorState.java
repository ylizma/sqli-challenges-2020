package challenges.elevator.elevatorstate;

public interface ElevatorState {

    void moveUp();

    void moveDown();

    void rest();

    String currentState();

}
