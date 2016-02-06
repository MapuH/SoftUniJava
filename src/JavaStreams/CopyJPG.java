package JavaStreams;

import java.io.*;

/**
 * Created by marin on 2/5/16.
 */
public class CopyJPG {

    public static void main(String[] args) {

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("res/test.gif"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("res/my-copied-pic.gif"))
        ) {
            int i;
            while ((i = bis.read()) != -1) {
                bos.write((char) i);
            }
        }

        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }
}
