import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Sprite {

//    int x;
//    int y;
    double x;
    double y;
    int imageWidth;
    int imageHeight;
    Image image;
    Rectangle2D rectangle2D = new Rectangle2D.Double();

    protected void setX(double x) {

        this.x = x;
    }

    double getX() {

        return x;
    }

    protected void setY(double y) {

        this.y = y;
    }

    double getY() {

        return y;
    }

    int getImageWidth() {

        return imageWidth;
    }

    int getImageHeight() {

        return imageHeight;
    }

    Image getImage() {

        return image;
    }

    Rectangle2D getRect() {
        rectangle2D.setRect(x, y, image.getWidth(null), image.getHeight(null));

        return rectangle2D;
//        return new Rectangle(x, y,
//                image.getWidth(null), image.getHeight(null));
    }

    void getImageDimensions() {

        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }
}