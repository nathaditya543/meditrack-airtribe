package entities;

import java.time.LocalDateTime;

public class BillSummary {
    int billId;
    int appointmentId;
    int patientId;
    int doctorId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    LocalDateTime genTime;

    public int getBillId() {
        return billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
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
