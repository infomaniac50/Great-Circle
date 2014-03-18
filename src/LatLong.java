import java.awt.geom.Point2D;

public class LatLong extends Point2D.Double {
    private static final long serialVersionUID = 8101666014232058675L;

    public static final double R = 6371; // km

    public LatLong(double latitude, double longitude) {
       this.x = latitude;
       this.y = longitude;
    }

    public static double toDecimalDegrees(double degrees, double minutes, double seconds) {
        return degrees + (minutes / 60) + ((seconds / 60) / 60);
    }

    public LatLong toRadians() {
        return new LatLong(Math.toRadians(this.x), Math.toRadians(this.y));
    }

    public LatLong toDegrees() {
        return new LatLong(Math.toDegrees(this.x), Math.toDegrees(this.y));
    }

    public static double equirectangularApproximation(double lat1, double lon1, double lat2, double lon2) {
        double x = (lon2-lon1) * Math.cos((lat1+lat2)/2);
        double y = (lat2-lat1);
        // equirectangular distance in radians
        double distance = Math.sqrt(x*x + y*y);

        return distance;
    }

    public static double haversine(double x1, double y1, double x2, double y2) {
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                 + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double distance = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        return distance;
    }

    public static double sphericalLawOfCosines(double x1, double y1, double x2, double y2) {
        // great circle distance in radians
        double distance = Math.acos(Math.sin(x1) * Math.sin(x2)
                      + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        return distance;
    }

    public double equirectangularApproximation(LatLong location) {
        return LatLong.equirectangularApproximation(this.x, this.y, location.x, location.y);
    }

    public double haversine(LatLong location) {
        return LatLong.haversine(this.x, this.y, location.x, location.y);
    }

    public double sphericalLawOfCosines(LatLong location) {
        return LatLong.sphericalLawOfCosines(this.x, this.y, location.x, location.y);
    }
}