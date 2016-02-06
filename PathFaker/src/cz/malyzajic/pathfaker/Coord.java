package cz.malyzajic.pathfaker;

/**
 *
 * @author daop
 */
public class Coord {

    private Integer lon1e6;
    private Integer lat1e6;
    private Long timestamp;

    public Coord() {

    }

    public Coord(Integer lon1e6, Integer lat1e6, Long timestamp) {
        this.lon1e6 = lon1e6;
        this.lat1e6 = lat1e6;
        this.timestamp = timestamp;
    }

    public double getLat() {
        return (double) lat1e6 / 1e6d;
    }

    public double getLon() {
        return (double) lon1e6 / 1e6d;
    }

    public Integer getLon1e6() {
        return lon1e6;
    }

    public void setLon1e6(Integer lon1e6) {
        this.lon1e6 = lon1e6;
    }

    public Integer getLat1e6() {
        return lat1e6;
    }

    public void setLat1e6(Integer lat1e6) {
        this.lat1e6 = lat1e6;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String toUriPart() {
        return getLat1e6() + "+" + getLon1e6();
    }

    @Override
    public String toString() {
        return "Coord{" + "lon1e6=" + lon1e6 + ", lat1e6=" + lat1e6 + ", timestamp=" + timestamp + '}';
    }

}
