package entities.commands;

import entities.MarsRover;

public class RightCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnRight();
    }

    public boolean equalType(ICommand command) {
        return (command instanceof RightCommand);
    }
}
