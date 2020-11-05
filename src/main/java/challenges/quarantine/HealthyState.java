package challenges.quarantine;

public class HealthyState implements PatientState {
    @Override
    public String currentState() {

        return "healthy";
    }
}
