package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.DroneAlgorithm;

public class GridSearchDroneAlgorithm extends DroneAlgorithm {
    private State state;

    public GridSearchDroneAlgorithm(Drone drone) {
        super(drone);
        this.state = new StartState(drone);
    }

    @Override
    public Action takeDecision() {
        return state.getAction();
    }

    @Override
    public void acknowledgeResults(ActionResult s) {
        state = state.nextState(s);
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
