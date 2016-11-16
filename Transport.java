package Model;

/**
 * Created by Dmitry on 09.11.2016.
 */
public abstract class Transport {
    private String name;
    private int fuelTank;
    private String typeOfFuel;
    private double price;
    private String coulour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getfuelTank() {
        return fuelTank;
    }

    public void setfuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCoulour() {
        return coulour;
    }

    public void setCoulour(String coulour) {
        this.coulour = coulour;
    }


}
