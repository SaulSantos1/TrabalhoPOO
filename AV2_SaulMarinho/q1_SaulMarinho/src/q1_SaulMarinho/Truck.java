package q1_SaulMarinho;

public class Truck extends Vehicle {

    private int mass;

    public Truck(String registrationNumber, int mass) {
        super(registrationNumber);
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}