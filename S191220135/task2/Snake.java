package task2;

public class Snake {

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
    
    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step, line);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Line line) {
        String[] couple = step.split("<->");
        int i1 = Integer.parseInt(couple[0]);
        int i2 = Integer.parseInt(couple[1]);
        line.get(i1).swapPosition(line.get(i2));
    }
}