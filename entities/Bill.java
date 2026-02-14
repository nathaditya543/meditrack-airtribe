package entities;

import java.time.LocalDateTime;

public class Bill {
    int billId;
    Appointment appointment;
    boolean status;
    LocalDateTime generatedAt;
    double amount;

    public Bill(int billId, Appointment appointment, LocalDateTime generatedAt) {
        this.billId = billId;
        this.appointment = appointment;
        this.status = false;
        this.generatedAt = generatedAt;
    }

    public int getBillId() {
        return billId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public double getAmount(){
        return amount;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void  setStatus(boolean status){
        this.status = status;
    }
}
