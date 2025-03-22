package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.MapInfo;
import ca.mcmaster.se2aa4.island.teamXXX.drone.POI;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public abstract class DroneAlgorithm {
    private Drone drone;
    private State state;

    public DroneAlgorithm(Drone drone) {
        this.drone = drone;
        this.state = getStartState(drone);
    }

    public Drone getDrone() {
        return drone;
    }

    public Action takeDecision() {
        return state.getAction();
    }

    public void acknowledgeResults(ActionResult s) {
        state = state.nextState(s);
    }

    protected abstract State getStartState(Drone drone);

    public String deliverFinalReport() {
        MapInfo mapInfo = drone.getMapInfo();

        if (mapInfo.getCreeks().size() == 0) {
            return "no creek found";
        } else {
            POI site = mapInfo.getEmergencySite();

            if (site != null) {
                POI creek = mapInfo.getNearestCreek();

                JSONObject obj = new JSONObject();
                obj.put("emergency_site", site.id());
                obj.put("nearest_creek", creek.id());

                return obj.toString();
            } else {
                JSONObject obj = new JSONObject();
                obj.put("creek", mapInfo.getCreeks().get(0).id());
                return obj.toString();
            }
        }
    }
}
