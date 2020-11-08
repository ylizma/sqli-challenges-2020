package challenges.quarantine;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    PatientState healthy, dead, diabetes, fever, tuberculosis;
    PatientState patientState;
    List<String> medicines;

    public Patient() {
        this.healthy = new HealthyState(this);
        this.dead = new DeathState(this);
        this.diabetes = new DiabeteState(this);
        this.fever = new FeverState(this);
        this.tuberculosis = new TuberculosisState(this);
        patientState = healthy;
        this.medicines = new ArrayList<>();
    }

    public void setPatientState(PatientState patientState) {
        this.patientState = patientState;
    }

    public PatientState getPatientState() {
        return patientState;
    }

    public List<String> getMedicines() {
        return medicines;
    }

    public PatientState changeToDead() {
        return dead;
    }

    public PatientState changeToFever() {
        return fever;
    }

    public PatientState changeToDiabetes() {
        return diabetes;
    }

    public PatientState changeToHealthy() {
        return healthy;
    }

    public PatientState changeToTuberculosis() {
        return tuberculosis;
    }
}
