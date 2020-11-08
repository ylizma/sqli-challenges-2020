package challenges.quarantine;

public interface PatientState {

    void isDead();

    void hasDiabetes();

    void hasFever();

    void isHealthy();

    void hasTuberculosis();

    String currentState();
}
