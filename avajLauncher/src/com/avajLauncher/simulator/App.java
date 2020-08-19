package com.avajLauncher.simulator;

import com.avajLauncher.simulator.aircraft.AircraftFactory;

public class App {
    protected static int simulations; 
    public static void main(String[] args) {
        simulations = 0;
        Tower tower = new WeatherTower();
        tower.register(AircraftFactory.newAircraft(type, name, longitude, latitude, height));






        System.out.println("Hello, World!");

    }
}
