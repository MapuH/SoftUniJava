package JavaStreams;

import java.io.*;
import java.util.zip.*;

/**
 * Created by marin on 2/6/16.
 */
public class CreateZIP {

    public static void main(String[] args) throws IOException {

        String[] files = {"res/words.txt", "res/count-chars.txt", "res/lines.txt"};

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("res/text-files.zip"))) {

            zos.setLevel(9);

            for (int i = 0; i < files.length; i++) {
                ZipEntry ze = new ZipEntry(files[i]);
                FileInputStream fis = new FileInputStream(files[i]);
                try {
                    System.out.println("Compressing " + files[i]);
                    zos.putNextEntry(ze);
                    for (int c = fis.read(); c != -1; c = fis.read()) {
                        zos.write(c);
                    }
                } finally {
                    fis.close();
                }
            }

            zos.close();
        }
        catch (IOException ex) {
            System.err.println(ex.toString());
        }

    }
}
