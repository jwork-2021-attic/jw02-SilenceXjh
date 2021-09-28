package task3;

public class Snake {

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
    
    public String lineUp(Square square) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = square.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step, square);
            System.out.println(square.toString());
            log += square.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Square square) {
        String[] couple = step.split("<->");
        int i1 = Integer.parseInt(couple[0]);
        int i2 = Integer.parseInt(couple[1]);
        int x1 = i1 / square.getCols();
        int y1 = i1 % square.getCols();
        int x2 = i2 / square.getCols();
        int y2 = i2 % square.getCols();
        square.get(x1).get(y1).swapPosition(square.get(x2).get(y2));
    }
}