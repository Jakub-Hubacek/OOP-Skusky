package canvas;

import java.awt.*;

public class Cross extends Shape{

    public Cross(int startX, int startY, int endX, int endY, Color color) {
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(endX);
        this.setEndY(endY);
        this.setColor(color);
        this.calculateWidthAndHeight();
    }

    @Override
    public void draw(Graphics g){
        int width = Math.abs(this.getWidth());
        int height = Math.abs(this.getHeight());

        if (this.getStartX() < this.getEndX() && this.getStartY() < this.getEndY()){
            g.drawRect(this.getStartX(),this.getStartY(),width,height);
            g.fillRect(this.getStartX(),this.getStartY()+height/3,width,height/3);
            g.fillRect(this.getStartX() + width/3, this.getStartY(),width/3,height);
        }
        else if (this.getStartX() > this.getEndX() && this.getStartY() < this.getEndY()) {

            g.fillRect(this.getEndX(),this.getStartY() + height/3,width,height/3);
            g.fillRect(this.getEndX() - this.getWidth() * 2/3, this.getStartY(),this.getWidth()/3,this.getHeight());
            g.drawRect(this.getEndX(),this.getStartY(),width,height);
        }else if (this.getStartX() < this.getEndX() && this.getStartY() > this.getEndY()) {
            g.fillRect(this.getStartX()+ this.getWidth()/3,this.getStartY(),this.getWidth()/3,this.getHeight());
            g.fillRect(this.getStartX(),this.getStartY()+this.getHeight()/3,this.getWidth(),this.getHeight()/3);
            g.drawRect(this.getStartX(),this.getEndY(),width,height);
        }else{
            g.fillRect(this.getEndX(),this.getEndY()+height/3,width,height/3);
            g.fillRect(this.getEndX() - this.getWidth() *2/3, this.getStartY(),this.getWidth()/3,this.getHeight());
            g.drawRect(this.getEndX(),this.getEndY(),width,height);
        }


    }
}
