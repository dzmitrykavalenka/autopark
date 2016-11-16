package Autopark;

/**
 * Created by Dmitry on 16.11.2016.
 */
public abstract class Transport {
        private String model;
        private int year;

    public Transport(String model, int year) {
        this.model = model;
        this.year=year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

