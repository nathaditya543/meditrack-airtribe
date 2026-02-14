package entities;

public class Patient extends Person{
    int age;
    BloodType bloodType;
    String gender;
    double heightcm, weightkg;


    Patient(int id, String name, int age, BloodType bloodType) {
        super(id, name);
        this.age = age;
        this.bloodType = bloodType;
    }


    int getAge() {
        return age;
    }

    BloodType getBloodType() {
        return bloodType;
    }

    String getGender() {
        return gender;
    }

    double getHeightCm() {
        return heightcm;
    }

    double getWeightKg() {
        return weightkg;
    }
}
