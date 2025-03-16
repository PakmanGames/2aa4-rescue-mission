package ca.mcmaster.se2aa4.island.teamXXX;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionManager;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.GridSearchDroneAlgorithm;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.DroneAlgorithm;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private Drone drone;
    private DroneAlgorithm algorithm;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}", info.toString(2));
        String direction = info.getString("heading");
        Integer batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
        logger.info("Initializing the drone right nowwww----------------------------------");

        drone = new Drone(Direction.getFromAbbr(direction), batteryLevel, new ActionManager());
        algorithm = new GridSearchDroneAlgorithm(drone);

        logger.info("** Initialization complete");
    }

    @Override
    public String takeDecision() {
        JSONObject decision = algorithm.takeDecision().json();
        logger.info("** Decision: {}", decision.toString());
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n" + response.toString(2));
        Integer cost = response.getInt("cost");
        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("Additional information received: {}", extraInfo);

        algorithm.acknowledgeResults(new ActionResult(response));
    }

    @Override
    public String deliverFinalReport() {
        return algorithm.deliverFinalReport();
    }

}
