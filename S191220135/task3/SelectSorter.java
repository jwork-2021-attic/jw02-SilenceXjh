package task3;

public class SelectSorter implements Sorter {
    
    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + i + "<->" + j + "\n";
    }

    @Override
    public void sort() {
        for(int i = a.length-1; i >= 1; --i) {
            int m = 0;
            for(int j = 1; j <= i; ++j) {
                if(a[j] > a[m]) {
                    m = j;
                }
            }
            if(m != i) {
                swap(m, i);
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}