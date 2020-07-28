package entities.commands;

import entities.MarsRover;

public class RightCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnRight();
    }
}
