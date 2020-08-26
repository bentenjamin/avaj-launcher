package com.avajLauncher.simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.avajLauncher.simulator.aircraft.AircraftFactory;

public class App {
    protected static int simulations; 
    public static void main(String[] args) {
            WeatherTower tower = new WeatherTower();
            int simulations = 0;
            Scanner scanner = null;
            // File inputFile = null;
            try {
                scanner = new Scanner(new File("scenario.txt"));
            } catch(FileNotFoundException e) {
                System.out.println("File not found!");
                System.exit(1);
            }
            //input validation

            try {
                simulations = Integer.parseInt(scanner.nextLine());
                if (simulations < 1)
                    throw new Exception("Invalid number of simulations");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
    
            //create and register aircraft
            while (scanner.hasNextLine()) {
                Flyable newAircraft = null;
                try {
                    String line[] = scanner.nextLine().split(" ");
                    if (line.length != 5)
                        throw new Exception("Invalid Input");
                    try {
                        newAircraft = AircraftFactory.newAircraft(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    } catch (Exception e) {
                        throw new Exception("Invalid Input");
                    }
                    if (newAircraft == null)
                        throw new Exception("Invalid aircraft type");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
                newAircraft.registerTower(tower);
                tower.register(newAircraft);
            }
            scanner.close();
    
            //simulate
            for (int counter = 0 ; counter < simulations; counter++)
                tower.changeWeather();
    }
}
