package ca.mcmaster.se2aa4.island.teamXXX.drone;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;

public abstract class DroneAlgorithm {
    private Drone drone;

    public DroneAlgorithm(Drone drone) {
        this.drone = drone;
    }

    public Drone getDrone() {
        return drone;
    }

    public abstract Action takeDecision();

    public abstract void acknowledgeResults(ActionResult s);

    public abstract String deliverFinalReport();
}
