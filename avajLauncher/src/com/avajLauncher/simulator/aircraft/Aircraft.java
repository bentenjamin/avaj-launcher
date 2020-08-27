package com.avajLauncher.simulator.aircraft;

import java.util.HashMap;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String craftType;
    protected String callSign;
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

    protected void updateCraft(String weather) {
        String finalMessage = callSign;

        this.coordinates = new Coordinates(
        this.coordinates.getLongitude() + longVals.get(weather),
        this.coordinates.getLatitude() + latVals.get(weather),
        this.calcHeight(highVals.get(weather)));

        if (this.coordinates.getHeight() != 0)
            finalMessage += this.messages.get(weather);
        else
            finalMessage += ("LANDING AT " + this.coordinates.toString());

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

    protected void setCallSign() {
        this.callSign = this.craftType;
        this.callSign += "#";
        this.callSign += this.name;
        this.callSign += "(";
        this.callSign += Long.toString(this.id);
        this.callSign += ") : ";
    }
}