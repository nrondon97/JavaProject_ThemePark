# Theme Park Simulator

## Overview

This Java program, developed by Naylene Rondon for the Florida Tech CIS 2503 course (7.5 Programming Assignment), simulates a theme park environment where multiple amusement rides are managed dynamically. The program regularly updates and displays the number of people waiting in line for each ride.

## Features

- Simulates multiple amusement rides with varying capacities and durations.
- Updates and displays the number of people waiting in line for each ride.
- Allows user interaction to control the simulation, including ending it.
- Uses multithreading for concurrent operations on each ride.

## How It Works

1. **Initialization**:
   - Initializes several amusement rides (`Amusement` objects) with specific attributes such as type, capacity, and duration.
   - Uses a queue (`attendees`) to manage the number of people waiting in line for each ride.

2. **Starting the Simulation**:
   - Begins with a morning setup where initial wait times for each ride are set and displayed.

3. **Simulation Loop**:
   - Continuously checks the status of each ride and updates the number of people waiting based on the ride's capacity and duration.
   - Allows the user to input commands (`END` to stop the simulation) to control the flow of the simulation.

4. **Amusement Class**:
   - Defines the `Amusement` class to encapsulate ride properties (`rideType`, `waiting`, `riding`, `capacity`, `duration`, `running`) and operations (`run` method for simulating ride duration).
