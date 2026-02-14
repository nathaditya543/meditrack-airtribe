package services;

import entities.*;
import exceptions.IdNotFound;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class BillService {

    ArrayList<Bill> billsList = new ArrayList<>();

    static double getAmount(Appointment appointment){
        double amount = 0.0;

        LocalDateTime startTime =  appointment.getStartTime();
        LocalDateTime endTime  = appointment.getEndTime();
        long duration = Duration.between(startTime, endTime).toMinutes();

        amount = appointment.getDoc().getConsultationFee() + (duration *  appointment.getDoc().getRatePerMinute());

        return amount;
    }

    public void addBill(int billId, Appointment appointment, LocalDateTime generatedAt) {
        Bill newBill = new Bill(billId, appointment, generatedAt);
        newBill.setAmount(getAmount(appointment));
        billsList.add(newBill);
    }

    public Bill getBill(int id) {
        for (Bill bill : billsList) {
            if (bill.getBillId() == id) {
                return bill;
            }
        }
        throw new IdNotFound("Bill with ID " + id + " not found");
    }

    public void payBill(Bill bill){
        bill.setStatus(true);
    }

}
