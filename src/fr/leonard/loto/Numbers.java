package fr.leonard.loto;

import java.util.Arrays;

public class Numbers {

    public static void createNumbers(int boards) {
        for (int i = 0; i < boards; i++) {
            positions();
        }
    }

    public static void positions() {
        //FIRST LINE = 5 NUMBERS, SECONDE = 5, ECT...
        int[] nbFirstLine = new int[5];
        int[] nbLines = new int[15];

        int line = 0;
        while (line < 3) {

            Arrays.fill(nbFirstLine, -1);
            int firstLigne = 0;
            while (firstLigne < 5) {

                double random = Math.random() * 10;
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
            System.arraycopy(nbFirstLine, 0, nbLines, line * 5, 5);
            line++;
        }

        System.out.println(Arrays.toString(nbLines));
    }
}
