package view;

import game_logic.game_logic;

import javax.swing.*;
import java.awt.*;

public class View {

    // Instanzvariablen
    private JLabel coinLabel = new JLabel("Münzen: 0");
    private JButton coinButton = new JButton("Click for Coin");
    private JButton increaseMultiplierButton = new JButton("Increase Multiplier");
    private game_logic player = new game_logic();
    private JLabel multiplierLabel = new JLabel("Mult: 0");  // Hier korrigiert: "multiplierLabel" statt "muliplierLabel"
    private JLabel passiveIncomeLabel = new JLabel("Passive Income: 0");
    private JButton passiveIncomeButton = new JButton("Increase Passive Income");

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Mein Spiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // CENTER: Zeigt den Münzzähler an
        JPanel centerPanel = new JPanel();
        centerPanel.add(coinLabel);
        frame.add(centerPanel, BorderLayout.CENTER);

        // SOUTH: Coin-Button und Passive Income-Button zusammen
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(coinButton);
        bottomPanel.add(passiveIncomeButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // WEST: Multiplier-Label
        JPanel westPanel = new JPanel();
        westPanel.add(multiplierLabel);
        frame.add(westPanel, BorderLayout.WEST);

        // NORTH: Increase Multiplier-Button
        JPanel northPanel = new JPanel();
        northPanel.add(increaseMultiplierButton);
        frame.add(northPanel, BorderLayout.NORTH);

        // EAST: Passive Income-Label
        JPanel eastPanel = new JPanel();
        eastPanel.add(passiveIncomeLabel);
        frame.add(eastPanel, BorderLayout.EAST);

        // ActionListener für den Coin-Button
        coinButton.addActionListener(e -> {
            double updatedCoins = player.incrementCoins();
            coinLabel.setText("Münzen: " + updatedCoins);
        });

        // ActionListener für den Increase Multiplier-Button
        increaseMultiplierButton.addActionListener(e -> {
            double myCoins = player.getCoins();
            if (myCoins >= 10) {
                player.setMyCoins(myCoins - 10);
                double updatedMultiplier = player.increaseMultiplier();
                multiplierLabel.setText("Mult: " + updatedMultiplier);
                coinLabel.setText("Münzen: " + player.getCoins());
            }
        });

        // ActionListener für den Passive Income-Button
        passiveIncomeButton.addActionListener(e -> {
            double myCoins = player.getCoins();
            if (myCoins >= 10) {
                player.setMyCoins(myCoins - 10);
                double passiveIncome = player.incrementPassiveIncome();
                passiveIncomeLabel.setText("Passive Income: " + passiveIncome);
                coinLabel.setText("Münzen: " + player.getCoins());
            }
        });

        // Timer für passives Einkommen: alle 1000 Millisekunden wird passives Einkommen hinzugefügt
        Timer passiveIncomeTimer = new Timer(1000, e -> {
            double passiveIncome = player.getPassiveIncome(); // Gibt z. B. zurück, wie viele Münzen pro Sekunde gewonnen werden sollen
            // Erhöhe den aktuellen Münzzähler um den passiven Betrag
            double newCoins = player.getCoins() + passiveIncome;
            player.setMyCoins(newCoins);
            coinLabel.setText("Münzen: " + newCoins);
        });
        passiveIncomeTimer.start();


        frame.setVisible(true);
    }
}
