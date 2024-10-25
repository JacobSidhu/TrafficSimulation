package models;

public class Junction {

    // Class Attributes
    private int totalRoadLinked;
    private int numOfEntryRoads;
    private int numOfExitRoads;
    private String junctionName;
    private Road[] linkedRoads;

    public Junction createInstance(String junctionName, int totalRoadLinked, int numOfEntryRoads, int numOfExitRoads, Road[] roads){
        // Creating New Junction Instance
        Junction instance = new Junction();
        //Assigning values to the junction
        instance.setJunctionName(junctionName);
        instance.setTotalRoadLinked(totalRoadLinked);
        instance.setNumOfEntryRoads(numOfEntryRoads);
        instance.setNumOfExitRoads(numOfExitRoads);
        instance.setLinkedRoads(roads);
        // Returning Class Instance.
        return instance; 
    }

    // Methods or Functions
    public void routeVehicle(Vehicle car){}
    static String getVehicleDestination(Vehicle car){}
    static Road findDestinyRoad(String destination){}
    static void addVehicleIntoRoad(Road road){}
    static void log(){}

    // Setters
    public void setJunctionName(String junctionName) {
        this.junctionName = junctionName;
    }
    public void setLinkedRoads(Road[] linkedRoads) {
        this.linkedRoads = linkedRoads;
    }
    public void setNumOfEntryRoads(int numOfEntryRoads) {
        this.numOfEntryRoads = numOfEntryRoads;
    }
    public void setNumOfExitRoads(int numOfExitRoads) {
        this.numOfExitRoads = numOfExitRoads;
    }
    public void setTotalRoadLinked(int totalRoadLinked) {
        this.totalRoadLinked = totalRoadLinked;
    }

    // Getters
    public String getJunctionName() {
        return junctionName;
    }
    public Road[] getLinkedRoads() {
        return linkedRoads;
    }
    public int getNumOfEntryRoads() {
        return numOfEntryRoads;
    }
    public int getNumOfExitRoads() {
        return numOfExitRoads;
    }
    public int getTotalRoadLinked() {
        return totalRoadLinked;
    }

}
