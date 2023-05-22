package canvas;

import lombok.Getter;

import java.awt.*;

public class HouseOriginal {

    @Getter

    private int startX;
    @Getter

    private int startY;
    private int width;
    private int height;

    @Getter
    private Color color;

    public HouseOriginal(int startX, int startY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.calculateWidthAndHeight();
        this.color = color;
    }
    private void calculateWidthAndHeight(){
        this.width = 50;
        this.height = 50;
    }
    public void setNewCoordinates(int x,int y){
        this.startX=x;
        this.startY=y;
    }
    public void drawOutline(Graphics g){
        Graphics2D g2d = (Graphics2D) g;


        float transparency = 0.5f;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
        g2d.setComposite(alphaComposite);

        int triangleX = startX - (int)(width * 0.26);
        int triangleY = startY -height/2 ;
        int triangleWidth = width / 2;
        int triangleHeight = height / 2;

        int[] xPoints = {triangleX, triangleX + triangleWidth / 2, triangleX + triangleWidth};
        int[] yPoints = {triangleY + triangleHeight, triangleY, triangleY + triangleHeight};
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.fillRect(startX + width/4 -width/2,startY+height/2 -height/2,width/2,height/2);
        g2d.drawRect(startX-width/2,startY-height/2,width,height);
    }
    public void draw(Graphics g) {
        int triangleX = startX - (int)(width * 0.26);
        int triangleY = startY -height/2 ;
        int triangleWidth = width / 2;
        int triangleHeight = height / 2;

        // Draw the triangle
        int[] xPoints = {triangleX, triangleX + triangleWidth / 2, triangleX + triangleWidth};
        int[] yPoints = {triangleY + triangleHeight, triangleY, triangleY + triangleHeight};
        g.fillPolygon(xPoints, yPoints, 3);
        g.fillRect(startX + width/4 -width/2,startY+height/2 -height/2,width/2,height/2);
        g.drawRect(startX-width/2,startY-height/2,width,height);
    }

}
