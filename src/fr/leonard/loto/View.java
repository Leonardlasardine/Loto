package fr.leonard.loto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View extends JFrame {

    public View(int Long, int large, int[][] values, int boardNumber) {
        //JFRAME
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Planche numéro " + boardNumber);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //jFrame.setLocationRelativeTo(0, 0);

        //JPANEL
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(large, Long, 10, 10);
        jPanel.setLayout(layout);

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < Long; j++) {
                JLabel jLabel = new JLabel();
                if (values[i][j] != -1) {
                    jLabel.setText(String.valueOf(values[i][j]));
                    jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    jLabel.setOpaque(true);
                    jLabel.setBackground(Color.ORANGE);
                }
                jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                jPanel.add(jLabel);
            }
        }

        //DIMENSIONS
        Dimension defaultSize = new Dimension(1800, 900);
        jFrame.setPreferredSize(defaultSize);
        jFrame.setResizable(false);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        //TITLE BAR
        Insets inset = jFrame.getInsets();

        BufferedImage img = new BufferedImage(jFrame.getWidth() - inset.left - inset.right,
                jFrame.getHeight() - inset.top - inset.bottom, BufferedImage.TYPE_INT_RGB);
        jPanel.paint(img.getGraphics());
        File outputFile = new File("image_" + boardNumber + ".png");
        try {
            ImageIO.write(img, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*jFrame.setVisible(false);
        jFrame.dispose();*/
    }
}
