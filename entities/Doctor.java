package entities;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    ArrayList<Appointment> appList = new ArrayList<>();

    int exp;
    String spec;
    double consultationFee, ratePerMinute;

    public Doctor(int exp, int id, String name, String spec, double consultationFee, double ratePerMinute){
        super(id, name);
        this.exp = exp;
        this.id = id;
        this.spec = spec;
        this.consultationFee  = consultationFee;
        this.ratePerMinute = ratePerMinute;
    }

    public int getExp(){
        return exp;
    }

    public String getSpec(){
        return spec;
    }

    public void addApp(Appointment appointment){
        appList.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appList);
    }

    public double getConsultationFee(){
        return  consultationFee;
    }

    public double getRatePerMinute(){
        return ratePerMinute;
    }
}
