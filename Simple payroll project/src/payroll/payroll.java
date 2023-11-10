package payroll;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollForm extends JFrame implements ActionListener {
    private JTextField gross, rate, hours, days, net, sss, tax, health, deductions, gross1, deductions1, name;
    private JButton button1;
    private Font commonFont;

    public PayrollForm() {
        // Set the layout manager to null to specify component positions directly.
        setLayout(null);
        commonFont = new Font("SansSerif", Font.PLAIN, 12);

        // Header
        JLabel l1 = new JLabel("Simple Payroll System");
        l1.setBounds(400, 10, 200, 30);
        l1.setFont(new Font("SansSerif", Font.BOLD, 16));

        add(l1);

        // Column 1
        JLabel l2 = new JLabel("Employee Name");
        l2.setBounds(10, 50, 150, 25);
        l2.setFont(commonFont);
        name = new JTextField("Harry Den");
        name.setBounds(160, 50, 150, 25);
        add(l2);
        add(name);

        JLabel l3 = new JLabel("Rate per Hour");
        l3.setBounds(10, 100, 150, 25);
        l3.setFont(commonFont);
        rate = new JTextField(40);
        rate.setBounds(160, 100, 80, 25);
        add(l3);
        add(rate);

        JLabel l4 = new JLabel("Hours per Day");
        l4.setBounds(10, 150, 150, 25);
        l4.setFont(commonFont);
        hours = new JTextField(9);
        hours.setBounds(160, 150, 150, 25);
        add(l4);
        add(hours);

        JLabel l5 = new JLabel("Days worked");
        l5.setBounds(10, 200, 150, 25);
        l5.setFont(commonFont);
        days = new JTextField(31);
        days.setBounds(160, 200, 150, 25);
        add(l5);
        add(days);

        JLabel l6 = new JLabel("GROSS SALARY");
        l6.setBounds(10, 250, 150, 25);
        l6.setFont(new Font("SansSerif", Font.BOLD, 16));

        gross = new JTextField();
        gross.setBounds(160, 250, 100, 25);
        gross.setEditable(false);
        add(l6);
        add(gross);

        // Column 2
        JLabel l7 = new JLabel("DEDUCTIONS OF SALARY");
        l7.setBounds(320, 50, 200, 25);
        l7.setForeground(Color.red);
        add(l7);

        JLabel l8 = new JLabel("TAX 15% OF MONTHLY WAGE");
        l8.setBounds(320, 100, 150, 25);
        l8.setFont(commonFont);
        tax = new JTextField();
        tax.setBounds(480, 100, 80, 25);
        tax.setEditable(false);
        add(l8);
        add(tax);

        JLabel l9 = new JLabel("Philhealth 5%");
        l9.setBounds(320, 150, 150, 25);
        l9.setFont(commonFont);
        health = new JTextField();
        health.setBounds(480, 150, 80, 25);
        health.setEditable(false);
        add(l9);
        add(health);

        JLabel l10 = new JLabel("SSS 2%");
        l10.setBounds(320, 200, 150, 25);
        l10.setFont(commonFont);
        sss = new JTextField();
        sss.setBounds(480, 200, 80, 25);
        sss.setEditable(false);
        add(l10);
        add(sss);

        JLabel l11 = new JLabel("TOTAL DEDUCTION");
        l11.setBounds(320, 250, 200, 25);
        l11.setFont(new Font("SansSerif", Font.BOLD, 16));

        deductions = new JTextField();
        deductions.setBounds(480, 250, 100, 25);
        deductions.setEditable(false);
        add(l11);
        add(deductions);

        // Column 3
        JLabel l12 = new JLabel("Gross salary");
        l12.setBounds(640, 50, 150, 25);
        l12.setFont(commonFont);
        gross1 = new JTextField();
        gross1.setBounds(800, 50, 100, 25);
        gross1.setEditable(false);
        add(l12);
        add(gross1);

        JLabel l13 = new JLabel("Deduction");
        l13.setBounds(640, 100, 150, 25);
        l13.setFont(commonFont);
        deductions1 = new JTextField();
        deductions1.setBounds(800, 100, 100, 25);
        deductions1.setEditable(false);
        add(l13);
        add(deductions1);

        JLabel l14 = new JLabel("NET SALARY");
        l14.setBounds(640, 250, 150, 25);
        l14.setFont(new Font("SansSerif", Font.BOLD, 16));

        net = new JTextField();
        net.setBounds(800, 250, 100, 25);
        net.setEditable(false);
        add(l14);
        add(net);

        // COMPUTE BUTTON
        button1 = new JButton("Compute");
        button1.setBounds(480, 300, 150, 40);
        button1.setBackground(Color.green);
        button1.setBorder(new LineBorder(Color.blue));

        button1.addActionListener(this);
        add(button1);

        // Set frame properties
        setTitle("Payroll");
        setVisible(true);
        setSize(950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Get input values from text fields
            double rateValue = Double.parseDouble(rate.getText());
            double hoursValue = Double.parseDouble(hours.getText());
            int daysValue = Integer.parseInt(days.getText());

            // Calculate gross salary
            double grossSalary = rateValue * hoursValue * daysValue;
            gross.setText(String.valueOf(grossSalary));
            gross1.setText(String.valueOf(grossSalary));

            // Calculate tax, health, and SSS
            double taxValue = 0.15 * grossSalary;
            double healthValue = 0.05 * grossSalary;
            double sssValue = 0.02 * grossSalary;
            tax.setText(String.valueOf(taxValue));
            health.setText(String.valueOf(healthValue));
            sss.setText(String.valueOf(sssValue));

            // Calculate deductions
            double totalDeductions = taxValue + healthValue + sssValue;
            deductions.setText(String.valueOf(totalDeductions));
            deductions1.setText(String.valueOf(totalDeductions));

            // Calculate net salary
            double netSalary = grossSalary - totalDeductions;
            net.setText(String.valueOf(netSalary));

        } catch (NumberFormatException ex) {
            // Handle invalid input gracefully
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PayrollForm();
        });
    }
}
