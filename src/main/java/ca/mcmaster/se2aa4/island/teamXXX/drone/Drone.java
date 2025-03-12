package ca.mcmaster.se2aa4.island.teamXXX.drone;

import java.util.HashMap;
import java.util.Map;

import ca.mcmaster.se2aa4.island.teamXXX.actions.DroneAction;

public class Drone {
    private Map<String, DroneAction> actions = new HashMap<>();
    private Direction direction;
    private Position position;
    private int batteryLevel;

    public Drone(Direction initialDirection, Position initialPosition,int batteryLevel) {
        this.direction = initialDirection;
        this.position = initialPosition;
        this.batteryLevel = batteryLevel;

    }

    public String fly() {
        return actions.get("fly").execute();
    }

    public String scan() {
        return actions.get("scan").execute();
    }

    public String echo(Direction direction) {
        return actions.get("echo").execute();
    }

    public String turn(Direction targetDirection){
        return actions.get("head").execute(); 
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
