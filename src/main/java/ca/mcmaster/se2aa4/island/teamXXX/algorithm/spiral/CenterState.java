package ca.mcmaster.se2aa4.island.teamXXX.algorithm.spiral;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class CenterState extends State {
    private final int centerX;
    private final int centerY;
    private Action action;

    public CenterState(Drone drone, int mapHeight, int mapWidth) {
        super(drone);
        this.centerX = (int) Math.ceil(mapWidth / 2.0);
        this.centerY = (int) Math.ceil(mapHeight / 2.0);
    }

    public boolean isCenter() {
        int currentX = getDrone().getPosition().getX();
        int currentY = getDrone().getPosition().getY();
        int deltaX = centerX - currentX;
        int deltaY = centerY - currentY;

        return Math.abs(deltaX) <= 1 && Math.abs(deltaY) <= 1;
    }

    @Override
    public State nextState(ActionResult result) {
        Drone drone = getDrone();
        drone.expend(result.getCost());
        action.consume(drone, result);
        return isCenter() ? new SpiralState(getDrone()) : this;
    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        int currentX = drone.getPosition().getX();
        int currentY = drone.getPosition().getY();

        int deltaX = centerX - currentX;
        int deltaY = centerY - currentY;
        
        Direction currentDirection = drone.getDirection();

        if (isCenter()) {
            return null; 
        }





   
       action = drone.fly();

       return action;
    }
}
