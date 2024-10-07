import java.awt.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {

        // Panel to hold all input fields (2 numbers and 1 operator)
        JPanel panel = new JPanel();
        Color myColor = new Color(173, 216, 230);
        panel.setBackground(myColor);

        // Create text fields
        JTextField firstNumberField = new JTextField(10);
        JTextField secondNumberField = new JTextField(10);
        JTextField operatorField = new JTextField(5);

        Font font = new Font("Arial", Font.BOLD, 14);
        firstNumberField.setFont(font);
        secondNumberField.setFont(font);
        operatorField.setFont(font);

        boolean validInput = false;

        while (!validInput) {
            // clear text fields
            firstNumberField.setText("");
            secondNumberField.setText("");
            operatorField.setText("");

            panel.add(new JLabel("Enter the first number:"));
            panel.add(firstNumberField);
            panel.add(new JLabel("Enter the second number:"));
            panel.add(secondNumberField);
            panel.add(new JLabel("Enter an operator (+, -, *, /):"));
            panel.add(operatorField);

            // Show input dialog with all fields
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Calculator Input", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            // Check if user pressed OK
            if (result == JOptionPane.OK_OPTION) {
                double num1 = 0;
                double num2 = 0;
                String operator = operatorField.getText();

                // Validate first number
                if (!isNumeric(firstNumberField.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid input for the first number. Please enter a valid number.");
                    continue; // Go back to the beginning of loop
                } else {
                    num1 = Double.parseDouble(firstNumberField.getText());
                }

                // Validate second number
                if (!isNumeric(secondNumberField.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid input for the second number. Please enter a valid number.");
                    continue; // Go back to the beginning of loop
                } else {
                    num2 = Double.parseDouble(secondNumberField.getText());
                }

                double calculationResult = 0;

                // calculations
                switch (operator) {
                    case "+":
                        calculationResult = num1 + num2;
                        break;
                    case "-":
                        calculationResult = num1 - num2;
                        break;
                    case "*":
                        calculationResult = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            calculationResult = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                            continue; // Go back to the beginning of the loop
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Operator. Please enter +, -, *, or /.");
                        continue; // Go back to the beginning of the loop
                }

                JOptionPane.showMessageDialog(null, "Result: " + calculationResult);
                validInput = true;
            } else {
                // User pressed Cancel
                break;
            }
        }
    }

    // checks if a string is numeric
    private static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }
}
