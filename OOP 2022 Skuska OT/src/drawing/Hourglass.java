package drawing;

import java.awt.*;

public class Hourglass extends Shape{

    public Hourglass(int x, int y, int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        int xpoints1[] = {this.x - radius, this.x + radius, this.x};
        int ypoints1[] = {this.y - radius/2,this.y - radius/2,this.y};
        int ypoints2[] = {this.y + radius/2,this.y + radius/2,this.y};
        g2d.fillPolygon(xpoints1,ypoints1,3);
        g2d.fillPolygon(xpoints1,ypoints2,3);
    }
}
