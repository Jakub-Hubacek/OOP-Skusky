package canvas;

import java.awt.*;

public class Route extends Shape{
    private int endX;
    private int endY;

    private int thickness;

    public Route(int x, int y, int endX, int endY,Color color) {
        this.setCoordinates(x,y);
        this.endX = endX;
        this.endY = endY;
        this.thickness = 5;
        this.color = color;

    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(this.color);
        g2d.drawLine(x,y,endX,endY);
    }
}
