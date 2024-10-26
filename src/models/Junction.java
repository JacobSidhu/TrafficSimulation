package models;

public class Junction {

    // Class Attributes
    public int totalRoadLinked;
    public int numOfEntryRoads;
    public int numOfExitRoads;
    public String junctionName;
    public Road[] linkedRoads;

    public Junction createInstance(String junctionName, int totalRoadLinked, int numOfEntryRoads, int numOfExitRoads, Road[] roads){
        // Creating New Junction Instance
        Junction instance = new Junction();
        //Assigning values to the junction
        instance.junctionName = junctionName;
        instance.totalRoadLinked = totalRoadLinked;
        instance.numOfEntryRoads = numOfEntryRoads;
        instance.numOfExitRoads = numOfExitRoads;
        instance.linkedRoads = roads;
        // Returning Class Instance.
        return instance; 
    }

    // Methods or Functions
    public void routeVehicle(Vehicle car){}
    static String getVehicleDestination(Vehicle car){}
    static Road findDestinyRoad(String destination){}
    static void addVehicleIntoRoad(Road road){}
    static void log(){}

}
