/**
 * Quick sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class QuickSort extends SortModule {

    @Override
    /**
     * entry point for recursive sorting algorithm
     */
    protected void runSort() {
        qSort(0, a.length-1);
    }

    /**
     * Recursive sorting algorithm
     * 
     * @param start_index first index to examine
     * @param end_index last index to examine
     */
    private void qSort(int start_index, int end_index) {
        
        //find middle element
        int middle_index = findMiddle(start_index, end_index);
        
        //move middle element to the end
        swap(middle_index, end_index, a[middle_index]);
        
        //Shuffle array using the middle element's value.
        //partition() moves elements before and after the middle element.
        //Out of bounds indices are passed to satisfy pre-increment loops.
        //New location of middle value is returned.
        middle_index = partition(start_index-1, end_index, a[end_index]);
        
        //move element to the new location
        swap(middle_index, end_index, a[middle_index]);
        
        //recursive call to all elements before the middle 
        if ( middle_index-start_index > 1) qSort(start_index, middle_index-1);

        //recursive call to all elements after the middle 
        if ( end_index-middle_index > 1) qSort(middle_index+1, end_index);
    }
    
    /**
     * Calculates the midpoint between two endpoints
     * 
     * @param start first index
     * @param end last index
     * @return middle index
     */
    private int findMiddle(int start, int end) {return (start + end) / 2;}

    /**
     * Constructor
     * @param size size of the array to sort
     */
    public QuickSort(int size) {
        super(size);
        name = "Quick";
    }

    @Override
    /**
     * Populates the array with the example from the book
     */
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

    /**
     * Shuffles elements so that 
     * 
     * @param start first index
     * @param end last index
     * @param value middle value
     * @return index of middle value
     */
    private int partition(int start, int end, int value) {
        do {

            //find larger element before middle by
            //stepping forward from the beginning
            while (a[++start] < value);
            
            //find smaller element after middle by
            //stepping backwards from the end
            //(also stops when start and end indices match)
            while (end > start && a[--end] > value);
            
            //swap them
            //(last swap will always be a swap to itself)
            swap(start, end, a[start]);
        
        //do this until the start and end indices match
        } while (start < end);
        
        //return new midpoint location
        return start;
    }
    
    /**
     * counter for verbose option steps
     */
    private int counter = 0;
    
    @Override
    /**
     * verbose option that prints each step
     */
    protected void verboseSort() {
        println(counter++);
        vQSort(0, a.length-1);
    }
    
    /**
     * Replacement for the recursive call to allow for printing each step
     * 
     * @param start_index first index to examine
     * @param end_index last index to examine
     */
    private void vQSort(int start_index, int end_index) {
        int middle_index = findMiddle(start_index, end_index);
        swap(middle_index, end_index, a[middle_index]);
        middle_index = partition(start_index-1, end_index, a[end_index]);
        swap(middle_index, end_index, a[middle_index]);
        if ( middle_index-start_index > 1) vQSort(start_index, middle_index-1);
        if ( end_index-middle_index > 1) vQSort(middle_index+1, end_index);
        
        //print option
        System.out.printf("\nMiddle value: [%d]\n", a[middle_index]);
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
        System.out.println("This is a verbose example of quick sort.");
        QuickSort test = new QuickSort(0);
        test.populateA();
        test.verboseSort();
    }

}
