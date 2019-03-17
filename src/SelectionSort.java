import java.util.LinkedList;

public class SelectionSort extends SortModule {

    public SelectionSort(int size) {
        super(size);
    }

    public static void main(String[] args) {
        System.out.println("This is a verbose example of selection sort.");
        SelectionSort test = new SelectionSort(0);
        test.populateA();
        test.verboseSort();
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
        LinkedList<Integer> least_list = new LinkedList<Integer>();
        int least = Integer.MAX_VALUE;
        int start_index = 0;
        while (start_index < a.length) {
            println(start_index);
            for (int cursor = start_index; cursor < a.length; cursor++) {
                int value = a[cursor];
                if ( value <= least) {
                    if (value == least) least_list.add(cursor);
                    else {
                        least_list.clear();
                        least_list.add(cursor);
                        least = value;
                    }
                }
            }
            for (Integer number:least_list)
                swap(number, start_index++, least);
            least = Integer.MAX_VALUE;
            least_list.clear();
        }
    }

    @Override
    protected void runSort() {
        LinkedList<Integer> least_list = new LinkedList<Integer>();
        int least = Integer.MAX_VALUE;
        int start_index = 0;
        while (start_index < a.length) {
            for (int cursor = start_index; cursor < a.length; cursor++) {
                int value = a[cursor];
                if ( value <= least) {
                    if (value == least) least_list.add(cursor);
                    else {
                        least_list.clear();
                        least_list.add(cursor);
                        least = value;
                    }
                }
            }
            for (Integer number:least_list)
                swap(number, start_index++, least);
            least = Integer.MAX_VALUE;
            least_list.clear();
        }
    }

}
