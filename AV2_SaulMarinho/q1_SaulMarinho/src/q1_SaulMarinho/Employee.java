package q1_SaulMarinho;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private Company company;
    private List<Vehicle> vehicles;

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

}