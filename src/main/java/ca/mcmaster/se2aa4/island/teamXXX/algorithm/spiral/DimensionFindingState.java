package ca.mcmaster.se2aa4.island.teamXXX.algorithm.spiral;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.result.EchoActionResult;

public class DimensionFindingState extends State {
    private Direction currentEchoDirection;
    private Direction nextEchoDirection;
    private Integer oppositeEchoDistance;
    private Action action;
    private Integer numOfRightTurns;
    private Integer forwardFlyCount;
    private int length;
    private int width;

    public DimensionFindingState(Drone drone) {
        super(drone);
        this.nextEchoDirection = drone.getDirection().right();
        this.currentEchoDirection = null;
        this.oppositeEchoDistance = null;
        this.action = drone.echo(this.nextEchoDirection);
        this.numOfRightTurns = 0;
        this.forwardFlyCount = 0;
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
        Drone drone = getDrone();
        action.consume(drone, result);
        if (result.isOk() && result.getEchoResult() instanceof EchoActionResult) {
            EchoActionResult echoResult = result.getEchoResult();
            if (currentEchoDirection == Direction.SOUTH) {
                length = echoResult.range();
            } else if (currentEchoDirection == Direction.NORTH) {
                oppositeEchoDistance = echoResult.range();
                if (oppositeEchoDistance != 0) {
                    length = length + oppositeEchoDistance + 1;
                    oppositeEchoDistance = 0;
                }
            } else if (currentEchoDirection == Direction.EAST) {
                width = echoResult.range();
            } else if (currentEchoDirection == Direction.WEST) {
                oppositeEchoDistance = echoResult.range();
                if (oppositeEchoDistance != 0) {
                    width = width + oppositeEchoDistance + 1;
                    oppositeEchoDistance = 0;
                }
            }
        }

        if (this.hasLength() && this.hasWidth() && numOfRightTurns == 5) {
            // return new CenterState(getDrone(), this.length, this.width); // TODO uncomment this when we have CenterState
            return null;
        }
        return this;
    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        if (numOfRightTurns == 0) {
            if (nextEchoDirection == drone.getDirection().right()) {
                currentEchoDirection = nextEchoDirection;
                Action nextAction = action;
                nextEchoDirection = drone.getDirection().left();
                action = drone.echo(nextEchoDirection);
                return nextAction;
            } else if (nextEchoDirection == drone.getDirection().left()) {
                currentEchoDirection = nextEchoDirection;
                Action nextAction = action;
                action = drone.echo(nextEchoDirection);
                nextEchoDirection = drone.getDirection();
                return nextAction;
            } else if (nextEchoDirection == drone.getDirection()) {
                currentEchoDirection = nextEchoDirection;
                if (drone.getDirection() == Direction.EAST) {
                    action = drone.head(Direction.SOUTH);
                    numOfRightTurns++;
                    Action nextAction = action;
                    nextEchoDirection = drone.getDirection().left();
                    return nextAction;
                }
            }
        } else if (numOfRightTurns == 1) {
            if (nextEchoDirection == drone.getDirection().left()) {
                currentEchoDirection = nextEchoDirection;
                Action nextAction = action;
                action = drone.echo(nextEchoDirection);
                nextEchoDirection = drone.getDirection().right();
                return nextAction;
            } else if (nextEchoDirection == drone.getDirection().right()) {
                currentEchoDirection = nextEchoDirection;
                Action nextAction = action;
                action = drone.echo(nextEchoDirection);
                nextEchoDirection = null;
                return nextAction;
            } else if (nextEchoDirection == null && drone.getDirection() == Direction.SOUTH) {
                action = drone.head(Direction.EAST);
                return action;
            } else if (nextEchoDirection == null && drone.getDirection() == Direction.EAST) {
                action = drone.head(Direction.SOUTH);
                numOfRightTurns++;
                return action;
            }
        } else if (numOfRightTurns == 2) {
            if (drone.getDirection() == Direction.SOUTH) {
                action = drone.head(Direction.WEST);
                numOfRightTurns++;
                return action;
            }
        } else if (numOfRightTurns == 3) {
            if (drone.getDirection() == Direction.WEST && forwardFlyCount == 0) {
                action = drone.fly();
                forwardFlyCount++;
                return action;
            } else if (drone.getDirection() == Direction.WEST && forwardFlyCount == 1) {
                action = drone.head(Direction.NORTH);
                numOfRightTurns++;
                return action;
            }
        } else if (numOfRightTurns == 4) {
            if (drone.getDirection() == Direction.NORTH && forwardFlyCount < 3) {
                action = drone.fly();
                forwardFlyCount++;
                return action;
            } else if (drone.getDirection() == Direction.NORTH && forwardFlyCount == 3) {
                action = drone.head(Direction.EAST);
                numOfRightTurns++;
                return action;
            }
        }
        return null;
    }
}
