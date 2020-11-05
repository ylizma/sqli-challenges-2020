package challenges.quarantine;

public class DiabeteState implements PatientState {

    @Override
    public String currentState() {
        return "diabetes";
    }

    public DiabeteState() {
    }
}
