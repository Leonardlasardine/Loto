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
        GridLayout layout = new GridLayout(4, 2);
        jPanel.setLayout(layout);
        layout.setVgap(20);

        //ELEMENTS
        JLabel nbBoards = new JLabel("Nombre de planches");

        JTextField repNbBoards = new JTextField("1");
        Dimension textField = new Dimension(100, repNbBoards.getFont().getSize() * 2);
        repNbBoards.setPreferredSize(textField);
        repNbBoards.setHorizontalAlignment(SwingConstants.RIGHT);
        repNbBoards.setCaretPosition(1);

        JLabel boardLong = new JLabel("Nombre de colones");
        JTextField repBoardLong = new JTextField("10");
        repBoardLong.setPreferredSize(textField);
        repBoardLong.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel boardLarge = new JLabel("Nombre de lignes");
        JTextField repBoardlarge = new JTextField("3");
        repBoardlarge.setPreferredSize(textField);
        repBoardlarge.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton button = new JButton("Générer");
        button.addActionListener(e -> {

            String boards = repNbBoards.getText();
            String Long = repBoardLong.getText();
            String large = repBoardlarge.getText();

            boolean allValid = checkNumbers(boards)
                    && checkNumbers(Long)
                    && checkNumbers(large);

            if (allValid) {
                Numbers.createNumbers(Integer.parseInt(repNbBoards.getText()),
                        Integer.parseInt(repBoardLong.getText()),
                        Integer.parseInt(repBoardlarge.getText()));
            } else {
                JOptionPane.showMessageDialog(jFrame, "Veuillez enter un nombre valide !");
            }
        });

        //ADD
        jPanel.add(nbBoards);
        jPanel.add(repNbBoards);
        jPanel.add(boardLong);
        jPanel.add(repBoardLong);
        jPanel.add(boardLarge);
        jPanel.add(repBoardlarge);
        jPanel.add(new JLabel()); //EMPTY CASE
        jPanel.add(button);


        //DIMENSIONS
        Dimension minimumSize = new Dimension(300, 200);
        Dimension defaultSize = new Dimension(400, 400);
        jFrame.setMinimumSize(minimumSize);
        jFrame.setPreferredSize(defaultSize);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static boolean checkNumbers(String answer) {
        boolean isValid = true;

        for (int i = 0; i < answer.length(); i++) {
            if (!Character.isDigit(answer.charAt(i))) {
                isValid = false;
                break;
            }
        }

        if (answer.equals("")) {
            isValid = false;
        }

        return isValid;
    }
}
