package com.avajLauncher.simulator.aircraft;

import com.avajLauncher.simulator.Flyable;
import com.avajLauncher.simulator.Simulator;
import com.avajLauncher.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.craftType = "Baloon";
        setCallSign();

        this.longVals.put("SUN", 2);
        this.longVals.put("RAIN", 0);
        this.longVals.put("FOG", 0);
        this.longVals.put("SNOW", 0);

        this.latVals.put("SUN", 0);
        this.latVals.put("RAIN", 0);
        this.latVals.put("FOG", 0);
        this.latVals.put("SNOW", 0);
        
        this.highVals.put("SUN", 4);
        this.highVals.put("RAIN", -5);
        this.highVals.put("FOG", -3);
        this.highVals.put("SNOW", -15);

        this.messages.put("SUN", "LETS GOOOOO");
        this.messages.put("RAIN", "FORGOT ME RAIN SCREEN");
        this.messages.put("FOG", "AT THIS POINT ITS BUMBER CARS IN THE AIR");
        this.messages.put("SNOW", "IS COLD");
        this.messages.put("LAND", "COME GET US");
    }

    public void updateConditions() {
        updateCraft(this.weatherTower.getWeather(coordinates));

        if (this.coordinates.getHeight() == 0) {
            Simulator.craftLog += (this.callSign + " signing out." + System.lineSeparator());
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        Simulator.craftLog += (this.callSign + " registering" + System.lineSeparator());
        this.weatherTower = weatherTower;
    }
}