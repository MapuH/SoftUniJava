package JavaStreams;

import java.io.*;

/**
 * Created by marin on 2/4/16.
 */

public class CountCharTypes {

    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new FileReader("res/words.txt"))) {

            int vowelCounter = 0;
            int consCounter = 0;
            int punctCounter = 0;

            while (true) {
                String line = bfr.readLine();
                if (line == null) break;

                for (int i = 0; i < line.length() ; i++) {
                    char ch = line.toLowerCase().charAt(i);

                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowelCounter += 1;

                    } else if (ch == '!' || ch == ',' || ch == '.' || ch == '?') {
                        punctCounter += 1;

                    } else if (ch == ' ') {
                        continue;

                    } else {
                        consCounter += 1;
                    }

                }
            }

            PrintWriter writer = new PrintWriter("res/count-chars.txt");
            writer.println("Vowels: " + vowelCounter);
            writer.println("Consonants: " + consCounter);
            writer.println("Punctuation: " + punctCounter);
            writer.close();

        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        } catch (IOException ioex) {
            System.err.println("I/O Error!");
        }

    }
}
