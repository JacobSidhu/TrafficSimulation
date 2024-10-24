package models;

// This file contains Road Class that represents blueprint for roads used in
// in the traffic Simulation.

public class Road {

    // Class Attributes
    private String roadName = null;
    private int roadCapacity;
    private int onRoadVehicles;
    private boolean isEntryAllowed;
    private Vehicle[] roadBuffer;
    private String[] destinations;

    // Class Constructor
    Road(){}

    // Methods
    void addVehicleIntoRoad(){}
    Vehicle getVehicleFromRoad(){}
    boolean isSpaceAvailable(){}
    

    // Setters
    public void setEntryAllowed(boolean isEntryAllowed) {
        this.isEntryAllowed = isEntryAllowed;
    }

    public void setDestinations(String[] destinations) {
        this.destinations = destinations;
    }

    public void setOnRoadVehicles(int onRoadVehicles) {
        this.onRoadVehicles = onRoadVehicles;
    }

    public void setRoadBuffer(Vehicle[] roadBuffer) {
        this.roadBuffer = roadBuffer;
    }

    public void setRoadCapacity(int roadCapacity) {
        this.roadCapacity = roadCapacity;
    }
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    //Getters
    public String[] getDestinations() {
        return destinations;
    }

    public int getOnRoadVehicles() {
        return onRoadVehicles;
    }

    public Vehicle[] getRoadBuffer() {
        return roadBuffer;
    }

    public int getRoadCapacity() {
        return roadCapacity;
    }

    public String getRoadName() {
        return roadName;
    }


}
