package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;
import org.json.JSONArray;

import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class ActionResultFactory {
    public ActionResult createActionResultWithEcho(int cost, String status, int range, String found) {
        JSONObject json = new JSONObject();
        json.put("cost", cost);
        json.put("status", status);

        JSONObject extras = new JSONObject();
        extras.put("range", range);
        extras.put("found", found);
        json.put("extras", extras);

        return new ActionResult(json);
    }

    public ActionResult createActionResultWithScan(int cost, String status) {
        JSONObject json = new JSONObject();
        json.put("cost", cost);
        json.put("status", status);

        JSONObject extras = new JSONObject();
        extras.put("biomes", new JSONArray());
        extras.put("creeks", new JSONArray());
        extras.put("sites", new JSONArray());
        json.put("extras", extras);

        return new ActionResult(json);
    }
}
