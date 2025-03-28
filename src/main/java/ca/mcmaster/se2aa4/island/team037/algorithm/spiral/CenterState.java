package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class CenterState extends State {
    private int centerX;
    private int centerY;
    private Action action;

    public CenterState(Drone drone) {
        super(drone);
        int mapWidth = drone.getMapInfo().getWidth();
        int mapHeight = drone.getMapInfo().getHeight();
        this.centerX = (int) Math.ceil(mapWidth / 2.0);
        this.centerY = (int) Math.ceil(mapHeight / 2.0);
        this.action = drone.head(Direction.NORTH);
    }

    public boolean isCenter() {
        int currentX = getDrone().getPosition().getX();
        int currentY = getDrone().getPosition().getY();
        int deltaX = centerX - currentX;
        int deltaY = centerY - currentY;

        return Math.abs(deltaX) <= 2 && Math.abs(deltaY) <= 2;
    }

    @Override
    public State nextState(ActionResult result) {
        Drone drone = getDrone();
        drone.consume(action, result);
        return isCenter() ? new SpiralState(getDrone()) : this;
    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        int currentX = drone.getPosition().getX();
        int currentY = drone.getPosition().getY();

        int deltaX = centerX - currentX;
        int deltaY = -(centerY - currentY);

        Direction currentDirection = drone.getDirection();

        if (Math.abs(deltaX) > 2 && Math.abs(deltaY) > 2) {
            if (deltaX > 0 && deltaY > 0) { // drone is at the lower left corner
                if (currentDirection == Direction.NORTH || currentDirection == Direction.WEST) {
                    action = drone.head(currentDirection.right());
                } else if (currentDirection == Direction.SOUTH || currentDirection == Direction.EAST) {
                    action = drone.head(currentDirection.left());
                }
            } else if (deltaX < 0 && deltaY > 0) { // drone is at the lower right corner
                if (currentDirection == Direction.SOUTH || currentDirection == Direction.WEST) {
                    action = drone.head(currentDirection.right());
                } else if (currentDirection == Direction.NORTH || currentDirection == Direction.EAST) {
                    action = drone.head(currentDirection.left());
                }
            } else if (deltaX > 0 && deltaY < 0) { // drone is at the lower right corner
                if (currentDirection == Direction.EAST || currentDirection == Direction.NORTH) {
                    action = drone.head(currentDirection.right());
                } else if (currentDirection == Direction.SOUTH || currentDirection == Direction.WEST) {
                    action = drone.head(currentDirection.left());
                }
            } else { // drone is at the upper right corner
                if (currentDirection == Direction.SOUTH || currentDirection == Direction.EAST) {
                    action = drone.head(currentDirection.right());
                } else if (currentDirection == Direction.NORTH || currentDirection == Direction.WEST) {
                    action = drone.head(currentDirection.left());
                }
            }
        }

        if (deltaX <= 2) {
            if (deltaY > 0) { // drone is south to center
                if (currentDirection == Direction.NORTH) {
                    action = drone.fly();
                } else { // The direction must be WEST or EAST
                    if (currentDirection == Direction.EAST) {
                        action = drone.head(currentDirection.left());
                    } else {
                        action = drone.head(currentDirection.right());
                    }
                }
            } else { // drone is NORTH to the center
                if (currentDirection == Direction.SOUTH) {
                    action = drone.fly();
                } else { // The direction must be WEST or EAST
                    if (currentDirection == Direction.EAST) {
                        action = drone.head(currentDirection.right());
                    } else {
                        action = drone.head(currentDirection.left());
                    }
                }
            }
        } else if (deltaY <= 2) {
            if (deltaX > 0) { // drone is WEST to center
                if (currentDirection == Direction.EAST) {
                    action = drone.fly();
                } else { // The direction must be NORTH or SOUTH
                    if (currentDirection == Direction.SOUTH) {
                        action = drone.head(currentDirection.left());
                    } else {
                        action = drone.head(currentDirection.right());
                    }
                }
            } else { // drone is EAST to the center
                if (currentDirection == Direction.NORTH) {
                    action = drone.fly();
                } else { // The direction must be NORTH or SOUTH
                    if (currentDirection == Direction.SOUTH) {
                        action = drone.head(currentDirection.right());
                    } else {
                        action = drone.head(currentDirection.left());
                    }
                }
            }

        }

        return action;
    }
}
