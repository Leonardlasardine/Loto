package fr.leonard.loto;

import java.util.Arrays;

public class Numbers {

    public static void createNumbers(int boards, int Long, int large) {
        for (int i = 0; i < boards; i++) {
            //positions();
            System.out.println(Arrays.deepToString(positions(Long, large)));
        }
    }

    public static int[][] positions(int Long, int large) {
        int[][] nbLines = new int[large][Long / 2];
        int[] nbFirstLine = new int[Long / 2];

        int line = 0;
        while (line < large) {

            Arrays.fill(nbFirstLine, -1);
            int firstLigne = 0;
            while (firstLigne < Long / 2) {

                double random = Math.random() * Long;
                int number = (int) Math.floor(random);

                //CHECK IF NUMBER EXIST
                boolean numberExist = false;
                for (int j : nbFirstLine) {
                    if (Math.floor(random) == j) {
                        numberExist = true;
                        break;
                    }
                }

                //ELSE ADD THE NUMBER
                if (!numberExist) {
                    nbFirstLine[firstLigne] = number;
                    firstLigne++;
                }
            }
            //COPY
            System.arraycopy(nbFirstLine, 0, nbLines[line], 0, nbFirstLine.length);

            line++;
        }
        return nbLines;
    }
}
