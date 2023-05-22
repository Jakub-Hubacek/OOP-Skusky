package canvas;

import java.awt.*;

public class House extends Shape{
    public House(int startX, int startY, Color color) {
        setNewCoordinates(startX,startY);
        this.calculateWidthAndHeight();
        this.setColor(color);
    }
    @Override
    public void drawOutline(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        float transparency = 0.5f;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
        g2d.setComposite(alphaComposite);

        int triangleX = this.getCenterX() - (int)(this.getWidth() * 0.26);
        int triangleY = this.getCenterY() -this.getHeight()/2 ;
        int triangleWidth = this.getWidth() / 2;
        int triangleHeight = this.getHeight() / 2;

        int[] xPoints = {triangleX, triangleX + triangleWidth / 2, triangleX + triangleWidth};
        int[] yPoints = {triangleY + triangleHeight, triangleY, triangleY + triangleHeight};
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.fillRect(this.getCenterX() + this.getWidth()/4 -this.getWidth()/2,this.getCenterY()+this.getHeight()/2 -this.getHeight()/2,this.getWidth()/2,this.getHeight()/2);
        g2d.drawRect(this.getCenterX()-this.getWidth()/2,this.getCenterY()-this.getHeight()/2,this.getWidth(),this.getHeight());
    }

    @Override
    public void draw(Graphics g) {
        int triangleX = this.getCenterX() - (int)(this.getWidth() * 0.26);
        int triangleY = this.getCenterY() -this.getHeight()/2 ;
        int triangleWidth = this.getWidth() / 2;
        int triangleHeight = this.getHeight() / 2;

        int[] xPoints = {triangleX, triangleX + triangleWidth / 2, triangleX + triangleWidth};
        int[] yPoints = {triangleY + triangleHeight, triangleY, triangleY + triangleHeight};
        g.fillPolygon(xPoints, yPoints, 3);
        g.fillRect(this.getCenterX() + this.getWidth()/4 -this.getWidth()/2,this.getCenterY()+this.getHeight()/2 -this.getHeight()/2,this.getWidth()/2,this.getHeight()/2);
        g.drawRect(this.getCenterX()-this.getWidth()/2,this.getCenterY()-this.getHeight()/2,this.getWidth(),this.getHeight());
    }

}
