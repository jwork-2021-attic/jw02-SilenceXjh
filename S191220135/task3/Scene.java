package task3;

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

        Square square = new Square(16, 16);
        for(int i = 0; i < 256; ++i) {
            int x = (ra.get(i)-1) / 16;
            int y = (ra.get(i)-1) % 16;
            square.get(x).put(monsters[i], y);
        }

        Snake snake = new Snake();

        Sorter sorter = new SelectSorter();
        //Sorter sorter = new QuickSorter();
        
        snake.setSorter(sorter);

        String log = snake.lineUp(square);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}