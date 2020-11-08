package challenges.quarantine;

public class HealthyState implements PatientState {

    Patient patient;

    public HealthyState(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void isDead() {
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public void hasDiabetes() {
        patient.setPatientState(patient.changeToDiabetes());
    }

    @Override
    public void hasFever() {
        patient.setPatientState(patient.changeToFever());
    }

    @Override
    public void isHealthy() {
        System.out.println("patient is healthy");
    }

    @Override
    public void hasTuberculosis() {
        patient.setPatientState(patient.changeToTuberculosis());
    }

    @Override
    public String currentState() {
        return "healthy";
    }
}
