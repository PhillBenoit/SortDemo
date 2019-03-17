
public class QuickSort extends SortModule {

    public QuickSort(int size) {
        super(size);
    }

    @Override
    protected void populateA() {
        a = new int[10];
        a[0]=72; 
        a[1]=6;
        a[2]=57;
        a[3]=88;
        a[4]=85;
        a[5]=42;
        a[6]=83;
        a[7]=73;
        a[8]=48;
        a[9]=60;
    }

    @Override
    protected void verboseSort() {
        println(counter++);
        vQSort(0, a.length-1);
    }
    
    private int counter = 0;
    
    private void vQSort(int start_index, int end_index) {
        int middle_index = findMiddle(start_index, end_index);
        swap(middle_index, end_index, a[middle_index]);
        middle_index = partition(start_index-1, end_index, a[end_index]);
        swap(middle_index, end_index, a[middle_index]);
        if ( middle_index-start_index > 1) vQSort(start_index, middle_index-1);
        if ( end_index-middle_index > 1) vQSort(middle_index+1, end_index);
        println(counter++);
    }
    
    private void qSort(int start_index, int end_index) {
        int middle_index = findMiddle(start_index, end_index);
        swap(middle_index, end_index, a[middle_index]);
        middle_index = partition(start_index-1, end_index, a[end_index]);
        swap(middle_index, end_index, a[middle_index]);
        if ( middle_index-start_index > 1) qSort(start_index, middle_index-1);
        if ( end_index-middle_index > 1) qSort(middle_index+1, end_index);
    }
    
    private int partition(int start, int end, int value) {
        do {
            while (a[++start] < value);
            while (end > start && a[--end] > value);
            swap(start, end, a[start]);
        } while (start < end);
        return start;
    }
    
    private int findMiddle(int start, int end) {return (start + end) / 2;}

    @Override
    protected void runSort() {
        qSort(0, a.length-1);
    }

    public static void main(String[] args) {
        System.out.println("This is a verbose example of quick sort.");
        QuickSort test = new QuickSort(0);
        test.populateA();
        test.verboseSort();
    }

}
