
public class BubbleSort extends SortModule {

    public BubbleSort(int size) {
        super(size);
    }

    @Override
    protected void populateA() {
        a = new int [8];
        a[0] = 42;
        a[1] = 20;
        a[2] = 17;
        a[3] = 13;
        a[4] = 28;
        a[5] = 14;
        a[6] = 23;
        a[7] = 15;
    }

    @Override
    protected void verboseSort() {
        int last_index = a.length-1;
        for (int step = 0; step < last_index; step++) {
            println(step);
            for (int sub_step = last_index; sub_step > step; sub_step--)
                if (a[sub_step] < a[sub_step-1])
                    swap(sub_step, sub_step-1, a[sub_step]);
        }
        println(7);
    }

    @Override
    protected void runSort() {
        int last_index = a.length-1;
        for (int step = 0; step < last_index; step++)
            for (int sub_step = last_index; sub_step > step; sub_step--)
                if (a[sub_step] < a[sub_step-1])
                    swap(sub_step, sub_step-1, a[sub_step]);
    }

    public static void main(String[] args) {
        System.out.println("This is a verbose example of bubble sort.");
        BubbleSort test = new BubbleSort(0);
        test.populateA();
        test.verboseSort();
    }

}
