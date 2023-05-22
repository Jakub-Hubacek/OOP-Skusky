package canvas;

import lombok.Getter;

import java.awt.*;

public abstract class Shape {
    @Getter
    protected int x;
    @Getter
    protected int y;
    protected Color color;

    public void draw(Graphics g) {}

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    };

}
