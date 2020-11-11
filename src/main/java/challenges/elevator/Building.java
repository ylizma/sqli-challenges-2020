package challenges.elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private int numberOfFloors;
    private List<Elevator> elevators;
    private ElevatorService elevatorService;

    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new ArrayList<>();
//        init list of elevator service
        this.elevatorService = new ElevatorService(this.elevators);
        //init eleators list
        for (String elevator : elevators) {
            Elevator tmpElevator;
            String[] splittedData = elevator.split(":");
            // Constructor
            tmpElevator = new Elevator(splittedData[0], Integer.parseInt(splittedData[1]), numberOfFloors);
            this.elevators.add(tmpElevator);
        }
    }

    public String requestElevator() {
        int i = -1;
        return elevatorService.requestElevator(i);
    }

    public void move(String elevatorId, String direction) {
        elevatorService.move(elevatorId, direction);
    }

    public void stopAt(String elevatorId, int floorNumber) {
        elevatorService.stopAt(elevatorId, floorNumber);
    }

    public String requestElevator(int i) {
        return elevatorService.requestElevator(i);
    }
}
