package challenges.elevator;

import java.util.List;

public interface ElevatorService {
     void sortElevatorsByFloor(List<Elevator> elevatorList);

     Elevator getCloserElevator(List<Elevator> elevatorList);

     void moveElevatorUp(List<Elevator> elevatorList, String elevatorId, int numberOfFloors);

    void moveElevatorDown(List<Elevator> elevatorList, String elevatorId);

    Elevator findElevator(List<Elevator> elevatorList, String elevatorId);

    void stopElevatorAt(String id3, int i, List<Elevator> elevators);
}
