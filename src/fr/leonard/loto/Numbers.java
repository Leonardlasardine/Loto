package fr.leonard.loto;

import java.util.Arrays;

public class Numbers {

    public Numbers(int boards, int Long, int large) {
        for (int i = 0; i < boards; i++) {
            int[][] posLines = positions(Long, large);
            int[][] sorted = sorted(values(posLines), Long, large);

            View view = new View(Long, large, sorted, i);
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
                for (int j : posOneLine) {
                    if (Math.floor(random) == j) {
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
            for (int j = 0; j < Long; j++) {
                double random = Math.random() * Long;

                String number = Integer.toString(positions[i][j]) + (int) Math.floor(random);
                values[i][j] = Integer.parseInt(number);
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
