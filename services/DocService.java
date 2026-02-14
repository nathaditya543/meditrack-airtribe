package services;

import entities.Doctor;
import exceptions.IdNotFound;
import  java.util.ArrayList;
import java.util.List;

public class DocService {
    private static final String FILE_PATH = "data/doctors.csv";
    private static final String HEADER = "id,name,exp,spec,consultationFee,ratePerMinute";
    ArrayList<Doctor>  docList = new ArrayList<>();

    public DocService() {
        loadFromCsv();
    }

    public void AddDoc(int  exp, int  id, String name, String spec, double consultationFee, double ratePerMinute){
        Doctor newDoc = new Doctor(exp, id, name, spec, consultationFee, ratePerMinute);
        docList.add(newDoc);
        saveToCsv();
    }

    public Doctor getDoctor(int id) {
        for (Doctor doctor : docList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        throw new IdNotFound("Doctor with ID " + id + " not found");
    }

    public List<Doctor> getDoctorsBySpec(String spec) {
        List<Doctor> matched = new ArrayList<>();
        for (Doctor doctor : docList) {
            if (doctor.getSpec().equalsIgnoreCase(spec)) {
                matched.add(doctor);
            }
        }
        return matched;
    }

    private void loadFromCsv() {
        List<String> lines = CsvStore.readDataLines(FILE_PATH);
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] p = line.split(",", -1);
            if (p.length < 6) {
                continue;
            }
            int id = Integer.parseInt(p[0]);
            String name = p[1];
            int exp = Integer.parseInt(p[2]);
            String spec = p[3];
            double consultationFee = Double.parseDouble(p[4]);
            double ratePerMinute = Double.parseDouble(p[5]);
            docList.add(new Doctor(exp, id, name, spec, consultationFee, ratePerMinute));
        }
    }

    private void saveToCsv() {
        List<String> rows = new ArrayList<>();
        for (Doctor d : docList) {
            rows.add(
                d.getId() + "," +
                d.getName() + "," +
                d.getExp() + "," +
                d.getSpec() + "," +
                d.getConsultationFee() + "," +
                d.getRatePerMinute()
            );
        }
        CsvStore.writeAll(FILE_PATH, HEADER, rows);
    }
}
