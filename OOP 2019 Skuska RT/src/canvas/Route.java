package canvas;

import java.awt.*;

public class Route extends Shape{


    public Route(int startX, int startY, int endX, int endY, Color color) {
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(endX);
        this.setEndY(endY);
        this.setColor(color);
        this.calculateWidthAndHeight();
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int thickness = 5;
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(this.getStartX(), this.getStartY(), this.getEndX(), this.getEndY());
    }

}
