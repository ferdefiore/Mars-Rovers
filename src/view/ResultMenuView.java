package view;

import javax.swing.*;

public class ResultMenuView {
    private final static String TITLE = "Nasa Control Center";
    private JFrame frame;
    private JPanel panel;
    private JLabel marsRover_label;
    private JTextArea inputArea;
    private JButton closeButton;

    public ResultMenuView(String output) {

        frame = new JFrame(TITLE);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this.panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        inputArea.append(output);

        closeButton.addActionListener(e -> frame.dispose());
    }

}
