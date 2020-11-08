package challenges.quarantine;

public class FeverState implements PatientState {

    Patient patient;

    public FeverState(Patient patient) {
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
        System.out.println("patient has already fever");
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
        return "fever";
    }
}
