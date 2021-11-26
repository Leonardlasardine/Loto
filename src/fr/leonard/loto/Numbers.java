package fr.leonard.loto;

import java.util.Arrays;

public class Numbers {

    public Numbers(int boards, int Long, int large) {
        for (int i = 0; i < boards; i++) {
            View view = new View(Long, large,
                    values(positions(Long, large)));
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

    private String[][] values(int[][] positions) {
        int Long = positions[1].length;
        int large = positions.length;
        String[][] values = new String[large][Long];

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < Long; j++) {
                double random = Math.random() * Long;

                String number = Integer.toString(positions[i][j]) + (int) Math.floor(random);
                values[i][j] = number;
            }
        }
        return values;
    }
}
