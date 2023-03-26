package GPS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GPS_GUI extends JFrame implements ActionListener {
    private JLabel requestLabel;
    private JButton requestButton;
    private JTextArea responseTextArea;

    public GPS_GUI() {
        super("GPS System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        requestLabel = new JLabel("Request location coordinate:");
        requestButton = new JButton("Request");
        responseTextArea = new JTextArea(5, 30);

        add(requestLabel);
        add(requestButton);
        add(responseTextArea);

        requestButton.addActionListener(this);
    }

        public void actionPerformed(ActionEvent e) {
            GPS_Backend backend = new GPS_Backend();
            double[] location = backend.getLocation();
            responseTextArea.setText("Latitude: " + location[0] + "\nLongitude: " + location[1]);
        }

    public static void main(String[] args) {
        GPS_GUI gps = new GPS_GUI();
        gps.setVisible(true);
    }
}
