import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;

public class Ball extends Sprite {

    private int xdir;
    private int ydir;

    public Ball() throws IOException {

        initBall();
    }

    private void initBall() throws IOException {

        xdir = 1;
        ydir = -1;

        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() throws IOException {

        var ii = new ImageIcon(ImageIO.read(Ball.class.getResource("/images/ball.png")));
        image = ii.getImage();
    }

    void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {

            setXDir(1);
        }

        if (x == Configurations.WIDTH - imageWidth) {

            System.out.println(imageWidth);
            setXDir(-1);
        }

        if (y == 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = Configurations.INIT_BALL_X;
        y = Configurations.INIT_BALL_Y;
    }

    void setXDir(int x) {

        xdir = x;
    }

    void setYDir(int y) {

        ydir = y;
    }

    int getYDir() {

        return ydir;
    }
}