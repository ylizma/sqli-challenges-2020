package challenges.elevator;

public class Elevator {
    String name;
    int currentFloor;
    String state;

    public Elevator(String name, int currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.state = "REST";
    }

    public Elevator(String elevatorId) {
        this.name = elevatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
