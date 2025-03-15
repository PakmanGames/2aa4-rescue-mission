package ca.mcmaster.se2aa4.island.teamXXX.mvp;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;

public class GridSearchState extends State {

    public GridSearchState(Drone drone) {
        super(drone);
    }

    @Override
    public State nextState(ActionResult action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextState'");
    }

    @Override
    public JSONObject getAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAction'");
    }

}
