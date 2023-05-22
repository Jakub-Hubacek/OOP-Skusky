package drawing;

import java.awt.*;

public class Circle extends Shape{

    public Circle(int x,int y,int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(this.color);
        g.fillOval(this.x-radius/2,this.y -radius/2,this.radius,this.radius);
    }
}
