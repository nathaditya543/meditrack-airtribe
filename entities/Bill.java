package entities;

import java.time.LocalDateTime;

public class Bill {
    final int billId;
    final int appointmentId;
    // final int patientId;
    // final int doctorId;
    // final long durationMinutes;
    // final double ratePerMinute;
    // final double totalAmount;
    boolean status;
    final LocalDateTime generatedAt;

    Bill(int billId, int appointmentId, boolean status, LocalDateTime generatedAt) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.status = status;
        this.generatedAt = generatedAt;
        // doctorId = AppServ.getDoc(appointmentId);
        // patientId = AppServ.getPat(appointmentId);
        // totalAmount = BillServ.getAmount(appointmentId);

    }

    int getBillId() {
        return billId;
    }

    int getAppointmentId() {
        return appointmentId;
    }

    // int getPatientId() {
    //     return patientId;
    // }

    // int getDoctorId() {
    //     return doctorId;
    // }

    // long getDurationMinutes() {
    //     return durationMinutes;
    // }

    // double getRatePerMinute() {
    //     return ratePerMinute;
    // }

    // double getTotalAmount() {
    //     return totalAmount;
    // }

    boolean getStatus() {
        return status;
    }

    LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
