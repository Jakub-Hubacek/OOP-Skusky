package drawing;

import lombok.Getter;

public class Cooridnates {
    @Getter
    private int x;
    @Getter
    private int y;

    public Cooridnates(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
