package models;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    public void start(int scenario){
        validateScenarioInput(scenario);
        // Printing Heading on console
        System.out.println("\n  Simulation | Scanerio :"+  scenario+"\n");
        loadData(scenario);
    }

    // Function to clear Console
    void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Loads simulation data from a JSON file and initializes various components
     * such as scenarios, junctions, and car parks based on the specified scenario index.
     *
     * @param scenarioIndex The index of the scenario to load, which corresponds to
     *                      the scenario key in the JSON object (e.g., "scenario1").
     * 
     * This method performs the following actions:
     * <ul>
     *     <li>Parses the JSON file specified by the dataFilePath.</li>
     *     <li>Retrieves the number of junctions, scenarios, and car parks from the JSON object.</li>
     *     <li>Loads the specified scenario and initializes the corresponding junctions and car parks.</li>
     * </ul>
     *
     * @throws IOException If an I/O error occurs while reading the file.
     * @throws ParseException If the JSON content cannot be parsed.
     */
    void loadData(int scenarioIndex)
    {
        JSONParser parser = new JSONParser();

        try (FileReader fileReader = new FileReader(this.DATA_FILE_PATH))
        {
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            JSONObject allScenarios = (JSONObject) jsonObject.get("scenarios");
            JSONObject specificScenario = (JSONObject) allScenarios.get("scenario"+scenarioIndex);
            JSONObject allJunctions = (JSONObject) jsonObject.get("junctions");
            JSONObject allCarParkObject = (JSONObject) jsonObject.get("carParks");
            
            this.numOfJunctions = ((Long) allJunctions.get("numOfJunctions")).intValue();
            this.numOfScenarios = ((Long) allScenarios.get("numOfScenarios")).intValue();
            this.numOfCarParks = ((Long) allCarParkObject.get("numOfCarParks")).intValue();

            setRunningScenario(specificScenario);
            setJunctions(allJunctions);
            setCarParks(allCarParkObject);
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // To validate the scenario input
    void validateScenarioInput(int scenarioInput){
        if(scenarioInput<this.DEFAULT_SCENARIO || scenarioInput>this.numOfScenarios)
        {
            System.err.println("\nError: Invalid scenario input!");
            System.err.println("The entered scenario index '" + scenarioInput + "' is out of range.");
            System.err.println("Please provide a valid scenario index between 1 and 5.");
            final int EXIT_CODE = 1;
            System.exit(EXIT_CODE);
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

        this.carParks = new CarPark[this.numOfCarParks];

        for(int i=0; i<this.numOfCarParks; i++)
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
        this.junctions = new Junction[this.numOfJunctions];
        
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
        
        int[] junctionsAllowence = new int[this.numOfJunctions];

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

    // Getters 
    public CarPark[] getCarParks() {
        return carParks;
    }
    public Junction[] getJunctions() {
        return junctions;
    }
    public Scenario getRunningScenario() {
        return runningScenario;
    }

}
