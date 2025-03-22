package ca.mcmaster.se2aa4.island.team037.drone;

import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;

public class DroneFactory {
    public Drone createDrone(Direction initialDirection, int batteryLevel, ActionManager actionManager) {
        return new Drone(initialDirection, batteryLevel, actionManager);
    }

    public Drone getDrone() {
        return new Drone(Direction.NORTH, 100, new ActionManager());
    }
}
