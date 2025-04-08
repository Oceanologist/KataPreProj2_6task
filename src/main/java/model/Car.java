package model;

public class Car {
    private String carBrand;
    private String carModel;
    private int horsePower;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Car() {
    }

    public Car(String carBrand, String carModel, int horsePower) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsePower = horsePower;
    }
}
