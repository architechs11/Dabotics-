package Dabotics.OnlineSurveys;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Rating extends JFrame {
    public Rating() {
        super("Customer Satisfaction Survey");

        // Set layout manager for the frame
        setLayout(new BorderLayout());
        
        // Create components
        JLabel instructionLabel = new JLabel("Please rate our service and provide your feedback:", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        instructionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel ratingLabel = new JLabel("Rate our service:", JLabel.RIGHT);
        String[] ratings = {"Excellent", "Good", "Average", "Poor"};
        JComboBox<String> ratingComboBox = new JComboBox<>(ratings);

        JLabel commentLabel = new JLabel("Additional comments:", JLabel.RIGHT);
        JTextArea commentTextArea = new JTextArea(5, 20);
        commentTextArea.setLineWrap(true);
        commentTextArea.setWrapStyleWord(true);
        JScrollPane commentScrollPane = new JScrollPane(commentTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Create panels
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to inputPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        inputPanel.add(ratingLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        inputPanel.add(ratingComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        inputPanel.add(commentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        inputPanel.add(commentScrollPane, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Add action listeners for buttons
        submitButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(Rating.this, "Thank you for your feedback!");
            // Submit the response (implement the submission logic here)
        });

        clearButton.addActionListener((ActionEvent e) -> {
            ratingComboBox.setSelectedIndex(0);
            commentTextArea.setText("");
        });

        // Add components to the frame
        add(instructionLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Rating rating = new Rating();
            rating.setVisible(true);
        });
    }
}
