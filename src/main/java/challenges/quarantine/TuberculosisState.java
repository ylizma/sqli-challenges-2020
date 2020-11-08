package challenges.quarantine;

public class TuberculosisState implements PatientState {

    Patient patient;

    public TuberculosisState(Patient patient) {
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
        patient.setPatientState(patient.changeToHealthy());
    }

    @Override
    public void hasTuberculosis() {
        System.out.println("patient has already tuberculosis");
    }

    @Override
    public String currentState() {
        return "tuberculosis";
    }
}
