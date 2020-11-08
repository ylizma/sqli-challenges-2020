package challenges.quarantine;

public class DiabeteState implements PatientState {

    Patient patient;

    public DiabeteState(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void isDead() {
        patient.setPatientState(patient.changeToDead());
    }

    @Override
    public void hasDiabetes() {
        System.out.println("patient has already diabetes");
    }

    @Override
    public void hasFever() {
        patient.setPatientState(patient.changeToFever());
    }

    @Override
    public void isHealthy() {
        patient.setPatientState(patient.changeToHealthy());
    }

    @Override
    public void hasTuberculosis() {
        patient.setPatientState(patient.changeToTuberculosis());
    }

    @Override
    public String currentState() {
        return "diabetes";
    }
}
