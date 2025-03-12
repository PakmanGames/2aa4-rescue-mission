package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;

/**
 * The ActionManager class is responsible for creating JSON strings that
 * represent commands that the drone can execute.
 * The JSON strings are used to communicate with the drone.
 */
public class ActionManager {

    /**
     * Creates a JSON string that represents a fly forward command.
     * When executed, the drone will fly <b>3 units</b> forward
     * The command returned is <code>{ 'action': 'fly' }</code>
     * 
     * @return the JSON string representing the fly forward command
     */
    public String createFlyCommand() {
        JSONObject command = new JSONObject();
        command.put("action", "fly");
        return command.toString();
    }

    /**
     * Creates a JSON string that represents a turn command.
     * The drone will turn <b>90 degrees</b> to the left but a side effect is that
     * it will go <b>3 units in the heading</b> as well as <b>3 units forward.</b>
     * The heading must be adjecent to the current direction.
     * The command returned is
     * <code>{ 'action': 'heading', parameters: { "direction", heading } }</code>
     * 
     * @param heading the direction to turn
     * @return the command for the drone to change its heading
     */
    public String createHeadingCommand(Direction heading) {
        JSONObject command = new JSONObject();
        command.put("action", "heading");

        // { 'direction': 'N' }
        JSONObject parameters = new JSONObject();
        parameters.put("direction", heading);

        // { 'action': 'heading', 'parameters': { 'direction': 'N' } }
        command.put("parameters", parameters);
        return command.toString();
    }

    /**
     * Creates a JSON string that represents an echo command.
     * The drone will send a signal 3 units forward and attempt to use this to find
     * land and how far away it is. The heading must be the current direction or
     * directions adjecent to it. The command returned is
     * <code>{ 'action': 'echo', parameters: { "direction", heading } }</code>
     * 
     * @param heading the direction to turn
     * @return the command for land detection
     */
    public String createEchoCommand(Direction heading) {
        JSONObject command = new JSONObject();
        command.put("action", "echo");

        // { 'direction': 'N' }
        JSONObject parameters = new JSONObject();
        parameters.put("direction", heading);

        // { 'action': 'heading', 'parameters': { 'direction': 'N' } }
        command.put("parameters", parameters);
        return command.toString();
    }

    /**
     * Creates a JSON string that represents to drone to scan its surroundings.
     * The command returned is <code>{ 'action': 'scan' }</code>
     * 
     * @return the JSON string representing the scan command
     */
    public String createScanCommand() {
        JSONObject command = new JSONObject();
        command.put("action", "scan");
        return command.toString();
    }

    /**
     * Creates a JSON string that represents to stop and head back.
     * The command returned is <code>{ 'action': 'stop' }</code>
     * 
     * @return the JSON string representing the stop command
     */
    public String createStopCommand() {
        JSONObject command = new JSONObject();
        command.put("action", "stop");
        return command.toString();
    }

}
