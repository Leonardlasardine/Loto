package fr.leonard.loto;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class Window extends JFrame {

    public Window() throws HeadlessException {
        //JFRAME
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Générateur de planches de loto " + Loto.version);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        //JPANEL
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(6, 2, 10, 10);
        jPanel.setLayout(layout);
        layout.setVgap(20);

        //ELEMENTS
        JLabel nbBoards = new JLabel("Nombre de planches");

        JTextField repNbBoards = new JTextField("1");
        Dimension textField = new Dimension(100, repNbBoards.getFont().getSize() * 2);
        repNbBoards.setPreferredSize(textField);
        repNbBoards.setHorizontalAlignment(SwingConstants.RIGHT);
        repNbBoards.setCaretPosition(1);

        JLabel boardLong = new JLabel("Nombre de colones (pair)");
        JTextField repBoardLong = new JTextField("10");
        repBoardLong.setPreferredSize(textField);
        repBoardLong.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel boardLarge = new JLabel("Nombre de lignes");
        JTextField repBoardlarge = new JTextField("3");
        repBoardlarge.setPreferredSize(textField);
        repBoardlarge.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel folder = new JLabel("Dossier");
        AtomicReference<String> path = new AtomicReference<>("panches/");
        JTextField repFolder = new JTextField(path.get());
        repFolder.setPreferredSize(textField);

        JButton buttonChooser = new JButton("Choisir le dossier de destination");
        buttonChooser.addActionListener(e -> {

            try { //STYLE WINDOWS
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
                e2.printStackTrace();
            }
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choisir le dossier de destination");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            int returnFolder = chooser.showOpenDialog(this);
            if (returnFolder == JFileChooser.APPROVE_OPTION) {
                path.set(chooser.getSelectedFile().toString());
                repFolder.setText(path.get());
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
                    e2.printStackTrace();
                }
            }
        });

        JButton button = new JButton("Générer");
        button.addActionListener(e -> {

            String boards = repNbBoards.getText();
            String Long = repBoardLong.getText();
            String large = repBoardlarge.getText();

            boolean allValid = checkNumbers(boards)
                    && checkNumbers(Long)
                    && checkNumbers(large);

            if (allValid) {
                new Numbers(Integer.parseInt(repNbBoards.getText()),
                        Integer.parseInt(repBoardLong.getText()),
                        Integer.parseInt(repBoardlarge.getText()),
                        path.get());
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
        jPanel.add(folder);
        jPanel.add(buttonChooser);
        jPanel.add(new JLabel());
        jPanel.add(repFolder);
        jPanel.add(new JLabel());/*EMPTY CASE*/
        jPanel.add(button);


        //DIMENSIONS
        Dimension minimumSize = new Dimension(400, 400);
        Dimension defaultSize = new Dimension(600, 600);
        jFrame.setMinimumSize(minimumSize);
        jFrame.setPreferredSize(defaultSize);

        setContentPane(jPanel);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private static boolean checkNumbers(String answer) {
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
