package ca.mcmaster.se2aa4.island.team037;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;
import ca.mcmaster.se2aa4.island.team037.algorithm.DroneAlgorithm;
import ca.mcmaster.se2aa4.island.team037.algorithm.spiral.SpiralSearchDroneAlgorithm;
import ca.mcmaster.se2aa4.island.team037.drone.BaseDrone;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

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

        drone = new BaseDrone(Direction.getFromAbbr(direction), batteryLevel, new ActionManager());
        drone.setPosition(new Position(1, 1));
        algorithm = new SpiralSearchDroneAlgorithm(drone);

        logger.info("** Initialization complete");
    }

    @Override
    public String takeDecision() {
        JSONObject decision = algorithm.takeDecision().json();
        logger.info("** Decision: {}", decision.toString());
        return decision.toString();
        // return "{ 'action' : 'stop' }";
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
        logger.info("Drone battery level is now {}", drone.getBatteryLevel());

        try {
            algorithm.acknowledgeResults(new ActionResult(response));
        } catch (Exception e) {
            logger.error("Error in acknowledgeResults: {}", e);
            throw e;
        }
    }

    @Override
    public String deliverFinalReport() {
        String finalReport = algorithm.deliverFinalReport();
        logger.info("** Final report: {}", finalReport);
        return finalReport;
        // return "no creeks found";
    }

}
