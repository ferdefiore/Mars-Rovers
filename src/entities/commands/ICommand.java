package entities.commands;

import interfaces.IMarsRover;

/**
 * This interface is used to decode rovers commands into movements.
 * Provide two method execute and equalType.
 */
public interface ICommand {
    /**
     * @param marsRover Rover that will action by the command
     */
    void execute(IMarsRover marsRover);

    /**
     * @param command another ICommand type
     * @return it return true or false, depending if the type of the param command is the
     * same to the actual ICommand
     */
    boolean equalType(ICommand command);
}
