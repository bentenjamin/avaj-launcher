package avajLauncher.src.com.avajLauncher.simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import avajLauncher.src.com.avajLauncher.simulator.aircraft.AircraftFactory;
import avajLauncher.src.com.avajLauncher.weather.WeatherTower;

public class Simulator {
    protected static int simulations;
    public static String craftLog = "";
    public static void main(String[] args) {
            WeatherTower tower = new WeatherTower();
            int simulations = 0;
            Scanner scanner = null;
            String fileName = null;

            try {
                fileName = args[0];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No File Name!");
                System.exit(1);
            }

            try {
                scanner = new Scanner(new File(fileName));
            } catch(FileNotFoundException e) {
                System.out.println("File not found!");
                System.exit(1);
            }
            //input validation
            if (scanner.hasNext() == false) {
                System.out.println("empty file!");
                System.exit(1);
            }

            try {
                simulations = Integer.parseInt(scanner.nextLine());
            } catch (final NumberFormatException e) {
                System.out.println("Simulations is not an int");
                System.exit(1);
            }
            
            if (simulations < 1) {
                System.out.println("Invalid number of simulations");
                System.exit(1);
            }
    
            //create and register aircraft
            while (scanner.hasNextLine()) {
                Flyable newAircraft = null;
                int lat = 0, lng = 0, height = 0;
                String line[] = null;

                try {
                    line = scanner.nextLine().split(" ");
                } catch(Exception e) {
                    System.out.println("Invalid Input!");
                    System.exit(1);
                }

                try {
                    if (line.length != 5)
                        throw new Exception("");
                } catch (Exception e) {
                    System.out.println("badly formatted aircraft!");
                    System.exit(1);
                }

                try {
                    lat = Integer.parseInt(line[2]);
                    lng = Integer.parseInt(line[3]);
                    height = Integer.parseInt(line[4]);
                    if ((lat < 0) || (lng < 0) || (height < 0) || (height > 100))
                        throw new Exception("Invalid Coordinates");
                } catch (NumberFormatException e) {
                    System.out.println("Coordinates are not positive integers!");
                    System.exit(1);
                } catch (Exception e) {
                    System.out.println("Invalid Coordinates");
                    System.exit(1);
                }

                try {
                    newAircraft = AircraftFactory.newAircraft(line[0], line[1], lat, lng, height);
                } catch (Exception e) {
                    System.out.println("Failed to create aircraft!");
                    System.exit(1);
                }

                if (newAircraft == null) {
                    System.out.println("badly formatted aircraft!");
                    System.exit(1);
                }
                newAircraft.registerTower(tower);
                tower.register(newAircraft);
            }
            scanner.close();
    
            //simulate
            for (int counter = 0 ; counter < simulations; counter++)
                tower.changeWeather();

            //output
            try {
                File newFile = new File("simulation.txt");
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the output file.");
                e.printStackTrace();
            }
            
            try {
                FileWriter myWriter = new FileWriter("simulation.txt");
                myWriter.write(craftLog);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
    }
}
