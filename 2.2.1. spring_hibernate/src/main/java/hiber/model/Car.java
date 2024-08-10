package hiber.model;

import javax.persistence.*;

@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String model;
    @Column
    private int series;

    public Car() {
    }


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }


    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        if (model == null) {
            return "User dont have a car";
        }
        return "model:  " + model + "  series:  " + series;

    }
}
