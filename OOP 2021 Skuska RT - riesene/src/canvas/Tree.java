package canvas;

import lombok.Getter;


import java.awt.*;

public class Tree {

    @Getter

    private int startX;
    @Getter

    private int startY;
    @Getter
    private int endX;
    @Getter
    private int endY;
    private int width;
    private int height;
    @Getter
    private Color color;
    public Tree(int startX, int startY, int endX, int endY,Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.calculateWidthAndHeight();
        this.color = color;
    }

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

    private void calculateWidthAndHeight(){
        this.width = this.endX - this.startX;
        this.height = this.endY - this.startY;
    }
    public void makeCoordinatesRight(){
        if (this.startX > this.endX){
            int holder = this.startX;
            this.startX = this.endX;
            this.endX = holder;
        }
        if (this.startY > this.endY){
            int holder = this.startY;
            this.startY = this.endY;
            this.endY = holder;

        }
    }
    public void draw(Graphics g) {
        int width = Math.abs(this.endX - this.startX);
        int height = Math.abs(this.endY - this.startY);
        if (startX < endX && startY < endY) {
            g.fillOval(startX, startY, width, (int) (height * 0.66));
            g.fillRect((startX + width / 3), (startY + (int) (height * 0.63)), (width / 3),((int) (height * 0.33)));
            g.drawRect(startX,startY,width,height);
        }else if (startX > endX && startY < endY) {
            g.fillOval(endX, startY, width, (int) (height * 0.66)); // Adjust the oval drawing
            g.fillRect((endX + width * 1/3), startY + (int) (height * 0.63), width / 3, (int) (height * 0.33)); // Adjust the rect drawing
            g.drawRect(endX,startY,width,height);
        }else if (startX < endX && startY > endY) {
            g.fillOval(startX,endY, width, (int) (height * 0.68)); // Adjust the oval drawing
            g.fillRect(startX + width/3, endY + height * 2/3, width / 3, (int) (height * 0.33)); // Adjust the rect drawing
            g.drawRect(startX,endY,width,height);
        }
        else {
            g.fillRect(endX + width/3, endY + height * 2/3, width / 3, (int) (height * 0.33)); // Adjust the rect drawing
            g.fillOval(endX,endY, width, (int) (height * 0.68)); // Adjust the oval drawing
            g.drawRect(endX,endY,width,height);
        }


    }

}
