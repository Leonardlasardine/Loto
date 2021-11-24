package fr.leonard.loto;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() throws HeadlessException {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Générateur de planches de loto " + Loto.version);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        Dimension minimumSize = new Dimension(300, 100);
        Dimension defaultSize = new Dimension(400, 400);
        jFrame.setMinimumSize(minimumSize);
        jFrame.setPreferredSize(defaultSize);

        JLabel nbPlanches = new JLabel("Nombre de planches");
        JTextField repNbPlanches = new JTextField("100");

        repNbPlanches.setPreferredSize(new Dimension(100, repNbPlanches.getFont().getSize() * 2));
        repNbPlanches.setHorizontalAlignment(SwingConstants.RIGHT);
        repNbPlanches.setCaretPosition(3);

        JButton button = new JButton("Générer");
        button.addActionListener(e -> System.out.println("Boutton"));

        jPanel.add(nbPlanches, BorderLayout.WEST);
        jPanel.add(repNbPlanches, BorderLayout.EAST);
        jPanel.add(button, BorderLayout.SOUTH);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
