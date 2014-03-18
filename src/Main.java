/* package whatever; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    @SuppressWarnings("deprecation")
    public static void calculate(Scanner s) {
        double lat1 = 0.0, lon1 = 0.0, lat2 = 0.0, lon2 = 0.0;

        System.out.print("Enter Coordinate 1 Latitude: ");
        if (!s.hasNextDouble()) return;
        lat1 = s.nextDouble();

        System.out.print("Enter Coordinate 1 Longitude: ");
        if (!s.hasNextDouble()) return;
        lon1 = s.nextDouble();

        System.out.print("Enter Coordinate 2 Latitude: ");
        if (!s.hasNextDouble()) return;
        lat2 = s.nextDouble();

        System.out.print("Enter Coordinate 2 Longitude: ");
        if (!s.hasNextDouble()) return;
        lon2 = s.nextDouble();

        LatLong coord1 = LatLong.fromDecimalDegrees(lat1, lon1);
        LatLong coord2 = LatLong.fromDecimalDegrees(lat2, lon2);

        System.out.printf("\nCoordinate 1 Coordinates: %f, %f\n", lat1, lon1);
        System.out.printf("Coordinate 2 Coordinates: %f, %f\n\n", lat2, lon2);

        double equirectangularApproximation = coord1.equirectangularApproximation(coord2);
        double haversine = coord1.haversine(coord2);
        double sphericalLawOfCosines = coord1.sphericalLawOfCosines(coord2);

        System.out.printf("Equirectangular Approximation: %f kilometers\n", equirectangularApproximation * LatLong.R);
        System.out.printf("Haversine: %f kilometers\n", haversine * LatLong.R);
        System.out.printf("Spherical Law Of Cosines: %f kilometers\n", sphericalLawOfCosines * LatLong.R);
    }

	public static void main (String[] args) throws java.lang.Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(buff);

        System.out.println("Great Circle");
        System.out.println("Derek Chafin");
        String cmd = "";

        if (args.length > 0)
            cmd = args[0];

        switch (cmd) {
            case "Demo":
                Demo.calculate(s);
                break;
            default:
                Main.calculate(s);
        }
        s.close();
    }
}