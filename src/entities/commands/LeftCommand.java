package entities.commands;

import interfaces.IMarsRover;

/**
 * LeftCommand used to perform rotate the rover to the left
 */
public class LeftCommand implements ICommand {
    /**
     * @param marsRover Rover that will action by the command
     */
    @Override
    public void execute(IMarsRover marsRover) {
        marsRover.turnLeft();
    }

    /**
     * @param command another ICommand type
     */
    @Override
    public boolean equalType(ICommand command) {
        return (command instanceof LeftCommand);
    }

}
