package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.MapInfo;
import ca.mcmaster.se2aa4.island.team037.drone.POI;
import ca.mcmaster.se2aa4.island.team037.drone.POIType;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;
import ca.mcmaster.se2aa4.island.team037.result.ScanActionResult;

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
