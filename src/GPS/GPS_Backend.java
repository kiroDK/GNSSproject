package GPS;

import java.util.Random;

public class GPS_Backend {
    private static final double MIN_LATITUDE = -90.0;
    private static final double MAX_LATITUDE = 90.0;
    private static final double MIN_LONGITUDE = -180.0;
    private static final double MAX_LONGITUDE = 180.0;

    private Random random;

    public GPS_Backend() {
        random = new Random();
    }

    public double[] getLocation() {
        double latitude = random.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE) + MIN_LATITUDE;
        double longitude = random.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE) + MIN_LONGITUDE;
        return new double[]{latitude, longitude};
    }
}
