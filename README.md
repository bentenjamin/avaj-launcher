# avaj-launcher
java project for beginners to learn OOP

A basic simulation program that reads input and creates aircraft that talk to a weather tower. The weather changes and the aircraft react accordinly when told to by the tower.

# Input
No of simulations to be run
AircraftType AircraftName Longitude Latitude Height

the aircraft can be Baloon, JetPlane or Helicopter.
coordinates are positive
height is between 1-100

# usage
navigate into avaj-launcher

$find -name "*.java" > sources.txt

$javac @sources.txt

$java avajLauncher.src.com.avajLauncher.simulator.Simulator scenario.txt
