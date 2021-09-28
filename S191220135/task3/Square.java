package task3;

public class Square {
    
    private Line[] lines;
    private int cols;

    public Square(int size, int length) {
        this.lines = new Line[size];
        for(int i = 0; i < size; ++i) {
            lines[i] = new Line(length);
        }
        this.cols = length;
    }

    public Line get(int i) {
        if(i < 0 || i >= lines.length) {
            return null;
        }
        return lines[i];
    }

    public int getCols() {
        return cols;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[cols * lines.length];
        for(int i = 0; i < lines.length; ++i) {
            Linable[] tmp = lines[i].toArray();
            for(int j = 0; j < tmp.length; ++j) {
                linables[i*cols+j] = tmp[j];
            }
        }
        return linables;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < lines.length; ++i) {
            res += lines[i].toString();
            res += "\n";
        }
        return res;
    }

}