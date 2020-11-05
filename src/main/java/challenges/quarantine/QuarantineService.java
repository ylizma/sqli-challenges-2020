package challenges.quarantine;

import java.util.List;

public class QuarantineService {

    public String report(List<Patient> patients) {
        int f = 0, h = 0, d = 0, t = 0, x = 0;
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof FeverState) {
                f++;
            } else if (patient.getPatientState() instanceof HealthyState)
                h++;
            else if (patient.getPatientState() instanceof DiabeteState)
                d++;
            else if (patient.getPatientState() instanceof TuberculosisState)
                t++;
            else if (patient.getPatientState() instanceof DeadState)
                x++;
        }
        return "F:" + f + " H:" + h + " D:" + d + " T:" + t + " X:" + x;
    }

    public void aspirin(List<Patient> patients) {
        for (Patient patient : patients
        ) {
            if (patient.getMedicines().contains("paracetamol"))
                patient.setPatientState(new DeadState());
            else if(patient.getPatientState() instanceof FeverState){
                patient.setPatientState(new HealthyState());
            }
            patient.medicines.add("aspirin");
        }
    }

    public void wait40Days(List<Patient> patients) {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof DiabeteState
                    && !patient.getMedicines().contains("insulin")) {
                patient.setPatientState(new DeadState());
            }
        }
    }

    public void antibiotic(List<Patient> patients) {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof TuberculosisState) {
                patient.setPatientState(new HealthyState());
            } else if (patient.getPatientState() instanceof HealthyState
                    && patient.getMedicines().contains("insulin")) {
                patient.setPatientState(new FeverState());
            }
            patient.getMedicines().add("antibiotic");
        }
    }

    public void insulin(List<Patient> patients) {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof HealthyState && patient.getMedicines().contains("antibiotic")) {
                patient.setPatientState(new FeverState());
            }
            patient.getMedicines().add("insulin");
        }
    }

    public void paracetamol(List<Patient> patients) {
        for (Patient patient : patients
        ) {
            if (patient.getMedicines().contains("aspirin")){
                patient.setPatientState(new FeverState());
            }
            else if (patient.getPatientState() instanceof FeverState){
                patient.setPatientState(new HealthyState());
            }
            patient.getMedicines().add("paracetamol");
        }
    }
}
