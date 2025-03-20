package ca.mcmaster.se2aa4.island.teamXXX.algorithm.spiral;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class StartState extends State {

    public StartState(Drone drone) {
        super(drone);
    }

    @Override
    public State nextState(ActionResult result) {
        getDrone().scan().consume(getDrone(), result);
        return new SpiralState(getDrone());
    }

    @Override
    public Action getAction() {
        // Just kept this there cuz every other action changes information
        return getDrone().scan();
    }

}
