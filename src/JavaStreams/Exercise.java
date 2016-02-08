package JavaStreams;

import java.io.*;

/**
 * Created by marin on 2/8/16.
 */
public class Exercise {

    private static final String FILE_PATH = "res/users.txt";
    private static final String SAVE_PATH = "res/total-time.txt";

    public static void main(String[] args) {

        File file = new File(FILE_PATH);
        File outputFile = new File(SAVE_PATH);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
                PrintWriter writer = new PrintWriter(new FileWriter(outputFile))
            ) {

            String line = reader.readLine();

            while (line != null) {
                String[] lineArgs = line.split(" ");
                String username = lineArgs[0];
                int totalMinutes = 0;
                for (int i = 1; i < lineArgs.length; i++) {
                    String[] loggedTime = lineArgs[i].split(":");
                    int hours = Integer.parseInt(loggedTime[0]);
                    int minutes = Integer.parseInt(loggedTime[1]);
                    totalMinutes += minutes + (hours * 60);
                }

                int days = totalMinutes / 1440;
                int hours = (totalMinutes % 1440) / 60;
                int minutes = (totalMinutes % 1440) % 60;
                System.out.printf("%s played for %d days, %d hours and %d minutes\n", username, days, hours, minutes);
                writer.printf("%s %d (%d days, %d hours, %d minutes)\n", username, totalMinutes, days, hours, minutes);

                line = reader.readLine();
            }

            writer.close();
            reader.close();

        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }

    }
}
