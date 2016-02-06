package cz.malyzajic.pathfaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author daop
 */
public class Utils {

    public final String version = "0.1";

    public static String stringBuilder(InputStream fStream) throws IOException {
        StringBuilder sbuilder = null;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(fStream, "UTF-8"))) {
            sbuilder = new StringBuilder();
            String str = input.readLine();
            while (str != null) {
                sbuilder.append(str);
                str = input.readLine();
                if (str != null) {
                    sbuilder.append("\n");
                }
            }
        } finally {
            fStream.close();
        }
        return sbuilder == null ? null : sbuilder.toString();

    }
}
