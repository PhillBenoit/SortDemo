/**
 * Merge sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class MergeSort extends SortModule {

    /**
     * temp array used for swap space
     */
    private int[] b;
    
    @Override
    /**
     * call to recursive sorting algorithm
     */
    protected void runSort() {
        
        //set up temp array
        b = new int[a.length];
        
        recursiveStep(0, a.length-1);
        
        //destroy temp array
        b = null;
    }
    
    /**
     * Recursive sorting algorithm
     * 
     * @param start_index first index to examine
     * @param end_index last index to examine
     */
    private void recursiveStep(int start_index, int end_index) {
        
        //base case
        if (start_index == end_index) return;
        
        //find middle and split the list
        int middle = (start_index + end_index) / 2;
        recursiveStep(start_index, middle++);
        recursiveStep(middle, end_index);
        
        //starts after all lists are size 1
        
        //copy lists into temp array
        for (int step = start_index; step <= end_index; step++)
            b[step] = a[step];
        
        //cursors for both lists
        int list1_cursor = start_index,
                list2_cursor = middle;
        
        //cursor for a[]
        int destination_cursor = start_index;
        
        //run until one list is empty
        while (list1_cursor < middle && list2_cursor <= end_index) {
            
            //copy lowest value from either cursor position
            //and increment cursor for whichever was copied.
            if (b[list2_cursor] < b[list1_cursor])
                a[destination_cursor++] = b[list2_cursor++];
            else a[destination_cursor++] = b[list1_cursor++];
        }
        
        //cursor for remaining list
        int source_cursor;
        
        //find unfinished list
        if (list1_cursor == middle) source_cursor = list2_cursor;
        else source_cursor = list1_cursor;
        
        //copy all values from unfinished list
        for (; destination_cursor <= end_index; destination_cursor++)
            a[destination_cursor] = b[source_cursor++];
    }

    /**
     * Constructor
     * @param size size of the array to sort
     */
    public MergeSort(int size) {
        super(size);
        name = "Merge";
    }

    @Override
    /**
     * Populates the array with the example from the book
     */
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

    /**
     * counter for steps
     */
    private int counter = 0;
    
    @Override
    /**
     * calls verbose option that prints each step
     */
    protected void verboseSort() {
        b = new int[a.length];
        println(counter++);
        vRecursiveStep(0, a.length-1);
        b = null;
    }
    
    /**
     * Verbose option of recursive sorting algorithm
     * 
     * @param start_index first index to examine
     * @param end_index last index to examine
     */
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

    /**
     * Allows class to be run by itself
     * Uses verbose method and examples from the book:
     * https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("This is a verbose example of merge sort.");
        MergeSort test = new MergeSort(0);
        test.populateA();
        test.verboseSort();
    }

}
