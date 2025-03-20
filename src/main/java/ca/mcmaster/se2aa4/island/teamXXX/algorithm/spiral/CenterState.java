package ca.mcmaster.se2aa4.island.teamXXX.algorithm.spiral;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class CenterState extends State {
    private int mapWidth;
    private int mapHeight;

    public CenterState(Drone drone,int mapHeight,int mapWidth) {//Assume DimensionFindingState can transfer width and height as parameter
        super(drone);
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
    }

    public boolean isCenter(Position position){
        int centerX = mapWidth / 2;
        int centerY = mapHeight / 2;
        boolean is_center = (position.getX()== centerX && position.getY() == centerY);
        return is_center;

    }

    @Override
    public State nextState(ActionResult action) {
        // If the state still has work to be done then it should go to the current state
        // Otherwise it should go to the SpiralState
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'nextState'");

        if (isCenter(getDrone().getPosition())) {
            return new SpiralState(getDrone());
        }

        return this;//if not center, stay at current state
    }


    @Override
    public Action getAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAction'");
    }

}
