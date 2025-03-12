package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team37.Explorer;

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
