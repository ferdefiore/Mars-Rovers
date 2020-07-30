package interfaces;

import entities.Plateau;
import entities.commands.ICommand;

import java.util.ArrayList;
import java.util.Map;

public interface IDecoderOutput {
    Plateau getPlateau();

    ArrayList<IMarsRover> getMarsRovers();

    Map<Integer, ArrayList<ICommand>> getRoverInstructionSet();

    @Override
    boolean equals(Object o);
}
