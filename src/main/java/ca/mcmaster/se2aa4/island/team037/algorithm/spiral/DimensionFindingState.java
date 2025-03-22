package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;
import ca.mcmaster.se2aa4.island.team037.result.EchoActionResult;

public class DimensionFindingState extends State {
    private final Logger logger = LogManager.getLogger();
    private Direction currentEchoDirection;
    private Direction nextEchoDirection;
    private Integer oppositeEchoDistance;
    private Action action;
    private int length;
    private int width;
    // counters to track the states of the state ? 🤯
    private Integer numOfRightTurns;

    public DimensionFindingState(Drone drone) {
        super(drone);
        this.nextEchoDirection = null;
        this.currentEchoDirection = null;
        this.oppositeEchoDistance = Integer.MAX_VALUE;
        this.action = null;
        this.numOfRightTurns = 0;
        this.length = 0;
        this.width = 0;
    }

    public boolean hasLength() {
        return this.length > 0 && this.oppositeEchoDistance == 0;
    }

    public boolean hasWidth() {
        return this.width > 0 && this.oppositeEchoDistance == 0;
    }

    @Override
    public State nextState(ActionResult result) {
        logger.info("STARTING DIMENSION FINDING STATE CHECK");
        Drone drone = getDrone();
        action.consume(drone, result);
        
        if (result.isOk() && result.getEchoResult() instanceof EchoActionResult) {
            EchoActionResult echoResult = result.getEchoResult();
            if (this.currentEchoDirection == Direction.SOUTH) {
                this.length = echoResult.range();
            } else if (this.currentEchoDirection == Direction.SOUTH && this.nextEchoDirection == Direction.NORTH) {
                this.oppositeEchoDistance = echoResult.range();
                if (this.oppositeEchoDistance != 0) {
                    this.length = this.length + this.oppositeEchoDistance + 1;
                    this.oppositeEchoDistance = 0;
                } else {
                    this.length++;
                }
            } else if (this.currentEchoDirection == Direction.NORTH && this.nextEchoDirection == Direction.WEST && this.numOfRightTurns == 1) {
                this.width = echoResult.range();
            } else if (this.currentEchoDirection == Direction.WEST && this.nextEchoDirection == Direction.EAST) {
                this.oppositeEchoDistance = echoResult.range();
                if (this.oppositeEchoDistance != 0) {
                    this.width = this.width + this.oppositeEchoDistance;
                    this.oppositeEchoDistance = 0;
                } else {
                    this.width++;
                }
            }
        }

        action = null;

        if (this.hasLength() && this.hasWidth() && drone.getDirection() == Direction.SOUTH) {
            logger.info("TRANSITIONING TO CENTER STATE");
            logger.info("Length: {}", this.length);
            logger.info("Width: {}", this.width);
            return new CenterState(getDrone(), this.length, this.width);
        }
        logger.info("NOT READY TO TRANSITION TO CENTER STATE YET");
        logger.info("DimensionFindingState: numOfRightTurns = {}", this.numOfRightTurns);
        logger.info("Length: {}", this.length);
        logger.info("Width: {}", this.width);
        return this;
    }

    @Override
    public Action getAction() {
        logger.info("GETTING ACTION");
        Drone drone = getDrone();
        
        if (action != null) {
            return action;
        }

        if (this.numOfRightTurns == 0) {
            if (this.nextEchoDirection == null) {
                this.nextEchoDirection = drone.getDirection().right(); // SOUTH
                this.currentEchoDirection = this.nextEchoDirection;
                this.action = drone.echo(this.nextEchoDirection);
                return this.action;
            } else if (this.nextEchoDirection == drone.getDirection().right()) {
                this.nextEchoDirection = drone.getDirection().left(); // NORTH
                this.currentEchoDirection = this.nextEchoDirection;
                this.action = drone.echo(this.nextEchoDirection);
                return this.action;
            } else if (this.nextEchoDirection == drone.getDirection().left()) {
                this.action = drone.head(Direction.SOUTH);
                this.nextEchoDirection = null; // Reset for next state
                this.numOfRightTurns++;
                return this.action;
            }
        }
        else if (this.numOfRightTurns == 1) {
            if (this.nextEchoDirection == null) {
                this.nextEchoDirection = drone.getDirection().right(); // WEST
                this.action = drone.echo(this.nextEchoDirection);
                return this.action;
            } else if (this.nextEchoDirection == drone.getDirection().right()) {
                this.currentEchoDirection = this.nextEchoDirection;
                this.nextEchoDirection = drone.getDirection().left(); // EAST
                this.action = drone.echo(this.nextEchoDirection);
                return this.action;
            } 
        }

        logger.info("NO ACTION TO RETURN");
        return null;
    }
}
