package interfaces;

import entities.commands.ICommand;
import models.Plateau;

import java.util.ArrayList;
import java.util.Map;

/**
 * This interface provides behavior to access to expedition information.
 * Also, it should implement equals.
 */
public interface IDecoderOutput {
    /**
     * @return Plateau where rovers will perform movements
     * @see Plateau
     */
    Plateau getPlateau();

    /**
     * @return ArrayList with IMarsRovers
     * @see IMarsRover
     */
    ArrayList<IMarsRover> getMarsRovers();

    /**
     * @return Map with (key:roverId, value: list of commands for key roverId)
     */
    Map<Integer, ArrayList<ICommand>> getRoverInstructionSet();

    /**
     * Verifying that each element inside the IDecoderOutput is the same that in the Object o,
     * but no checking by reference.
     */
    @Override
    boolean equals(Object o);
}
