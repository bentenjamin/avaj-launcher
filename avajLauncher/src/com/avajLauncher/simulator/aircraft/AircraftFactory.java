package com.avajLauncher.simulator.aircraft;

import com.avajLauncher.simulator.Flyable;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Aircraft aircraft;
        Coordinates coords = new Coordinates(longitude, latitude, height);
        
        type = type.toLowerCase();
        switch (type) {
            case "helicopter":
                aircraft = new Helicopter(name, coords);
                break;
        
            case "jetplane":
                aircraft = new Jetplane(name, coords);
                break;

            default:
                aircraft = new Baloon(name, coords);
                break;
        }
        
        return aircraft;
    }
}