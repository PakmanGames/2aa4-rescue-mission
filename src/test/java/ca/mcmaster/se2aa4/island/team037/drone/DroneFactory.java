package ca.mcmaster.se2aa4.island.team037.drone;

import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;

public class DroneFactory {
    public Drone createDrone(Direction initialDirection, int batteryLevel, ActionManager actionManager) {
        return new BaseDrone(initialDirection, batteryLevel, actionManager);
    }

    public Drone getDrone() {
        return new BaseDrone(Direction.NORTH, 100, new ActionManager());
    }
}
