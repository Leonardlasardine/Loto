package fr.leonard.loto;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Numbers {

    public Numbers(int boards, int Long, int large, String path, Color color) {
        for (int i = 0; i < boards; i++) {
            int[][] posLines = positions(Long, large);
            int[][] sorted = sorted(values(posLines), Long, large);

            new View(Long, large, sorted, i, path, color);
        }

        //OPEN THE FOLDER
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[][] positions(int Long, int large) {
        int[][] posLines = new int[large][Long / 2];
        int[] posOneLine = new int[Long / 2];

        int line = 0;
        while (line < large) {

            Arrays.fill(posOneLine, -1);
            int oneLigne = 0;
            while (oneLigne < Long / 2) {

                double random = Math.random() * Long;
                int number = (int) Math.floor(random);

                //CHECK IF NUMBER EXIST
                boolean numberExist = false;
                for (int i : posOneLine) {
                    if (number == i) {
                        numberExist = true;
                        break;
                    }
                }

                //ELSE ADD THE NUMBER
                if (!numberExist) {
                    posOneLine[oneLigne] = number;
                    oneLigne++;
                }
            }
            Arrays.sort(posOneLine);
            //COPY
            System.arraycopy(posOneLine, 0, posLines[line], 0, posOneLine.length);

            line++;
        }
        return posLines;
    }

    private int[][] values(int[][] positions) {
        int Long = positions[1].length;
        int large = positions.length;
        int[][] values = new int[large][Long];

        for (int i = 0; i < large; i++) {
            int oneLigne = 0;
            while (oneLigne < Long) {
                double random = Math.random() * Long * 2;
                int random2 = (int) Math.floor(random);
                String number = Integer.toString(positions[i][oneLigne]) + random2;

                //CHECK IF NUMBER EXIST
                boolean numberExist = false;
                outer:
                for (int j = 0; j < large; j++) {
                    for (int k : values[j]) {
                        if (number.equals(String.valueOf(k))) {
                            numberExist = true;
                            break outer;
                        }
                    }
                }

                //ELSE ADD THE NUMBER
                if (!numberExist) {
                    values[i][oneLigne] = Integer.parseInt(number);
                    oneLigne++;
                }
            }
        }
        return values;
    }

    private int[][] sorted(int[][] values, int Long, int large) {
        int[][] sorted = new int[large][Long];

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < Long; j++) {
                for (int a : values[i]) {
                    if (a / 10 == j) {
                        sorted[i][j] = a;
                        break;
                    } else {
                        sorted[i][j] = -1;
                    }
                }
            }
        }
        return sorted;
    }
}
