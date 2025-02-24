import java.util.Scanner;

public class VolumeOfEarth {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double radiusMiles = radiusKm / 1.6;
        double volumeKm = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);
        
        System.out.println("Volume of Earth in cubic kilometers: " + volumeKm);
        System.out.println("Volume of Earth in cubic miles: " + volumeMiles);
    }
}
