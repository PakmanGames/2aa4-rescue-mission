package ca.mcmaster.se2aa4.island.team037.algorithm.mvp;

import ca.mcmaster.se2aa4.island.team037.algorithm.DroneAlgorithm;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;

public class GridSearchDroneAlgorithm extends DroneAlgorithm {

    public GridSearchDroneAlgorithm(Drone drone) {
        super(drone);
    }

    @Override
    protected State getStartState(Drone drone) {
        return new StartState(drone);
    }

}
