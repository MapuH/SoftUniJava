package JavaStreams;

import java.io.*;

/**
 * Created by marin on 2/3/16.
 */
public class SumLines {

    public static void main(String[] args) {

        try (BufferedReader fr = new BufferedReader(new FileReader("res/lines.txt"))) {

            while (true) {
                String line = fr.readLine();
                if (line == null) break;

                int lineSum = 0;

                for (int i = 0; i < line.length() ; i++) {
                    char ch = line.charAt(i);
                    int value = (int) ch;
                    lineSum += value;
                }

                System.out.println(lineSum);
            }

        } catch (IOException ioex) {

            System.err.println("File not found!");
        }

    }
}
