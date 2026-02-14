package services;

import entities.*;
import exceptions.IdNotFound;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppService {
    ArrayList<Appointment> appList = new ArrayList<>();

    void addApp(int id, Doctor doc, Patient pat, LocalDateTime startTime, LocalDateTime endTime){
        Appointment newApp  = new Appointment(id, doc, pat, startTime, endTime);
        appList.add(newApp);
        pat.addApp(newApp);
        doc.addApp(newApp);
    }

    public Appointment getAppointment(int id){
        for(Appointment appointment: appList){
            if(appointment.getId() == id)
                return appointment;
        }
        throw new IdNotFound("Appointment with ID " + id + " not found");
    }
}
