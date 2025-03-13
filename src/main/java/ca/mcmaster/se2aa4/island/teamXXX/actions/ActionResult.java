package ca.mcmaster.se2aa4.island.teamXXX.actions;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.POI;
import ca.mcmaster.se2aa4.island.teamXXX.drone.POIType;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;

/**
 * Represents the result of an action.
 */
public class ActionResult {
    /**
     * The cost of the action.
     */
    private int cost;
    /**
     * Whether the action was successful.
     */
    private boolean status;
    /**
     * The result of an echo action.
     */
    private EchoActionResult echoResult;
    /**
     * The result of a scan action.
     */
    private ScanActionResult scanResult;

    /**
     * Creates a new ActionResult.
     * 
     * @param json creates it from the JSON parameters
     */
    public ActionResult(JSONObject json) {
        this.cost = json.getInt("cost");
        this.status = json.getBoolean("status");

        if (json.has("echoResult")) {
            JSONObject echoJson = json.getJSONObject("echoResult");
            this.echoResult = new EchoActionResult(echoJson.getInt("range"), echoJson.getBoolean("foundGround"));
        } else {
            this.echoResult = null;
        }

        if (json.has("scanResult")) {
            JSONObject scanJson = json.getJSONObject("scanResult");
            List<POI> creeks = new ArrayList<>();
            List<POI> sites = new ArrayList<>();
            JSONArray creeksArray = scanJson.getJSONArray("creeks");
            JSONArray sitesArray = scanJson.getJSONArray("sites");

            // this lowky looks chopped
            for (int i = 0; i < creeksArray.length(); i++) {
                creeks.add(new POI(Integer.toString(i),new Position(creeksArray.getJSONObject(i).getInt("x"), creeksArray.getJSONObject(i).getInt("y")), POIType.CREEK));
            }

            // this as well
            for (int i = 0; i < sitesArray.length(); i++) {
                sites.add(new POI(Integer.toString(i),new Position(sitesArray.getJSONObject(i).getInt("x"), sitesArray.getJSONObject(i).getInt("y")), POIType.SITE));
            }

            this.scanResult = new ScanActionResult(creeks, sites);
        } else {
            this.scanResult = null;
        }
    }

    /**
     * Gets the cost of the action performed.
     * 
     * @return the cost of the action
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets whether the action was successful.
     * 
     * @return whether the action was successful
     */
    public boolean isOk() {
        return status;
    }

    /**
     * Gets the result of an echo action.
     * 
     * @return the echo action result (or null if the action was not an echo action)
     */
    public EchoActionResult getEchoResult() {
        return echoResult;
    }

    /**
     * Gets the result of a scan action.
     * 
     * @return the scan action result (or null if the action was not a scan action)
     */
    public ScanActionResult getScanResult() {
        return scanResult;
    }

    @Override
    public String toString() {
        return String.format("ActionResult[cost=%d, status=%s, echoResult=%s, scanResult=%s]", cost,
                status ? "OK" : "MIA", echoResult,
                scanResult);
    }
}
