package JavaStreams;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by marin on 2/5/16.
 * NOTE: Uncomment the function that you would like to use.
 */
public class ListOfDoubles {

    private static ArrayList<Double> doubles;

    public static void main(String[] args) {

        doubles = new ArrayList<>();
        doubles.add(3.25);
        doubles.add(5.84);
        doubles.add(12.36);

        //saveObject();
        //loadObject();

    }

    public static void saveObject() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/doubles.list"))) {
            oos.writeObject(doubles);
        }

        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }

    }

    public static void loadObject() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/doubles.list"))) {
            System.out.println("Doubles: " + ois.readObject());
        }

        catch (ClassNotFoundException | IOException ioex) {
            System.err.println(ioex.toString());
        }
    }
}
