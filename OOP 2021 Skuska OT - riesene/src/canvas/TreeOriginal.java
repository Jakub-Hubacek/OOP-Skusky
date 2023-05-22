package canvas;

import lombok.Getter;

import java.awt.*;

public class TreeOriginal {

    @Getter
    private int startX;
    @Getter

    private int startY;
    private int width;
    private int height;
    @Getter
    private Color color;
    public TreeOriginal(int startX, int startY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.calculateWidthAndHeight();
        this.color = color;
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

        g2d.fillOval(startX-width/2, startY-height/2, width, (int) (height * 0.66));
        g2d.fillRect((startX + width / 3)-width/2, (startY + (int) (height * 0.63))-height/2, (width / 3),((int) (height * 0.33)));
        g2d.drawRect(startX-width/2,startY-height/2,width,height);
    }

    private void calculateWidthAndHeight(){
        this.width = 50;
        this.height = 50;
    }
    public void draw(Graphics g) {
        g.fillOval(startX-width/2, startY-height/2, width, (int) (height * 0.66));
        g.fillRect((startX + width / 3)-width/2, (startY + (int) (height * 0.63))-height/2, (width / 3),((int) (height * 0.33)));
        g.drawRect(startX-width/2,startY-height/2,width,height);
    }

}
