import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;

public class Brick extends Sprite
{

    private boolean destroyed;

    public Brick(int x, int y) throws IOException {

        initBrick(x, y);
    }

    private void initBrick(int x, int y) throws IOException {

        this.x = x;
        this.y = y;

        destroyed = false;

        loadImage();
        getImageDimensions();
    }

    private void loadImage() throws IOException {

        var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/brick.png")));
        image = ii.getImage();
    }

    boolean isDestroyed() {

        return destroyed;
    }

    void setDestroyed(boolean val) {

        destroyed = val;
    }
}
