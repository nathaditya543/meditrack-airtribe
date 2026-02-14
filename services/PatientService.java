package services;

import entities.BloodType;
import entities.Patient;
import exceptions.IdNotFound;
import java.util.ArrayList;

public class PatientService {
    ArrayList<Patient> patList = new ArrayList<>();

    void AddPatient(int id, String name, int age, BloodType bloodType) {
        Patient newPat = new Patient(id, name, age, bloodType);
        patList.add(newPat);
    }

    public Patient getPatient(int id) {
        for (Patient patient : patList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new IdNotFound("Patient with ID " + id + " not found");
    }
}
