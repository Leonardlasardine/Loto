package fr.leonard.loto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class View extends JFrame {

    public View(int Long, int large, int[][] values, int boardNumber, String path) {
        //JFRAME
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Planche numéro " + (boardNumber + 1));
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //JPANEL
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(large, Long);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < Long; j++) {
                JLabel jLabel = new JLabel();
                jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                jLabel.setOpaque(true);
                if (values[i][j] != -1) {
                    jLabel.setText(String.valueOf(values[i][j]));
                    jLabel.setBackground(Color.ORANGE);
                } else {
                    jLabel.setBackground(Color.LIGHT_GRAY);
                }
                jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel.setFont(new Font("Calibri", Font.BOLD, 36));
                jPanel.add(jLabel);
            }
        }

        //DIMENSIONS
        Dimension defaultSize = new Dimension(Long * 192, large * 360);
        jFrame.setPreferredSize(defaultSize);
        jFrame.setResizable(false);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        //TITLE BAR
        Insets inset = jFrame.getInsets();

        //FOLDER
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SCREENSHOT
        BufferedImage img = new BufferedImage(jFrame.getWidth() - inset.left - inset.right,
                jFrame.getHeight() - inset.top - inset.bottom, BufferedImage.TYPE_INT_RGB);
        jPanel.paint(img.getGraphics());
        File outputFile = new File(path + "/planche_" + (boardNumber + 1) + ".png");
        try {
            ImageIO.write(img, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jFrame.setVisible(false);
        jFrame.dispose();
    }
}
