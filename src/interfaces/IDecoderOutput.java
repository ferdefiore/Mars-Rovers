package interfaces;

import entities.Plateau;
import entities.commands.ICommand;

import java.util.ArrayList;
import java.util.Map;

/**
 * This interface provides behaviour to access to an expedition information.
 * Also, it should implements equals.
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
