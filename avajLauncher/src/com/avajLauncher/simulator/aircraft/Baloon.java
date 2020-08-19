package com.avajLauncher.simulator.aircraft;

import com.avajLauncher.simulator.Flyable;
import com.avajLauncher.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        
    }
    
}