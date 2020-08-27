package avajLauncher.src.com.avajLauncher.weather;

import avajLauncher.src.com.avajLauncher.simulator.aircraft.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}