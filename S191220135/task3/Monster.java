package task3;

import task3.Line.Position;

public class Monster implements Linable {
    private final int index;
    private final int r;
    private final int g;
    private final int b;

    private Position position;

    public Monster(int i) {
        index = i;
        if(i <= 43) {
            r = 252;
            g = (i - 1) * 6;
            b = 0;
        }
        else if(i <= 85) {
            r = 510 - 6 * i;
            g = 252;
            b = 0;
        }
        else if(i <= 127) {
            r = 0;
            g = 252;
            b = (i - 85) * 6;
        }
        else if(i <= 169) {
            r = 0;
            g = 1014 - 6 * i;
            b = 252;
        }
        else if(i <= 211) {
            r = (i - 169) * 6;
            g = 0;
            b = 252;
        }
        else {
            r = 252;
            g = (i - 211) * 5;
            b = 252;
        }
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void swapPosition(Linable another) {
        Position p = another.getPosition();
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return index;
    }

    @Override
    public String toString() {
        if(index < 10) {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m     " + index + "   \033[0m";
        }
        else if(index < 100) {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + index + "   \033[0m";
        }
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + index + "  \033[0m";
    }

}