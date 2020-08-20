package com.avajLauncher.simulator.aircraft;

import com.avajLauncher.simulator.Flyable;
import com.avajLauncher.simulator.WeatherTower;
import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);

        this.longVals.put("SUN", 10);
        this.longVals.put("RAIN", 5);
        this.longVals.put("FOG", 1);
        this.longVals.put("SNOW", 0);

        this.latVals.put("SUN", 0);
        this.latVals.put("RAIN", 0);
        this.latVals.put("FOG", 0);
        this.latVals.put("SNOW", 0);
        
        this.highVals.put("SUN", 2);
        this.highVals.put("RAIN", 0);
        this.highVals.put("FOG", 0);
        this.highVals.put("SNOW", -12);

        this.messages.put("SUN", "SUNS OUT GUNS OUT");
        this.messages.put("RAIN", "PITTER PATTER");
        this.messages.put("FOG", "10 POINTS IF I HIT A TREE");
        this.messages.put("SNOW", "SLEDING TIME BOIS");
        this.messages.put("LAND", "LAAAAAAAAAAAAAAAAAAANNNNNNNNNNDDDDDDDDDDDDDDDDDDD HHHHHHHHHHHHHHHOOOOOOOOOOOOOOOOOOOOOOOO");
        
    }

    public void updateConditions() {
        updateCraft(this.weatherTower.getWeather(coordinates), "HELICOPTER");

        if (this.coordinates.getHeight() == 0)
            this.weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}