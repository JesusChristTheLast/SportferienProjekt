import game_logic.game_logic;
import view.View;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            View mainFrame = new View();
            mainFrame.createAndShowGUI();
        });


    }
}