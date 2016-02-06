package cz.malyzajic.pathfaker;

import java.util.Properties;

/**
 *
 * @author daop
 */
public abstract class PathContext {

    private PathRequest pathRequest;
    private Coord[] pathCoords;
    private Properties properties;

    public abstract void loadPath();

    public Coord getPathCoordByTime(long time) {
        Coord result = null;

        return result;
    }

    public PathRequest getPathRequest() {
        return pathRequest;
    }

    public void setPathRequest(PathRequest pathRequest) {
        this.pathRequest = pathRequest;
    }

    public Coord[] getPathCoords() {
        return pathCoords;
    }

    public void setPathCoords(Coord[] pathCoords) {
        this.pathCoords = pathCoords;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
