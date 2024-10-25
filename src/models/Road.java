package models;

import rough.Vehicle;

// This file contains Road Class that represents blueprint for roads used in
// in the traffic Simulation.

public class Road {

    // Class Attributes
    private String roadName;
    private int roadCapacity;
    private int onRoadVehicles = 0;
    private boolean isEntryAllowed;
    private Vehicle[] roadBuffer;
    private String[] destinations;

    // Static class Constructor to read data from Json
    public Road createInstance(String roadName,int roadCapacity,boolean isEntryAllowed, String[] destinations){
        // Instance to return
        Road instance = new Road();

        // Assigning data to the instance
        instance.setRoadName(roadName);
        instance.setRoadCapacity(roadCapacity);
        instance.setIsEntryAllowed(isEntryAllowed);
        instance.setDestinations(destinations);

        // Returning Instance
        return instance;
    }

    // Methods
    public void addVehicleIntoRoad(){}
    public Vehicle getVehicleFromRoad(){}
    public boolean isSpaceAvailable(){}
    public boolean isEntryAllowed(){}

    // Setters
    public void setIsEntryAllowed(boolean isEntryAllowed) {
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

    public boolean getIsEntryAllowed(){
        return this.isEntryAllowed;
    }

}
