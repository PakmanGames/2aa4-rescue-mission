package ca.mcmaster.se2aa4.island.teamXXX.algorithm.mvp;

import ca.mcmaster.se2aa4.island.teamXXX.algorithm.DroneAlgorithm;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;

public class GridSearchDroneAlgorithm extends DroneAlgorithm {

    public GridSearchDroneAlgorithm(Drone drone) {
        super(drone);
    }

    @Override
    protected State getStartState(Drone drone) {
        return new StartState(drone);
    }

}
