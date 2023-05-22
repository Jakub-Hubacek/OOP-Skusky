package drawing;

import java.awt.*;

public class Square extends Shape {

    public Square(int x,int y,int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x - this.radius/2, this.y-this.radius/2,this.radius,this.radius);
    }

}
