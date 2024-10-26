package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//The TrafficManager class is responsible for managing the loading of data into
//simulation objects and handling the console output for data presentation.

public class SimulationManager {
    
    // Class attributes
    private CarPark[] carParks;
    private Junction[] junctions;
    private int numOfScenarios;
    private int numOfCarParks;
    private int numOfJunctions;
    private final int DEFAULT_SCENARIO = 1;
    private Scenario runningScenario;
    private final String DATA_FILE_PATH = "src/data/data.json";

    // Function to start Simulation
    public static void start(int scenario){}

    // Function to clear Console
    void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // This loadData method fetch data from data.json file
    void loadData(){}

    // To validate the scenario input
    static void validateScenarioInput(int scenarioInput){
        if(scenarioInput<1 || scenarioInput>5)
        {
            System.err.println("\nError: Invalid scenario input!");
            System.err.println("The entered scenario index '" + scenarioInput + "' is out of range.");
            System.err.println("Please provide a valid scenario index between 1 and 5.");
            System.exit(1);
        }
        return;
    }

    // Setters

    /**
     * Initializes car parks in the simulation using data from a JSON object.
     *
     * @param allCarParkObject A JSONObject containing data for each car park.
     *                         
     * This method sets up each car park instance with its name and available spaces, 
     * storing them in the carParks array.
     */
    public void setCarParks(JSONObject allCarParkObject) {

        this.carParks = new CarPark[this.getNumOfCarParks()];

        for(int i=0; i<getNumOfCarParks(); i++)
        {
            CarPark tempInstance = new CarPark();
            JSONObject eachCarParkObject = (JSONObject) allCarParkObject.get("carPark"+(i+1));
            String carParkName = (String) eachCarParkObject.get("carParkName");
            int spaces = ((Long) eachCarParkObject.get("spaces")).intValue();
            this.carParks[i] = tempInstance.createInstance(carParkName, spaces);
        }
    }

    /**
     * Initializes the junctions in the simulation using data from a JSON object.
     *
     * @param allJunctionObjects A JSONObject containing data for each junction. 
     
    * Sets up each junction with its linked roads, capacity, entry permissions, and destinations.
    */
    void setJunctions(JSONObject allJunctionObjects) {
        this.junctions = new Junction[getNumOfJunctions()];
        
        // Fetching each junction from all Junctions object
        for(int i=0; i<numOfJunctions; i++)
        {
            char junctionLetter = (char) ('A' + i);
            String junctionName = "junction"+junctionLetter;
            JSONObject eachJunctionObject = (JSONObject) allJunctionObjects.get(junctionName);
            Junction tempJunction = new Junction();
            int totalRoadLinked = ((Long) eachJunctionObject.get("totalRoadLinked")).intValue();
            int numOfEntryRoads = ((Long) eachJunctionObject.get("numOfEntryRoads")).intValue();
            int numOfExitRoads = ((Long) eachJunctionObject.get("numOfExitRoads")).intValue();
            Road[] roadInstances = new Road[totalRoadLinked];

            // Fetching Road data from each junction.
            for(int x=0; x<totalRoadLinked; x++)
            {
                Road tempInstance = new Road();
                String roadObjectKey = "road"+(x+1);
                System.err.println("Here");
                JSONObject roadObject = (JSONObject) eachJunctionObject.get(roadObjectKey);

                String roadName = (String) roadObject.get("roadName");

                int roadCapacity = ((Long) roadObject.get("roadCapacity")).intValue();
                boolean isEntryAllowed = (boolean) roadObject.get("entryAllowed");
                JSONArray destinationsArray = (JSONArray) roadObject.get("destinations");
                String[] destinations = null;
                if(destinationsArray!=null)
                {
                    destinations = new String[destinationsArray.size()];
                    for (int j = 0; j < destinationsArray.size(); j++) {
                        destinations[j] = (String) destinationsArray.get(j);
                    }
                }                
                roadInstances[x] = tempInstance.createInstance(roadName,roadCapacity,isEntryAllowed,destinations);
            }
            this.junctions[i] = tempJunction.createInstance(junctionName,totalRoadLinked,numOfEntryRoads,numOfExitRoads,roadInstances);
        }
    }

    /**
     * Configures the current simulation scenario using data from a JSON object.
     *
     * @param scenarioObject A JSONObject containing scenario data with junction allowances
     *                       and vehicle entry points.
     *       
     * Sets up junction allowances and entry point capacities, creating a new 
     * `runningScenario` instance based on these values.
     */
    void setRunningScenario(JSONObject scenarioObject) {
        
        int[] junctionsAllowence = new int[this.getNumOfJunctions()];

            for(int x=0; x<numOfJunctions; x++){
                char junctionLetter = (char) ('A'+ x);
                JSONObject junctions = (JSONObject) scenarioObject.get("junctions");
                JSONObject eachJunction = (JSONObject) junctions.get("junction"+junctionLetter);
                junctionsAllowence[x] = ((Long) eachJunction.get("allowence")).intValue();
            }
            JSONObject entryPoints = (JSONObject) scenarioObject.get("entryPoints");
            int north = ((Long) entryPoints.get("north")).intValue();
            int east = ((Long) entryPoints.get("east")).intValue();
            int south =  ((Long) entryPoints.get("south")).intValue();
            this.runningScenario = Scenario.createInstance(junctionsAllowence, north, east, south);
    }

    void setNumOfCarParks(int numOfCarParks) {
        this.numOfCarParks = numOfCarParks;
    }
    void setNumOfJunctions(int numOfJunctions) {
        this.numOfJunctions = numOfJunctions;
    }
    void setNumOfScenarios(int numOfScenarios) {
        this.numOfScenarios = numOfScenarios;
    }

    // Getters 
    public CarPark[] getCarParks() {
        return carParks;
    }
    public String getDATA_FILE_PATH() {
        return DATA_FILE_PATH;
    }
    public int getDEFAULT_SCENARIO() {
        return DEFAULT_SCENARIO;
    }
    public Junction[] getJunctions() {
        return junctions;
    }
    public int getNumOfCarParks() {
        return numOfCarParks;
    }
    public int getNumOfJunctions() {
        return numOfJunctions;
    }
    public int getNumOfScenarios() {
        return numOfScenarios;
    }
    public Scenario getRunningScenario() {
        return runningScenario;
    }

}
