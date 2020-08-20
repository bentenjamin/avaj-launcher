package com.avajLauncher.simulator.aircraft;

import java.util.HashMap;

import com.avajLauncher.simulator.Flyable;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected HashMap<String, Integer> latVals = new HashMap<>();
    protected HashMap<String, Integer> highVals = new HashMap<>();
    protected HashMap<String, Integer> longVals = new HashMap<>();
    protected HashMap<String, String> messages = new HashMap<>();

    protected Aircraft(String name, Coordinates coordinates) {
        id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static long nextId() {
        return (++idCounter);
    }

    protected void updateCraft(String weather, String craftType) {
        String finalMessage = craftType;

        this.coordinates = new Coordinates(
        this.coordinates.getLongitude() + longVals.get(weather),
        this.coordinates.getLatitude() + latVals.get(weather),
        this.calcHeight(highVals.get(weather)));
        
        finalMessage += "#";
        finalMessage += this.name;
        finalMessage += "(";
        finalMessage += Long.toString(this.id);
        finalMessage += ") : ";
        finalMessage += "#";

        if (this.coordinates.getHeight() == 0)
            finalMessage += this.highVals.get(weather);
        else
            finalMessage += ("LANDING LAT:" + this.coordinates.getLatitude() + " LONG:" + this.coordinates.getLongitude() + " HEIGHT:0");

        System.out.println(finalMessage);
    }

    protected int calcHeight(Integer newHeight) {
        newHeight += this.coordinates.getHeight();
        if (newHeight > 100)
            newHeight = 100;
        if (newHeight < 0)
            newHeight = 0;
        return newHeight;
    }
}