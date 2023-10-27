package q1_SaulMarinho;

public class Car extends Vehicle {

    private String transmission;

    public Car(String registrationNumber, String transmission) {
        super(registrationNumber);
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}