package challenges.quarantine;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    PatientState patientState;
    List<String> medicines;

    public Patient(PatientState patientState) {
        this.patientState = patientState;
        this.medicines = new ArrayList<>();
    }

    public PatientState getPatientState() {
        return patientState;
    }

    public void setPatientState(PatientState patientState) {
        this.patientState = patientState;
    }

    public List<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<String> medicines) {
        this.medicines = medicines;
    }
}
