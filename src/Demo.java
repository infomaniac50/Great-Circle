/* package whatever; // don't place package name! */
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Demo
{
    @SuppressWarnings("deprecation")
	public static void calculate(Scanner s) throws java.lang.Exception {
        System.out.println("Great Circle Demo");
        System.out.println("Derek Chafin");

        // LatLong office = new LatLong(39.1885979, -94.6861648);
        // LatLong nick_and_jakes = new LatLong(39.2096077, -94.6841551);
        LatLong office = LatLong.fromDecimalDegrees(39.1885979, -94.6861648);
        LatLong nick_and_jakes = LatLong.fromDecimalDegrees(39.2096077, -94.6841551);

        System.out.printf("The Office Coordinates: %f, %f\n", office.getLatitude(), office.getLongitude());
        System.out.printf("Nick and Jake's Coordinates: %f, %f\n\n", nick_and_jakes.getLatitude(), nick_and_jakes.getLongitude());

        double equirectangularApproximation = office.equirectangularApproximation(nick_and_jakes);
        double haversine = office.haversine(nick_and_jakes);
        double sphericalLawOfCosines = office.sphericalLawOfCosines(nick_and_jakes);

        System.out.printf("Equirectangular Approximation: %f kilometers\n", equirectangularApproximation * LatLong.R);
        System.out.printf("Haversine: %f kilometers\n", haversine * LatLong.R);
        System.out.printf("Spherical Law Of Cosines: %f kilometers\n", sphericalLawOfCosines * LatLong.R);
    }
}