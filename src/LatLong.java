/**
 * @author Derek Chafin
 * @version 1.0.1
 */
public class LatLong {
    private static final long serialVersionUID = 8101666014232058675L;

    public static final double R = 6371; // km

    private double latitude;
    private double longitude;

    /**
     * Constructor
     * @param  latitude  Latitude in radians.
     * @param  longitude Longitude in radians.
     * @return           A new instance of this class.
     */
    public LatLong(double latitude, double longitude) {
       this.latitude = latitude;
       this.longitude = longitude;
    }

    /**
     * Gets the latitude.
     * @return The latitude.
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets the longitude.
     * @return The longitude.
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Convert degree minute seconds to decimal degrees.
     * @param  degrees Degrees
     * @param  minutes Minutes
     * @param  seconds Seconds
     * @return         The decimal degrees equivalent of DD:MM":SS.SS' notation.
     */
    public static double toDecimalDegrees(double degrees, double minutes, double seconds) {
        return degrees + (minutes / 60) + ((seconds / 60) / 60);
    }

    /**
     * Helper function to instanitate this class from degrees instead of radians.
     * @param  latitude  Latitude in degrees.
     * @param  longitude Longitude in degrees.
     * @return           A new instance of this class.
     */
    public static LatLong fromDecimalDegrees(double latitude, double longitude) {
        return new LatLong(Math.toRadians(latitude), Math.toRadians(longitude));
    }

    /**
     * Calculates the distance between two points using Pythagora's theorem (a^2 + b^2 = c^2).
     * @param  lat1 Latitude of point 1 in radians.
     * @param  lon1 Longitude of point 1 in radians.
     * @param  lat2 Latitude of point 2 in radians.
     * @param  lon2 Longitude of point 2 in radians.
     * @return      The distance between two point in radians.
     */
    public static double equirectangularApproximation(double lat1, double lon1, double lat2, double lon2) {
        double x = (lon2-lon1) * Math.cos((lat1+lat2)/2);
        double y = (lat2-lat1);
        // equirectangular distance in radians
        double distance = Math.sqrt(x*x + y*y);

        return distance;
    }

    /**
     * Calculates the distance between two points using the Haversine formula.
     * @param  lat1 The latitude of point 1 in radians.
     * @param  lon1 The longitude of point 1 in radians.
     * @param  lat2 The latitude of point 2 in radians.
     * @param  lon2 The longitude of point 2 in radians.
     * @return      The distance between two points in radians.
     */
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double a = Math.pow(Math.sin((lat2-lat1)/2), 2)
                 + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((lon2-lon1)/2), 2);

        // great circle distance in radians
        double distance = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        return distance;
    }

    /**
     * Calculates the distance between two points using the Spherical Law of Cosines.
     * @param  lat1 The latitude of point 1 in radians.
     * @param  lon1 The longitude of point 1 in radians.
     * @param  lat2 The latitude of point 2 in radians.
     * @param  lon2 The longitude of point 2 in radians.
     * @return      The distance between two points in radians.
     * @deprecated  This function is for reference only. Do not use it for production.
     */
    public static double sphericalLawOfCosines(double lat1, double lon1, double lat2, double lon2) {
        // great circle distance in radians
        double distance = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                      + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        return distance;
    }

    /**
     * Calculates the distance between two points using Pythagora's theorem (a^2 + b^2 = c^2).
     * @param  location The second point in the calcuation.
     * @return          The distance between two points in radians.
     */
    public double equirectangularApproximation(LatLong location) {
        return LatLong.equirectangularApproximation(this.latitude, this.longitude, location.x, location.y);
    }

    /**
     * Calculates the distance between two points using the Haversine formula.
     * @param  location The second point in the calculation.
     * @return          The distance between two points in radians.
     */
    public double haversine(LatLong location) {
        return LatLong.haversine(this.latitude, this.longitude, location.x, location.y);
    }

    /**
     * Calculates the distance between two points using the Spherical Law of Cosines.
     * @param  location The second point in the calculation.
     * @return          The distance between two points in radians.
     * @deprecated The function is for reference only. Do not use it in production.
     */
    public double sphericalLawOfCosines(LatLong location) {
        return LatLong.sphericalLawOfCosines(this.latitude, this.longitude, location.x, location.y);
    }
}