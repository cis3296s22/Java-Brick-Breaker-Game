import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Racket extends Sprite  {

    private int dx;

    public Racket(int racket) throws IOException {

        initRacket(racket);
    }

    private void initRacket(int racket) throws IOException {

        loadImage(racket);
        getImageDimensions();

        resetState();
    }

    private void loadImage(int racket) throws IOException {

        ImageIcon ii;
        if (racket == 1) {
            ii = new ImageIcon(ImageIO.read(Racket.class.getResource("/images/longPaddle.png")));
        } else if(racket == 2) {
            ii = new ImageIcon(ImageIO.read(Racket.class.getResource("/images/shortPaddle.png")));
        } else {
            ii = new ImageIcon(ImageIO.read(Racket.class.getResource("/images/paddle.png")));
        }
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

    void keyPressed(KeyEvent e, int select) {
        int key = e.getKeyCode();
        if (select == 0){
            if (key == KeyEvent.VK_LEFT) {

                dx = -2;
            }

            if (key == KeyEvent.VK_RIGHT) {

                dx = 2;
            }
        }else {
            if (key == KeyEvent.VK_A) {

                dx = -2;
            }

            if (key == KeyEvent.VK_D) {

                dx = 2;
            }
        }
    }

    void keyReleased(KeyEvent e, int select) {

        int key = e.getKeyCode();
        if(select == 0) {
            if (key == KeyEvent.VK_LEFT) {

                dx = 0;
            }

            if (key == KeyEvent.VK_RIGHT) {

                dx = 0;
            }
        }else{
            if (key == KeyEvent.VK_A) {

                dx = 0;
            }

            if (key == KeyEvent.VK_D) {

                dx = 0;
            }
        }
    }

    private void resetState() {

        x = Configurations.INIT_PADDLE_X;
        y = Configurations.INIT_PADDLE_Y;
    }
}