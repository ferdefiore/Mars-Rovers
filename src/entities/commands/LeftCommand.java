package entities.commands;

import entities.MarsRover;

public class LeftCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnLeft();
    }
}
