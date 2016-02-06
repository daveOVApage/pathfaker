package cz.malyzajic.pathfaker;

/**
 *
 * @author daop
 */
public class PathRequest {

    private String startPlaceName;
    private Coord startPlaceCoord;
    private String endPlaceName;
    private Coord endPlaceCoord;

    public String getStartPlaceName() {
        return startPlaceName;
    }

    public void setStartPlaceName(String startPlaceName) {
        this.startPlaceName = startPlaceName;
    }

    public String getEndPlaceName() {
        return endPlaceName;
    }

    public void setEndPlaceName(String endPlaceName) {
        this.endPlaceName = endPlaceName;
    }

    public Coord getStartPlaceCoord() {
        return startPlaceCoord;
    }

    public void setStartPlaceCoord(Coord startPlaceCoord) {
        this.startPlaceCoord = startPlaceCoord;
    }

    public Coord getEndPlaceCoord() {
        return endPlaceCoord;
    }

    public void setEndPlaceCoord(Coord endPlaceCoord) {
        this.endPlaceCoord = endPlaceCoord;
    }

}
