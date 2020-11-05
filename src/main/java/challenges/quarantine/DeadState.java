package challenges.quarantine;

public class DeadState implements PatientState {
    @Override
    public String currentState() {
        return "Dead";
    }

    public DeadState() {
    }

}
