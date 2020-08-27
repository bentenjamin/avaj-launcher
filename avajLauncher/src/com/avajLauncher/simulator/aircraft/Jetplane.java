package avajLauncher.src.com.avajLauncher.simulator.aircraft;

import avajLauncher.src.com.avajLauncher.simulator.Flyable;
import avajLauncher.src.com.avajLauncher.simulator.Simulator;
import avajLauncher.src.com.avajLauncher.weather.WeatherTower;

public class Jetplane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Jetplane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.craftType = "JetPlane";
        setCallSign();

        this.latVals.put("SUN", 10);
        this.latVals.put("RAIN", 5);
        this.latVals.put("FOG", 1);
        this.latVals.put("SNOW", 0);

        this.longVals.put("SUN", 0);
        this.longVals.put("RAIN", 0);
        this.longVals.put("FOG", 0);
        this.longVals.put("SNOW", 0);

        this.messages.put("SUN", "OH, OH YEAH, THATS HOT");
        this.messages.put("RAIN", "wishy washys go brr");
        this.messages.put("FOG", "cant see shit");
        this.messages.put("SNOW", "snowball dogfight or gay");
        this.messages.put("LAND", "MAYDAY MDAY DAY WE GOIN DOWN. now landing");
        
        this.highVals.put("SUN", 2);
        this.highVals.put("RAIN", 0);
        this.highVals.put("FOG", 0);
        this.highVals.put("SNOW", -7);
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