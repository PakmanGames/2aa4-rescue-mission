package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class DimensionFindingState extends State {



    public DimensionFindingState(Drone drone, int mapWidth, int mapHeight) {
        super(drone);

    }

    @Override
    public State nextState(ActionResult action) {
        // If the state still has work to be done then it should go to the current state
        // Otherwise it should go to the CenterState
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextState'");
    }

    @Override
    public Action getAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAction'");
    }
}
