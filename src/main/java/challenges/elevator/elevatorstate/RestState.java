package challenges.elevator.elevatorstate;

import challenges.elevator.Elevator;

public class RestState implements ElevatorState {

    private Elevator elevator;

    public RestState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void moveUp() {
        this.elevator.setCurrentState(elevator.changeToUp());
    }

    @Override
    public void moveDown() {
        this.elevator.setCurrentState(elevator.changeToDown());
    }

    @Override
    public void rest() {
        System.out.println("already resting");
    }

    @Override
    public String currentState() {
        return "REST";
    }
}
