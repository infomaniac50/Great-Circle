/* package whatever; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class CLI
{
    public static void main (String[] args) throws java.lang.Exception
    {
        double cLat, cLong, geoLat, geoLong;

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(buff);

        System.out.print("Enter Current Latitude: ");
        cLat = s.nextDouble();

        System.out.print("Enter Current Longitude: ");
        cLong = s.nextDouble();

        System.out.print("Enter Geo-Alert Latitude: ");
        geoLat = s.nextDouble();

        System.out.print("Enter Geo-Alert Longitude: ");
        geoLong = s.nextDouble();

        s.close();

        double lat1 = Math.toRadians(cLat);
        double lon1 = Math.toRadians(cLong);
        double lat2 = Math.toRadians(geoLat);
        double lon2 = Math.toRadians(geoLong);

        LatLong current = new LatLong(lat1, lon1);
        LatLong geo = new LatLong(lat2, lon2);

        System.out.printf("Current Coordinates: %f, %f\n", cLat, cLong);
        System.out.printf("Geo-Alert Coordinates: %f, %f\n\n", geoLat, geoLong);

        double equirectangularApproximation = current.equirectangularApproximation(geo);
        double haversine = current.haversine(geo);
        double sphericalLawOfCosines = current.sphericalLawOfCosines(geo);

        System.out.printf("Equirectangular Approximation: %f kilometers\n", equirectangularApproximation * LatLong.R);
        System.out.printf("Haversine: %f kilometers\n", haversine * LatLong.R);
        System.out.printf("Spherical Law Of Cosines: %f kilometers\n", sphericalLawOfCosines * LatLong.R);
    }
}