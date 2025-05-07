package Lab4;

import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {
    TextField tfFirstName, tfLastName, tfAge, tfHoursWorked, tfHourlyRate;
    TextArea taOutput;
    Label lblMessage;

    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4");
        setSize(400, 400);
        setLayout(new GridLayout(9, 2, 5, 5));

        // Input Fields
        add(new Label("First Name"));
        tfFirstName = new TextField(30);
        add(tfFirstName);

        add(new Label("Last Name"));
        tfLastName = new TextField(30);
        add(tfLastName);

        add(new Label("Age"));
        tfAge = new TextField(30);
        add(tfAge);

        add(new Label("Hours Worked"));
        tfHoursWorked = new TextField(30);
        add(tfHoursWorked);

        add(new Label("Hourly Rate"));
        tfHourlyRate = new TextField(30);
        add(tfHourlyRate);

        // Submit Button
        Button btnSubmit = new Button("Submit");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        // Output
        add(new Label("Output:"));
        taOutput = new TextArea(5, 45);
        taOutput.setEditable(false);
        add(taOutput);

        // Error or Message Label
        lblMessage = new Label("");
        add(lblMessage);

        // Close the window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String ageStr = tfAge.getText().trim();
        String hoursStr = tfHoursWorked.getText().trim();
        String rateStr = tfHourlyRate.getText().trim();

        // Clear previous output and error
        taOutput.setText("");
        lblMessage.setText("");

        if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || hoursStr.isEmpty() || rateStr.isEmpty()) {
            lblMessage.setText("Error: All fields must be filled out.");
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            double hoursWorked = Double.parseDouble(hoursStr);
            double hourlyRate = Double.parseDouble(rateStr);

            double dailyWage = hoursWorked * hourlyRate;

            taOutput.setText("First Name: " + firstName + "\n" +
                             "Last Name: " + lastName + "\n" +
                             "Age: " + age + "\n" +
                             "Daily Wage: PHP " + String.format("%.2f", dailyWage));
        } catch (NumberFormatException ex) {
            lblMessage.setText("Error: Please enter valid numbers for Age, Hours Worked, and Hourly Rate.");
        }
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}
