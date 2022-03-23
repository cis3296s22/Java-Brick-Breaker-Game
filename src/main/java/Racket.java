import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Racket extends Sprite  {

    private int dx;

    public Racket() throws IOException {

        initRacket();
    }

    private void initRacket() throws IOException {

        loadImage();
        getImageDimensions();

        resetState();
    }

    private void loadImage() throws IOException {

        var ii = new ImageIcon(ImageIO.read(Racket.class.getResource("/images/paddle.png")));
        image = ii.getImage();
    }

    void move() {

        x += dx;

        if (x <= 0) {

            x = 0;
        }

        if (x >= Configurations.WIDTH - imageWidth) {

            x = Configurations.WIDTH - imageWidth;
        }
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 1;
        }
    }

    void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

    private void resetState() {

        x = Configurations.INIT_PADDLE_X;
        y = Configurations.INIT_PADDLE_Y;
    }
}