package fr.leonard.loto;

import javax.swing.*;
import java.awt.*;

public class Window {

    public static void jFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Générateur de planches de loto " + Loto.version);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);


        Dimension minimumSize = new Dimension(200, 200);
        Dimension defaultSize = new Dimension(400, 400);
        jFrame.setMinimumSize(minimumSize);
        jFrame.setPreferredSize(defaultSize);
        jFrame.pack();

        jFrame.setVisible(true);
    }
}
