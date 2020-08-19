package com.avajLauncher.simulator;

import java.util.List;

public abstract class Tower {
    private List<Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        
    }
}