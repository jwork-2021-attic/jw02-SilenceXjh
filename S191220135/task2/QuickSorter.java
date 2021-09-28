package task2;

public class QuickSorter implements Sorter {
    
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
        sort(0, a.length-1);
    }

    private int partition(int l, int r) {
        int pivot = a[r];
        int i = l-1;
        for(int j = l; j < r; ++j) {
            if(a[j] < pivot) {
                i++;
                if(i != j) {
                    swap(i, j);
                }
            }
        }
        if(i != r-1) {
            swap(i+1, r);
        }
        return i+1;
    }

    private void sort(int l, int r) {
        if(l < r) {
            int q = partition(l, r);
            sort(l, q-1);
            sort(q+1, r);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}