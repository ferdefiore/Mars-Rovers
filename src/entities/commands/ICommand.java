package entities.commands;

import entities.MarsRover;

public interface ICommand {
    void execute(MarsRover marsRover);

    boolean equalType(ICommand command);
}
