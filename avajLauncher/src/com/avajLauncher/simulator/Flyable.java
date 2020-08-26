package com.avajLauncher.simulator;

import com.avajLauncher.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}