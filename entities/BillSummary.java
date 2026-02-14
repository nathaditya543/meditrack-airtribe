package entities;

import java.time.LocalDateTime;

public class BillSummary {
    int billId;
    int appointmentId;
    double amount;
    String doctor;
    String patient;
    LocalDateTime startTime;
    LocalDateTime endTime;
    LocalDateTime genTime;

    public BillSummary(int billId, int appointmentId, double amount, String doctor, String patient, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime genTime){
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.doctor = doctor;
        this.patient  = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.genTime  = genTime;
    }

    public int getBillId() {
        return billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getPatient() {
        return patient;
    }

    public String getDoctorId() {
        return doctor;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getGenTime() {
        return genTime;
    }
}
