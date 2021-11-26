package fr.leonard.loto;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View(int Long, int large, String[][] values) throws HeadlessException {
        //JFRAME
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Planche numéro " + Loto.version);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        //JPANEL
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(large, Long);
        jPanel.setLayout(layout);
        layout.setVgap(20);

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < Long / 2; j++) {
                JLabel jLabel = new JLabel(values[i][j]);
                jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                jPanel.add(jLabel);
            }
        }

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
}
