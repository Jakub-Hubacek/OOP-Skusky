package canvas;

import java.awt.*;

public class Tree extends Shape{

    public Tree(int startX, int startY, Color color) {
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

        g2d.fillOval(this.getCenterX()-this.getWidth()/2, this.getCenterY()-this.getHeight()/2,this.getWidth(), (int) (this.getHeight() * 0.66));
        g2d.fillRect((this.getCenterX() + this.getWidth() / 3)-this.getWidth()/2, (this.getCenterY() + (int) (this.getHeight()* 0.63))-this.getHeight()/2, (this.getWidth() / 3),((int) (this.getHeight() * 0.33)));
        g2d.drawRect(this.getCenterX()-this.getWidth()/2,this.getCenterY()-this.getHeight()/2,this.getWidth(),this.getHeight());
    }

    @Override
    public void draw(Graphics g){
        g.fillOval(this.getCenterX()-this.getWidth()/2, this.getCenterY()-this.getHeight()/2,this.getWidth(), (int) (this.getHeight() * 0.66));
        g.fillRect((this.getCenterX() + this.getWidth() / 3)-this.getWidth()/2, (this.getCenterY() + (int) (this.getHeight()* 0.63))-this.getHeight()/2, (this.getWidth() / 3),((int) (this.getHeight() * 0.33)));
        g.drawRect(this.getCenterX()-this.getWidth()/2,this.getCenterY()-this.getHeight()/2,this.getWidth(),this.getHeight());
    }

}
