package cz.malyzajic.pathfaker;

import com.vividsolutions.jts.geom.Coordinate;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author daop
 */
public class GooglePathContext extends PathContext {

    private static final Logger LOGGER = Logger.getLogger(GooglePathContext.class.getSimpleName());

    private String startPointString;
    private String endPointString;
    private String googleKey;
    private String googleLang;

    private String rawOutput;

    @Override
    public void loadPath() {
        prepareContext();
        rawOutput = calculateRoute();
        System.out.println(rawOutput);
    }

    public String calculateRoute() {
        String result;
        String hashedUrl;
        try {

            hashedUrl = "https://maps.googleapis.com/maps/api/directions/json?key=" + googleKey + "&sensor=false&origin="
                    + startPointString + "&destination=" + endPointString + "&language=" + googleLang;
            System.out.println("" + hashedUrl);
            URL urlGoogleDirService = new URL(hashedUrl);

            HttpURLConnection urlGoogleDirCon = (HttpURLConnection) urlGoogleDirService.openConnection();
            urlGoogleDirCon.setAllowUserInteraction(false);
            urlGoogleDirCon.setDoInput(true);
            urlGoogleDirCon.setDoOutput(false);
            urlGoogleDirCon.setUseCaches(true);
            urlGoogleDirCon.setRequestMethod("GET");
            urlGoogleDirCon.connect();

            String out = Utils.stringBuilder(urlGoogleDirCon.getInputStream());
            // LOGGER.debug("calculateRoute() :: has got new path");
            urlGoogleDirCon.disconnect();
            result = out;

        } catch (IOException e) {
            result = null;
        }
        return result;
    }

    private void prepareContext() {
        if (getProperties() != null) {
            googleKey = getProperties().getProperty("key", "");
            googleLang = getProperties().getProperty("language", "en");
        } else {
            throw new IllegalStateException("Missing google api params");
        }
        if (getPathRequest() != null) {
            startPointString = fetchPoint(getPathRequest().getStartPlaceCoord(), getPathRequest().getStartPlaceName());
            endPointString = fetchPoint(getPathRequest().getEndPlaceCoord(), getPathRequest().getEndPlaceName());
        } else {
            throw new IllegalStateException("Missing path request");
        }

    }

    private String fetchPoint(Coord startPlaceCoord, String startPlaceName) {
        String result = null;
        if (startPlaceCoord != null) {
            result = startPlaceCoord.toUriPart();
        } else {
            try {
                result = URLEncoder.encode(startPlaceName, "UTF-8");
            } catch (UnsupportedEncodingException ex) {

            }
        }
        return result;
    }

    private List<Coordinate> decodePoly(String encoded) {

        List<Coordinate> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            Coordinate p = new Coordinate((int) (((double) lat / 1E5) * 1E6), (int) (((double) lng / 1E5) * 1E6));
            poly.add(p);
        }

        return poly;
    }
}
