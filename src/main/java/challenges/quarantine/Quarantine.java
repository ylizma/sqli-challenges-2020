package challenges.quarantine;

import java.util.ArrayList;
import java.util.List;

public class Quarantine {
    List<Patient> patients;

    public Quarantine(String s) {
        patients = new ArrayList<>();
        String[] input = s.split(",");
        for (String value : input) {
            Patient patient = new Patient();
            switch (value) {
                case "F":
                    patient.setPatientState(patient.changeToFever());
                    break;
                case "H":
                    patient.setPatientState(patient.changeToHealthy());
                    break;
                case "D":
                    patient.setPatientState(patient.changeToDiabetes());
                    break;
                case "T":
                    patient.setPatientState(patient.changeToTuberculosis());
                    break;
            }
            this.patients.add(patient);
        }
    }

    public String report() {
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
            else if (patient.getPatientState() instanceof DeathState)
                x++;
        }
        return "F:" + f + " H:" + h + " D:" + d + " T:" + t + " X:" + x;
    }

    public void aspirin() {
        for (Patient patient : patients
        ) {
            if (patient.getMedicines().contains("paracetamol"))
                patient.setPatientState(patient.changeToDead());
            else if (patient.getPatientState() instanceof FeverState) {
                patient.setPatientState(patient.changeToHealthy());
            }
            patient.medicines.add("aspirin");
        }
    }

    public void wait40Days() {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof DiabeteState
                    && !patient.getMedicines().contains("insulin")) {
                patient.setPatientState(patient.changeToDead());
            }
        }
    }

    public void antibiotic() {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof TuberculosisState) {
                patient.setPatientState(patient.changeToHealthy());
            } else if (patient.getPatientState() instanceof HealthyState
                    && patient.getMedicines().contains("insulin")) {
                patient.setPatientState(patient.changeToFever());
            }
            patient.getMedicines().add("antibiotic");
        }
    }

    public void insulin() {
        for (Patient patient : patients
        ) {
            if (patient.getPatientState() instanceof HealthyState && patient.getMedicines().contains("antibiotic")) {
                patient.setPatientState(patient.changeToFever());
            }
            patient.getMedicines().add("insulin");
        }
    }

    public void paracetamol() {
        for (Patient patient : patients
        ) {
            if (patient.getMedicines().contains("aspirin")) {
                patient.setPatientState(patient.changeToFever());
            } else if (patient.getPatientState() instanceof FeverState) {
                patient.setPatientState(patient.changeToHealthy());
            }
            patient.getMedicines().add("paracetamol");
        }
    }
}
