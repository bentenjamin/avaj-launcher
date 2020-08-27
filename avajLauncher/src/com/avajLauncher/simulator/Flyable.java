package avajLauncher.src.com.avajLauncher.simulator;

import avajLauncher.src.com.avajLauncher.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}