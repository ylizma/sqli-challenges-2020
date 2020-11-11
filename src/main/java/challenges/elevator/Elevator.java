package challenges.elevator;

import challenges.elevator.elevatorstate.ElevatorState;
import challenges.elevator.elevatorstate.MoveDownState;
import challenges.elevator.elevatorstate.MoveUpState;
import challenges.elevator.elevatorstate.RestState;

public class Elevator {

    private String id;
    private int currentFloor;
    private int maxFloor;
    //    All states
    private ElevatorState rest, up, down;
    private ElevatorState currentState;

    public Elevator(String id, int currentFloor, int maxFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.maxFloor = maxFloor;
//        states
        this.rest = new RestState(this);
        this.up = new MoveUpState(this);
        this.down = new MoveDownState(this);
        this.currentState = rest;
    }

    public ElevatorState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ElevatorState currentState) {
        this.currentState = currentState;
    }

    public ElevatorState changeToUp() {
        this.currentFloor = this.maxFloor;
        return up;
    }

    public ElevatorState changeToDown() {
        this.currentFloor = 1;
        return down;
    }

    public ElevatorState changeToRest() {
        return rest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public ElevatorState getRest() {
        return rest;
    }

    public void setRest(ElevatorState rest) {
        this.rest = rest;
    }

    public ElevatorState getUp() {
        return up;
    }

    public void setUp(ElevatorState up) {
        this.up = up;
    }

    public ElevatorState getDown() {
        return down;
    }

    public void setDown(ElevatorState down) {
        this.down = down;
    }
}
