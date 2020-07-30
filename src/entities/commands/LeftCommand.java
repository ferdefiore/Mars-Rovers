package entities.commands;

import interfaces.IMarsRover;

public class LeftCommand implements ICommand {
    @Override
    public void execute(IMarsRover marsRover) {
        marsRover.turnLeft();
    }

    @Override
    public boolean equalType(ICommand command) {
        return (command instanceof LeftCommand);
    }

}
