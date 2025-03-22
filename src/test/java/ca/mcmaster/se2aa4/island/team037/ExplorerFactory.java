package ca.mcmaster.se2aa4.island.team037;

import org.json.JSONObject;

public class ExplorerFactory {

    public Explorer createExplorer(String parameters) {
        Explorer explorer = new Explorer();

        // Set the parameters of the explorer
        explorer.initialize(parameters);

        return explorer;
    }

    public Explorer createExplorer() {
        Explorer explorer = new Explorer();

        // Set the parameters of the explorer
        JSONObject info = new JSONObject();
        info.put("heading", "EAST");
        info.put("budget", 7000);
        explorer.initialize(info.toString());

        return explorer;
    }

}
