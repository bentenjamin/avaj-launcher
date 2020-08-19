package com.avajLauncher.simulator.aircraft;

import com.avajLauncher.simulator.Flyable;
import com.avajLauncher.simulator.WeatherTower;

public abstract class Aircraft implements Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private WeatherTower weatherTower;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return (++idCounter);
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    public void updateConditions() {

    }
}