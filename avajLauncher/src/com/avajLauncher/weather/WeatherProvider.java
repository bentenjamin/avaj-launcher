package avajLauncher.src.com.avajLauncher.weather;

import java.util.Random;

import avajLauncher.src.com.avajLauncher.simulator.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static Random rando = new Random();

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(rando.nextInt(100) + coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4];
    }
    
}