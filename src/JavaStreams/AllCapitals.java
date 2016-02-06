package JavaStreams;

import java.io.*;
import java.util.*;

/**
 * Created by marin on 2/3/16.
 */
public class AllCapitals {

    public static void main(String[] args) {

        try (BufferedReader fr = new BufferedReader(new FileReader("res/lines.txt"))) {

            List<String> lines = new ArrayList<>();

            while (true) {
                String line = fr.readLine();
                if (line == null) break;

                lines.add(line);

            }

            PrintWriter writer = new PrintWriter("res/lines.txt");
            for (String line : lines) {
                writer.println(line.toUpperCase());
            }
            writer.close();

        } catch (IOException ioex) {

            System.err.println("File not found!");
        }

    }
}
