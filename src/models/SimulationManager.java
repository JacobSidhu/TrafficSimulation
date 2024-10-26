package models;

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
    void setCarParks(CarPark[] carParks) {
        this.carParks = carParks;
    }
    
    void setJunctions(Junction[] junctions) {
        this.junctions = junctions;
    }

    void setRunningScenario(Scenario runningScenario) {
        this.runningScenario = runningScenario;
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
