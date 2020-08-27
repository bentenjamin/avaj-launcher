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
navigate into src

$find -name "*.java" > sources.txt

$javac -sourcepath @sources.txt

$java com.avajLauncher.simulator.Simulator nameOfInputFile.txt
