package entities.commands;

import interfaces.IMarsRover;

public interface ICommand {
    void execute(IMarsRover marsRover);

    boolean equalType(ICommand command);
}
