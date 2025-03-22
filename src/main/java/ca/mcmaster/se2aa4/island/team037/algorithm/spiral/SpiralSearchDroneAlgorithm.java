package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import ca.mcmaster.se2aa4.island.team037.algorithm.DroneAlgorithm;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;

public class SpiralSearchDroneAlgorithm extends DroneAlgorithm {

    public SpiralSearchDroneAlgorithm(Drone drone) {
        super(drone);
    }




    @Override
    protected State getStartState(Drone drone) {
        return new StartState(drone);
    }

}
