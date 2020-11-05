package challenges.quarantine;

import java.util.ArrayList;
import java.util.List;

public class Quarantine {
    List<Patient> patients;
    QuarantineService quarantineService = new QuarantineService();

    public Quarantine(String s) {
        patients = new ArrayList<>();
        Patient patient = null;
        String[] input = s.split(",");
        for (String value : input) {
            switch (value) {
                case "F":
                    patient = new Patient(new FeverState());
                    break;
                case "H":
                    patient = new Patient(new HealthyState());
                    break;
                case "D":
                    patient = new Patient(new DiabeteState());
                    break;
                case "T":
                    patient = new Patient(new TuberculosisState());
                    break;
            }
            this.patients.add(patient);
        }
    }

    public String report() {
        return quarantineService.report(patients);
    }

    public void aspirin() {
        quarantineService.aspirin(patients);
    }

    public void wait40Days() {
        quarantineService.wait40Days(patients);
    }

    public void antibiotic() {
        quarantineService.antibiotic(patients);
    }

    public void insulin() {
        quarantineService.insulin(patients);
    }

    public void paracetamol() {
        quarantineService.paracetamol(patients);
    }
}
