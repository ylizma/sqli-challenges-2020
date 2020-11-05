package challenges.elevator;

import java.util.List;

public class ElevatorServiceImp implements ElevatorService {

    @Override
    public void sortElevatorsByFloor(List<Elevator> elevatorList) {
        elevatorList.sort((o1, o2) -> {
            return Integer.compare(o2.currentFloor, o1.currentFloor);
        });
    }

    @Override
    public Elevator getCloserElevator(List<Elevator> elevatorList) {
        this.sortElevatorsByFloor(elevatorList);
        for (Elevator e : elevatorList
        ) {
            System.out.println(e.name + ":" + e.getState() + ":" + e.getCurrentFloor());
        }
        return elevatorList.get(0);
    }

    @Override
    public void moveElevatorUp(List<Elevator> elevatorList, String elevatorId, int numberOfFloors) {
        Elevator elevator = this.findElevator(elevatorList, elevatorId);
        elevator.setCurrentFloor(numberOfFloors);
        elevator.setState("UP");

    }

    @Override
    public void moveElevatorDown(List<Elevator> elevatorList, String elevatorId) {
        Elevator elevator = this.findElevator(elevatorList, elevatorId);
        elevator.setCurrentFloor(1);
        elevator.setState("DOWN ");
    }

    @Override
    public Elevator findElevator(List<Elevator> elevatorList, String elevatorId) {
        for (Elevator e : elevatorList
        ){
        if (e.getName().equals(elevatorId)) return e;
        }
        return null;
    }

    @Override
    public void stopElevatorAt(String id3, int i, List<Elevator> elevators) {
        Elevator elevator = this.findElevator(elevators,id3);
        elevator.setState("REST");
        elevator.setCurrentFloor(i);
    }

}
