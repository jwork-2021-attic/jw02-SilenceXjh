package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    
    public static void main(String[] args) throws IOException {
        RandomArray ra = new RandomArray(256);

        Monster[] monsters = new Monster[256];
        for(int i = 0; i < 256; ++i) {
            monsters[i] = new Monster(i+1);
        }

        Line line = new Line(256);
        for(int i = 0; i < 256; ++i) {
            line.put(monsters[i], ra.get(i)-1);
        }

        Snake snake = new Snake();

        Sorter sorter = new SelectSorter();
        //Sorter sorter = new QuickSorter();
        
        snake.setSorter(sorter);

        String log = snake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}