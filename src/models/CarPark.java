package models;

public class CarPark {

    // Class Attributes
    private String carParkName;
    private int spaces;

    public CarPark createInstance(String carParkName,int spaces){
        // CarPark Instance to Return
        CarPark instance = new CarPark();
        // Assigning Values.
        instance.setCarParkName(carParkName);
        instance.setSpaces(spaces);
        // Returning Instance.
        return instance;
    }

    // Setters
    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }
    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    // Getters
    public String getCarParkName() {
        return carParkName;
    }
    public int getSpaces() {
        return spaces;
    }
}
