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
        instance.junctionsAllowence = junctionsAllowence;
        instance.entryPointEast = entryPointEast;
        instance.entryPointNorth = entryPointNorth;
        instance.entryPointSouth = entryPointSouth;

        // Returing Instance.
        return instance;
    };
    
}