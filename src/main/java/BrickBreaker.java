import javax.swing.*;
import java.awt.EventQueue;
import java.io.IOException;

public class BrickBreaker extends JFrame {

    public BrickBreaker() throws IOException {

        initUI();
    }

    private void initUI() throws IOException {

        add(new MenuScreen());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            BrickBreaker game = null;
            try {
                game = new BrickBreaker();
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.setVisible(true);
        });
    }
}