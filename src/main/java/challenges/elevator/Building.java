package challenges.elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {

    List<Elevator> elevators;
    int numberOfFloors;
    ElevatorService elevatorService = new ElevatorServiceImp();

    public Building(int numberOfFloors, String... elevators) {

        this.elevators = new ArrayList<>();
        this.numberOfFloors = numberOfFloors;

        for (String elevator : elevators
        ) {
            String[] elev = elevator.split(":");
            Elevator el = new Elevator(elev[0], Integer.parseInt(elev[1]));

            this.elevators.add(el);

        }
    }

    public String requestElevator() {
        return this.elevatorService.getCloserElevator(this.elevators).name;
    }

    public void move(String elevatorId, String state) {
        if (state.equals("UP")) this.elevatorService.moveElevatorUp(this.elevators,elevatorId,this.numberOfFloors);
        else if(state.equals("DOWN")) this.elevatorService.moveElevatorDown(this.elevators,elevatorId);
    }

    public void stopAt(String id3, int i) {
        this.elevatorService.stopElevatorAt(id3,i,this.elevators);
    }
}
