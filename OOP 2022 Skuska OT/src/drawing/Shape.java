package drawing;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Shape {
    @Getter
    protected int x;
    @Getter
    protected int y;
    @Setter
    protected int radius;
    @Setter
    protected Color color;

    public void draw(Graphics g){
    }
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}
