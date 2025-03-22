package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.MapInfo;
import ca.mcmaster.se2aa4.island.teamXXX.drone.POI;
import ca.mcmaster.se2aa4.island.teamXXX.drone.POIType;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.result.ScanActionResult;

public class ScanAction implements Action {

    @Override
    public void consume(Drone drone, ActionResult result) {
        drone.expend(result.getCost());
        MapInfo mapInfo = drone.getMapInfo();
        Position position = drone.getPosition();

        // Perform the scanning
        ScanActionResult scanResult = result.getScanResult();

        // Add the POIs to the map
        for (String id : scanResult.sites())
            mapInfo.addPOI(new POI(id, position, POIType.SITE));

        // Add the creeks to the map
        for (String id : scanResult.creeks())
            mapInfo.addPOI(new POI(id, position, POIType.CREEK));
    }

    @Override
    public ActionType type() {
        return ActionType.SCAN;
    }

    @Override
    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "scan");
        return command;
    }
}
