# TrafficSimulation

## Overview

**TrafficSimulation** is a simulation model designed to simulate a network of roads in a town, including traffic-light controlled junctions and car parks. The simulation aims to analyze journey times to various destinations and visualize traffic flow in a simple, single-lane, one-way carriageway system. This project is part of an academic curriculum in Software Engineering, specifically for the Advanced Software Modeling module, to assess our concurrency knowledge.

## Features

- **Road Network**: Models one-way roads and two-directional traffic as separate road sections.
- **Traffic Light Control**: Simulates traffic lights at intersections that operate in a fixed cycle, managing the flow of cars.
- **Car Generation**: Cars are created at predetermined rates from various entry points with specified destinations.
- **Queue Management**: Cars will queue at intersections if there is no available space on the exit road.
- **Car Parks**: Models destinations where cars are consumed at the end of their journeys.
- **Journey Time Reporting**: Provides data on journey times to various destinations for performance comparison.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.x (for project management and dependencies)
- Any IDE or text editor (e.g., Visual Studio Code, IntelliJ IDEA)

--------------------------------------------------------------------------------------------

## JSON Structure Documentation
   Root Level
   - scenarios: Object containing all simulation scenarios.
   - carParks: Object detailing the available car parks and their capacities.
   - junctions: Object defining each junction, including its road links and configurations.
     
## 1. scenarios Object
  Contains multiple predefined scenarios for traffic simulation.
  
  - numOfScenarios: Integer representing the total number of scenarios available.
  - scenarioX: Each scenario (e.g., scenario1, scenario2, etc.) includes specific configuration settings:
  - junctions: Junction-specific configurations within each scenario.
  - junctionA, junctionB, junctionC, junctionD: Objects representing each junction with:
  - allowance: Integer value representing the allowed vehicle capacity at the junction.
  - entryPoints: Entry point settings specifying initial traffic flow values from the north, east, and south.
    
## 2. carParks Object
  Defines car parks in the simulation with their names and capacities.

  - numOfCarParks: Integer indicating the number of available car parks.
  - carParkX: Each car park (e.g., carPark1, carPark2, etc.) includes:
  - carParkName: String name of the car park (e.g., "IndustrialPark").
  - spaces: Integer representing the number of available parking spaces.
    
## 3. junctions Object
   Details the structure and roads associated with each junction.

   - numOfJunctions: Integer specifying the number of junctions in the system.
   - junctionX: Each junction (e.g., junctionA, junctionB, etc.) contains:
   - totalRoadLinked: Total number of roads connected to this junction.
   - numOfEntryRoads: Number of roads that allow entry to the junction.
   - numOfExitRoads: Number of roads that allow exit from the junction.
   - roadX: Each road (e.g., road1, road2, etc.) associated with the junction includes:
   - roadName: Name of the road connecting to this junction.
   - nextNode: Name of the next junction or destination (nullable).
   - roadCapacity: Maximum capacity for vehicles on this road.
   - entryAllowed: Boolean indicating if entry is permitted on this road.
   - destinations: Array of possible destinations accessible via this road (nullable).