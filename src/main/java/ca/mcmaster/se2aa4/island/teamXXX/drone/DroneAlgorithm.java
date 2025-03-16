package ca.mcmaster.se2aa4.island.teamXXX.drone;

import org.json.JSONObject;

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

    public String deliverFinalReport() {
        MapInfo mapInfo = drone.getMapInfo();

        if (mapInfo.getCreeks().size() == 0) {
            return "no creek found";
        } else {
            POI site = mapInfo.getEmergencySite();
            POI creek = mapInfo.getNearestCreek();

            JSONObject obj = new JSONObject();
            obj.put("emergency_site", site.id());
            obj.put("nearest_creek", creek.id());

            return obj.toString();
        }
    }
}
