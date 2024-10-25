package models;

// This class was created to store Scenario details.
public class Scenario
{
    // Class Attributes
    public int[] junctionsAllowence;
    int entryPointNorth;
    int entryPointEast;
    int entryPointSouth;

    // This Function returns the class instance.
    // Create to get data from json.
    public static Scenario createInstance(int[] junctionsAllowence, int entryPointNorth,int entryPointEast, int entryPointSouth)
    {
        // New Instance to return
        Scenario instance = new Scenario();

        // Assigning data to instance.
        instance.setJunctionsAllowence(junctionsAllowence);;
        instance.setEntryPointEast(entryPointEast);;
        instance.setEntryPointNorth(entryPointNorth);
        instance.setEntryPointSouth(entryPointSouth);;

        // Returing Instance.
        return instance;
    };

    // Setters
    public void setEntryPointEast(int entryPointEast) {
        this.entryPointEast = entryPointEast;
    }
    public void setEntryPointNorth(int entryPointNorth) {
        this.entryPointNorth = entryPointNorth;
    }
    public void setEntryPointSouth(int entryPointSouth) {
        this.entryPointSouth = entryPointSouth;
    }
    public void setJunctionsAllowence(int[] junctionsAllowence) {
        this.junctionsAllowence = junctionsAllowence;
    }

    // Getters
    public int getEntryPointEast() {
        return entryPointEast;
    }
    public int getEntryPointNorth() {
        return entryPointNorth;
    }
    public int getEntryPointSouth() {
        return entryPointSouth;
    }
    public int[] getJunctionsAllowence() {
        return junctionsAllowence;
    }
    
}