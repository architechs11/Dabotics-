package Dabotics.OnlineSurveys;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Rating rating = new Rating();
            rating.setVisible(true);
        });
    }
}
