package entities.commands;

import interfaces.IMarsRover;

public class RightCommand implements ICommand {
    @Override
    public void execute(IMarsRover marsRover) {
        marsRover.turnRight();
    }

    public boolean equalType(ICommand command) {
        return (command instanceof RightCommand);
    }
}
