package services;

import entities.Doctor;
import exceptions.IdNotFound;
import  java.util.ArrayList;

public class DocService {
    ArrayList<Doctor>  docList = new ArrayList<>();

    void AddDoc(int  exp, int  id, String name, String spec, double consultationFee, double ratePerMinute){
        Doctor newDoc = new Doctor(exp, id, name, spec, consultationFee, ratePerMinute);
        docList.add(newDoc);
    }

    public Doctor getDoctor(int id) {
        for (Doctor doctor : docList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        throw new IdNotFound("Doctor with ID " + id + " not found");
    }
}
