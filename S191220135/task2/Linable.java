package task2;

import task2.Line.Position;

public interface Linable {
    
    public void setPosition(Position position);

    public Position getPosition();

    public void swapPosition(Linable another);

    public int getValue();

}