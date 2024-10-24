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