package ca.mcmaster.se2aa4.island.team37.actions;

import org.json.JSONObject;

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
