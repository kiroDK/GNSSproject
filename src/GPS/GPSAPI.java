package GPS;

import java.util.HashMap;
import java.util.Map;

public class GPSAPI {

    private static final Map<String, Double[]> satelliteDatabase = new HashMap<String, Double[]>();

    public static void initDatabase() {
        satelliteDatabase.put("Andhra Pradesh", new Double[] { 15.9129, 79.7400 });
        satelliteDatabase.put("Arunachal Pradesh", new Double[] { 28.2180, 94.7278 });
        satelliteDatabase.put("Assam", new Double[] { 26.2006, 92.9376 });
        satelliteDatabase.put("Bihar", new Double[] { 25.0961, 85.3131 });
        satelliteDatabase.put("Chhattisgarh", new Double[] { 21.2787, 81.8661 });
        satelliteDatabase.put("Goa", new Double[] { 15.2993, 74.1240 });
        satelliteDatabase.put("Gujarat", new Double[] { 22.2587, 71.1924 });
        satelliteDatabase.put("Haryana", new Double[] { 29.0588, 76.0856 });
        satelliteDatabase.put("Himachal Pradesh", new Double[] { 31.1048, 77.1734 });
        satelliteDatabase.put("Jammu and Kashmir", new Double[] { 33.7782, 76.5762 });
        satelliteDatabase.put("Jharkhand", new Double[] { 23.6102, 85.2799 });
        satelliteDatabase.put("Karnataka", new Double[] { 15.3173, 75.7139 });
        satelliteDatabase.put("Kerala", new Double[] { 10.8505, 76.2711 });
        satelliteDatabase.put("Madhya Pradesh", new Double[] { 22.9734, 78.6569 });
        satelliteDatabase.put("Maharashtra", new Double[] { 19.7515, 75.7139 });
        satelliteDatabase.put("Manipur", new Double[] { 24.6637, 93.9063 });
        satelliteDatabase.put("Meghalaya", new Double[] { 25.4670, 91.3662 });
        satelliteDatabase.put("Mizoram", new Double[] { 23.1645, 92.9376 });
        satelliteDatabase.put("Nagaland", new Double[] { 26.1584, 94.5624 });
        satelliteDatabase.put("Odisha", new Double[] { 20.9517, 85.0985 });
        satelliteDatabase.put("Punjab", new Double[] { 31.1471, 75.3412 });
        satelliteDatabase.put("Rajasthan", new Double[] { 27.0238, 74.2179 });
        satelliteDatabase.put("Sikkim", new Double[] { 27.5330, 88.5122 });
        satelliteDatabase.put("Tamil Nadu", new Double[] { 11.1271, 78.6569 });
        satelliteDatabase.put("Telangana", new Double[] { 18.1124, 79.0192});
    }

    public static Double[] getLocationCoordinates(String locationName) {
        return satelliteDatabase.get(locationName);
    }

}
