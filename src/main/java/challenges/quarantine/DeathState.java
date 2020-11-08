package challenges.quarantine;

public class DeathState implements PatientState {

    Patient patient;

    public DeathState(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void isDead() {
        System.out.println("dead");
    }

    @Override
    public void hasDiabetes() {
        System.out.println("dead");
    }

    @Override
    public void hasFever() {
        System.out.println("dead");
    }

    @Override
    public void isHealthy() {
        System.out.println("dead");
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("dead");
    }

    @Override
    public String currentState() {
        return "dead";
    }
}
