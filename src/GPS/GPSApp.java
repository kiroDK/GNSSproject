package GPS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import javax.swing.border.Border;


public class GPSApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField sourceTextField;
    private JTextField destinationTextField;
    private JTextField locationTextField;

    public GPSApp() {
        super("GPS App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GPSAPI.initDatabase();

        JPanel inputPanel = new JPanel();
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        JLabel locationLabel = new JLabel("Enter Location Name: ");
        locationTextField = new JTextField(15);

        JButton getCoordButton = new JButton("Get Location Coordinates");
        getCoordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String locationName = locationTextField.getText();
                Double[] locationCoords = GPSAPI.getLocationCoordinates(locationName);
                if (locationCoords != null) {
                    JOptionPane.showMessageDialog(GPSApp.this, "Location Coordinates: " + "("+locationCoords[0] + ", " +locationCoords[1]+")");
                } else {
                    JOptionPane.showMessageDialog(GPSApp.this, "Location Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel sourceLabel = new JLabel("Enter Source Location Name: ");
        sourceTextField = new JTextField(15);

        JLabel destinationLabel = new JLabel("Enter Destination Location Name: ");
        destinationTextField = new JTextField(15);



        JButton getLocationButton = new JButton("Get Location and Distance");
        getLocationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sourceName = sourceTextField.getText();
                String destName = destinationTextField.getText();
                Double[] sourceCoords = GPSAPI.getLocationCoordinates(sourceName);
                Double[] destCoords = GPSAPI.getLocationCoordinates(destName);
                if (sourceCoords != null && destCoords != null) {
                    double distance = calculateDistance(sourceCoords[0], sourceCoords[1], destCoords[0], destCoords[1]);
                    JOptionPane.showMessageDialog(GPSApp.this, "Source Coordinates: " + "("+ sourceCoords[0] + ", " + sourceCoords[1] +")"
                            + "\nDestination Coordinates: "+ "(" + destCoords[0] + ", " + destCoords[1] +")"
                            + "\nDistance between Source and Destination: " + distance + " km");
                } else {
                    JOptionPane.showMessageDialog(GPSApp.this, "Location Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel creditLabel = new JLabel("Created By:- Dibyanshu Kiro");
        creditLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                locationTextField.setText("");
                sourceTextField.setText("");
                destinationTextField.setText("");
            }
        });

        inputPanel.add(locationLabel);
        inputPanel.add(locationTextField);
        inputPanel.add(getCoordButton);
        inputPanel.add(sourceLabel);
        inputPanel.add(sourceTextField);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationTextField);
        inputPanel.add(getLocationButton);
        inputPanel.add(clearButton);
        inputPanel.add(creditLabel, BorderLayout.SOUTH);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createRaisedBevelBorder()));

        getContentPane().add(inputPanel, BorderLayout.CENTER);
        setSize(new Dimension(300, 300));
        setVisible(true);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        DecimalFormat df = new DecimalFormat("#.####");
        distance = Double.valueOf(df.format(distance));
        return distance;
    }

    public static void main(String[] args) {
        new GPSApp();
    }

}
