package canvas;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class Shape{
    @Getter
    private int centerX;
    @Getter

    private int centerY;
    @Getter
    private int width;
    @Getter
    private int height;
    @Getter@Setter
    private Color color;

    public void calculateWidthAndHeight(){
        this.width = 50;
        this.height = 50;
    }

    public void drawOutline(Graphics g){}

    public void draw(Graphics g) {}

    public void setNewCoordinates(int x,int y){
        this.centerX =x;
        this.centerY =y;
    }

    public boolean areCoordinatesInside(int x, int y){
        if(x > this.centerX -this.width/2 && x < this.centerX +width/2 && y > this.centerY - this.height/2 && y < this.centerY + this.height/2 ){
            return true;
        }
        else return false;
    }


}
