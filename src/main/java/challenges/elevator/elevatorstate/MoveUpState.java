package challenges.elevator.elevatorstate;

import challenges.elevator.Elevator;

public class MoveUpState implements ElevatorState {

    Elevator elevator;

    public MoveUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveUp() {
        System.out.println("already up");
    }

    @Override
    public void moveDown() {
        this.elevator.setCurrentState(elevator.changeToDown());
    }

    @Override
    public void rest() {
        this.elevator.setCurrentState(elevator.changeToRest());
    }

    @Override
    public String currentState() {
        return "UP";
    }
}
