package canvas;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class Shape {
    @Setter@Getter
    private int startX;
    @Setter@Getter
    private int startY;
    @Setter@Getter
    private int endX;
    @Setter@Getter
    private int endY;
    @Getter
    private int width;
    @Getter
    private int height;
    @Setter@Getter
    private Color color;

    public void setNewCooridnates(int startX,int startY){
        this.startX = startX;
        this.startY = startY;
        this.endX = (startX+this.width);
        this.endY = (startY+this.height);
    }
    public void drawingCoorinates(int endX, int endY){
        this.endX = endX;
        this.endY = endY;
        this.calculateWidthAndHeight();
    }
    public void calculateWidthAndHeight(){
        this.width = this.endX - this.startX;
        this.height = this.endY - this.startY;
    }
    public void makeCoordinatesRight() {
        int minX = Math.min(this.startX, this.endX);
        int maxX = Math.max(this.startX, this.endX);
        int minY = Math.min(this.startY, this.endY);
        int maxY = Math.max(this.startY, this.endY);

        this.startX = minX;
        this.endX = maxX;
        this.startY = minY;
        this.endY = maxY;
    }

    public void draw(Graphics g) {
    }

}

