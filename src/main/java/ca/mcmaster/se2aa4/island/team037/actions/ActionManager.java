package ca.mcmaster.se2aa4.island.team037.actions;

import ca.mcmaster.se2aa4.island.team037.drone.Direction;

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
    public Action createFlyCommand() {
        return new FlyAction();
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
    public Action createHeadingCommand(Direction heading) {
        return new HeadingAction(heading);
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
    public Action createEchoCommand(Direction heading) {
        return new EchoAction(heading);
    }

    /**
     * Creates a JSON string that represents to drone to scan its surroundings.
     * The command returned is <code>{ 'action': 'scan' }</code>
     * 
     * @return the JSON string representing the scan command
     */
    public Action createScanCommand() {
        return new ScanAction();
    }

    /**
     * Creates a JSON string that represents to stop and head back.
     * The command returned is <code>{ 'action': 'stop' }</code>
     * 
     * @return the JSON string representing the stop command
     */
    public Action createStopCommand() {
        return new StopAction();
    }

}
