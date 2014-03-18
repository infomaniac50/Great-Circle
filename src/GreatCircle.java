/*************************************************************************
 *  Compilation:  javac GreatCircle.java
 *  Execution:    java GreatCircle L1 G1 L2 G2
 *
 *  Given the latitude and longitude (in degrees) of two points compute
 *  the great circle distance (in nautical miles) between them. The
 *  following formula assumes that sin, cos, and arcos are comptued
 *  in degrees, so need to convert back and forth between radians.
 *
 *     d  = 60 * acos (sin(L1)*sin(L2) + cos(L1)*cos(L2)*cos(G1 - G2))
 *
 *
 *  % java GreatCircle 59.9 -30.3 37.8 122.4        // Leningrad to SF
 *  4784.369673474519 nautical miles
 *
 *  % java GreatCircle 48.87 -2.33 30.27 97.74      // Paris to Austin
 *  4423.14075970742 nautical miles
 *
 *  % java GreatCircle 36.12 -86.67 33.94 -118.4    // Nashville airport (BNA) to LAX
 *  1557.50511103695 nautical miles
 *
 *  % java GreatCircle 40.35 74.65 48.87 -2.33      // Princeton to Paris
 *  3185.1779271158425 nautical miles
 *
 *************************************************************************/

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

       /*************************************************************************
        * Compute using law of cosines
        *************************************************************************/
        // great circle distance in radians
        double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2)
                      + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        // convert back to degrees
        angle1 = Math.toDegrees(angle1);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance1 = 60 * angle1;

        System.out.println(distance1 + " nautical miles");


       /*************************************************************************
        * Compute using Haverside formula
        *************************************************************************/
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                 + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance2 = 60 * angle2;

        System.out.println(distance2 + " nautical miles");

   }

}