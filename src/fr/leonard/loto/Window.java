package fr.leonard.loto;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() throws HeadlessException {
        //JFRAME
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Générateur de planches de loto " + Loto.version);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        //JPANEL
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        //DIMENSIONS
        Dimension minimumSize = new Dimension(300, 100);
        Dimension defaultSize = new Dimension(400, 400);
        jFrame.setMinimumSize(minimumSize);
        jFrame.setPreferredSize(defaultSize);

        //ELEMENTS
        JLabel nbBoards = new JLabel("Nombre de planches");
        JTextField repNbBoards = new JTextField("100");

        repNbBoards.setPreferredSize(new Dimension(100, repNbBoards.getFont().getSize() * 2));
        repNbBoards.setHorizontalAlignment(SwingConstants.RIGHT);
        repNbBoards.setCaretPosition(3);

        JButton button = new JButton("Générer");
        button.addActionListener(e -> {

            String text = repNbBoards.getText();
            boolean isValid = true;

            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    isValid = false;
                }
            }

            if (isValid) {
                Numbers.createNumbers(Integer.parseInt(repNbBoards.getText()));
            } else {
                JOptionPane.showMessageDialog(jFrame, "Veuillez enter un nombre de planche valide !");
            }
        });

        //ADD
        jPanel.add(nbBoards, BorderLayout.WEST);
        jPanel.add(repNbBoards, BorderLayout.EAST);
        jPanel.add(button, BorderLayout.SOUTH);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
