package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultMenuView {
    private JFrame frame;
    private JPanel panel;
    private JLabel marsRover_label;
    private JTextArea inputArea;
    private JButton closeButton;

    public ResultMenuView(Controller nasaController) {
        frame = new JFrame("Nasa Control Center");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this.panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        inputArea.append(nasaController.getOutputLog());

        closeButton.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                nasaController.viewDisposed();
            }
        });
    }
}
