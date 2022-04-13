import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;

public class Brick extends Sprite
{

    private boolean destroyed;
    private int health;
    private boolean cement;
    private boolean containsItem;

    public Brick(int x, int y) throws IOException {

        initBrick(x, y);
    }

    private void initBrick(int x, int y) throws IOException {

        this.x = x;
        this.y = y;

        destroyed = false;
        cement = false;
        health = 1;

        //boolean for item drop bricks
        containsItem = false;

        loadImage(0);
        getImageDimensions();

        int random = (int) (Math.random() * 100) + 1;

        if (random > 50 && random <= 80) {
            health += 50;
        } else if (random > 80 && random <= 95) {
            health += 100;
        } else if (random > 95) {
            cement = true;
            loadImage(3);
            getImageDimensions();
        } else if (random < 10) {
            containsItem = true;
            loadImage(4);
        }
    }

    private void loadImage(int index) throws IOException {

        if (index == 0) {
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/brick.png")));
            image = ii.getImage();
        } else if (index == 1) {
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/brick_cracked_1.png")));
            image = ii.getImage();
        } else if (index == 2) {
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/brick_cracked_2.png")));
            image = ii.getImage();
        } else if (index == 3) {
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/cement.png")));
            image = ii.getImage();
        } else if (index == 4){
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/itemBrick.png")));
            image = ii.getImage();
        }else {
            System.out.println("Bad index passed to Brick loadImage");
        }

    }

    // 50% chance health = 0   (dies in one hit)
    // 30% change health = 50  (dies in two hits)
    // 15% chance health = 100 (dies in three hits)
    // 5% chance cement        (invincible)
    private int getHealth() {
        return health;
    }

    private void setHealth() {
        health -= 50;
    }

    boolean isCement() {
        return cement;
    }

    void doDamage() throws IOException {

        if (!isCement()) {
            setHealth();
            if (getHealth() <= 0) {
                destroyed = true;
            } else if (getHealth() == 1) {
                loadImage(2);
                getImageDimensions();
            } else if (getHealth() == 51) {
                loadImage(1);
                getImageDimensions();
            }
        }
    }

    boolean isDestroyed() {

        return destroyed;
    }

    boolean hasItem() {
        return containsItem;
    }

}
