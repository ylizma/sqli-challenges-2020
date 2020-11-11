package challenges.elevator;

import java.util.List;

public class ElevatorService {

    private List<Elevator> elevators;

    public ElevatorService(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public String requestElevator(int i) {
        if (i == -1) {
            this.sortElevatorsByFloor();
            return this.elevators.get(0).getId();
        } else {
            this.sortElevatorsByClosestFloor(i);
            return this.elevators.get(0).getId();
        }

    }

    private void sortElevatorsByClosestFloor(int i) {
        this.elevators.sort((o1, o2) -> Integer.compare(o2.getCurrentFloor() - i, o1.getCurrentFloor() - i));
    }

    public void sortElevatorsByFloor() {
        this.elevators.sort((o1, o2) -> Integer.compare(o2.getCurrentFloor(), o1.getCurrentFloor()));
    }

    public void move(String elevatorId, String direction) {
        Elevator elevator = findElevatorById(elevatorId);
        if (elevator != null) {
            if (direction.equalsIgnoreCase("DOWN") && elevator.getCurrentFloor() != 1) {
                elevator.setCurrentState(elevator.changeToDown());
            } else if (direction.equalsIgnoreCase("UP") && elevator.getCurrentFloor() != elevator.getMaxFloor()) {
                elevator.setCurrentState(elevator.changeToUp());
            }
        }
    }

    public Elevator findElevatorById(String elevatorId) {
        for (Elevator elevator : elevators) {
            if (elevator.getId().equals(elevatorId))
                return elevator;
        }
        return null;
    }

    public void stopAt(String elevatorId, int floorNumber) {
        Elevator elevator = findElevatorById(elevatorId);
        elevator.setCurrentFloor(floorNumber);
        elevator.setCurrentState(elevator.changeToRest());
    }
}
