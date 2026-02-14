package entities;

public class Doctor extends Person {
    int exp;
    String spec;
    double consultationFee, ratePerMinute;

    Doctor(int exp, int id, String name, String spec){
        super(id, name);
        this.exp = exp;
        this.id = id;
        this.consultationFee  = consultationFee;
        this.ratePerMinute = ratePerMinute;
    }

    int getExp(){
        return exp;
    }

    String getSpec(){
        return spec;
    }
}
