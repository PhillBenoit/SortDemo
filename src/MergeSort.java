
public class MergeSort extends SortModule {

    private int[] b;
    
    public MergeSort(int size) {
        super(size);
    }

    @Override
    protected void populateA() {
        a = new int[8];
        a[0]=36;
        a[1]=20;
        a[2]=17;
        a[3]=13;
        a[4]=28;
        a[5]=14;
        a[6]=23;
        a[7]=15;
    }

    @Override
    protected void verboseSort() {
        b = new int[a.length];
        println(counter++);
        vRecursiveStep(0, a.length-1);
        b = null;
    }
    
    private int counter = 0;
    
    private void vRecursiveStep(int start_index, int end_index) {
        if (start_index == end_index) return;
        int middle = (start_index + end_index) / 2;
        vRecursiveStep(start_index, middle++);
        vRecursiveStep(middle, end_index);
        for (int step = start_index; step <= end_index; step++)
            b[step] = a[step];
        int list1_cursor = start_index, list2_cursor = middle;
        int destination_cursor = start_index;
        while (list1_cursor < middle && list2_cursor <= end_index) {
            if (b[list2_cursor] < b[list1_cursor])
                a[destination_cursor++] = b[list2_cursor++];
            else a[destination_cursor++] = b[list1_cursor++];
        }
        int source_cursor;
        if (list1_cursor == middle) source_cursor = list2_cursor;
        else source_cursor = list1_cursor;
        for (; destination_cursor <= end_index; destination_cursor++)
            a[destination_cursor] = b[source_cursor++];
        println(counter++);
    }

    @Override
    protected void runSort() {
        b = new int[a.length];
        recursiveStep(0, a.length-1);
        b = null;
    }
    
    private void recursiveStep(int start_index, int end_index) {
        if (start_index == end_index) return;
        int middle = (start_index + end_index) / 2;
        recursiveStep(start_index, middle++);
        recursiveStep(middle, end_index);
        for (int step = start_index; step <= end_index; step++)
            b[step] = a[step];
        int list1_cursor = start_index, list2_cursor = middle;
        int destination_cursor = start_index;
        while (list1_cursor < middle && list2_cursor <= end_index) {
            if (b[list2_cursor] < b[list1_cursor])
                a[destination_cursor++] = b[list2_cursor++];
            else a[destination_cursor++] = b[list1_cursor++];
        }
        int source_cursor;
        if (list1_cursor == middle) source_cursor = list2_cursor;
        else source_cursor = list1_cursor;
        for (; destination_cursor <= end_index; destination_cursor++)
            a[destination_cursor] = b[source_cursor++];
    }

    public static void main(String[] args) {
        System.out.println("This is a verbose example of merge sort.");
        MergeSort test = new MergeSort(0);
        test.populateA();
        test.verboseSort();
    }

}
