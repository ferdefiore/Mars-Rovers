package entities.commands;

import entities.MarsRover;

public class MoveCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.moveForward();
    }

    public boolean equalType(ICommand command) {
        return (command instanceof MoveCommand);
    }
}
