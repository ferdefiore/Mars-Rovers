package entities.commands;

import interfaces.IMarsRover;

public class MoveCommand implements ICommand {
    /**
     * @param marsRover Rover that will action by the command
     */
    @Override
    public void execute(IMarsRover marsRover) {
        marsRover.moveForward();
    }

    /**
     * @param command another ICommand type
     */
    @Override
    public boolean equalType(ICommand command) {
        return (command instanceof MoveCommand);
    }
}
