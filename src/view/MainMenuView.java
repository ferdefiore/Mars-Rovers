package view;

import controller.Controller;
import interfaces.IDecoderOutput;
import interfaces.ILoggerOutput;
import interfaces.IOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class implements IOutput
 * View Class to show the first screen menu UI and interact with the user.
 * Here the user place the string with the input. After the user perform a click in the send command button,
 * this view inform to the controller the user action.
 * The controller act in consequence and them by IOutput method exposeResults expose the expedition output
 * results, used to create the second view.
 *
 * @see IOutput
 * @see Controller
 * @see ResultMenuView
 */
public class MainMenuView implements IOutput {
    private static final String INPUT_EXAMPLE_MSG = "Example: \n\n 5 5 (Plateau dimension) \n 1 2 N (Rover initial position) \n LMLMLMLMM (Instruction set)";
    private static final String EMPTY = "";
    private JFrame frame;
    private JPanel panel;
    private JTextArea inputArea;
    private JButton sendCommandButton;
    private JTextPane InputInstructions;
    private JLabel marsRover_label;
    private final String exampleMessage = INPUT_EXAMPLE_MSG;
    Controller controller;

    public void runView() {
        frame = new JFrame("Nasa Control Center");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this.panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        marsRover_label.grabFocus();
        inputArea.setForeground(Color.GRAY);
        inputArea.setText(exampleMessage);

        inputArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (inputArea.getText().equals(exampleMessage)) {
                    inputArea.setText(EMPTY);
                    inputArea.setForeground(Color.BLACK);
                    inputArea.setFocusable(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (inputArea.getText().isEmpty()) {
                    inputArea.setForeground(Color.GRAY);
                    inputArea.setFocusable(false);
                    inputArea.setText(exampleMessage);
                }

            }
        });

        sendCommandButton.addActionListener(e -> {
            String instructionSet = inputArea.getText();
            controller.performMovementsIntoPlateau(instructionSet, this);
        });
    }

    @Override
    public void exposeResults(ILoggerOutput loggerOutput, IDecoderOutput inputIDecoderOutput) {
        new ResultMenuView(loggerOutput.getOutput());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
