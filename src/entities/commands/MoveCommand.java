package entities.commands;

import interfaces.IMarsRover;

public class MoveCommand implements ICommand {
    @Override
    public void execute(IMarsRover marsRover) {
        marsRover.moveForward();
    }

    @Override
    public boolean equalType(ICommand command) {
        return (command instanceof MoveCommand);
    }
}
