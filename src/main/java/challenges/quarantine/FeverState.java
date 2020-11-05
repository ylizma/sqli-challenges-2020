package challenges.quarantine;

public class FeverState implements PatientState {

    @Override
    public String currentState() {

        return "fever";
    }
}
