package com.avajLauncher.simulator;

import com.avajLauncher.simulator.aircraft.AircraftFactory;

public class App {
    protected static int simulations; 
    public static void main(String[] args) {
        WeatherTower tower = new WeatherTower();
        simulations = 0;
        //input validation

        //create and register aircraft
        Flyable newAircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
        newAircraft.registerTower(tower);
        tower.register(newAircraft);

        //simulate
        for (int counter = 0 ; counter < simulations; counter++) {
            tower.changeWeather();
        }
    }
}
