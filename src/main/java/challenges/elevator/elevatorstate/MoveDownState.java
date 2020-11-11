package challenges.elevator.elevatorstate;

import challenges.elevator.Elevator;

public class MoveDownState implements ElevatorState {

    private Elevator elevator;

    public MoveDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveUp() {
        this.elevator.setCurrentState(elevator.changeToUp());
    }

    @Override
    public void moveDown() {
        System.out.println("already down");
    }

    @Override
    public void rest() {
        this.elevator.setCurrentState(elevator.changeToRest());
    }

    @Override
    public String currentState() {
        return "DOWN";
    }
}
