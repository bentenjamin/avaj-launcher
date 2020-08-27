package avajLauncher.src.com.avajLauncher.weather;

import java.util.ArrayList;

import avajLauncher.src.com.avajLauncher.simulator.Flyable;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    private ArrayList<Flyable> incinerator = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        incinerator.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable craft : observers)
            craft.updateConditions();

        for (Flyable craft : incinerator)
            observers.remove(craft);
            
        incinerator.clear();
    }
}