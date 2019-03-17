import java.util.LinkedList;

/**
 * Selection sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class SelectionSort extends SortModule {

    @Override
    /**
     * sorting algorithm
     */
    protected void runSort() {
        
        //list used to store indices of similar values
        LinkedList<Integer> least_list = new LinkedList<Integer>();
        
        //lowest value found in a loop iteration
        //set to max so the first number is always lower
        int least = Integer.MAX_VALUE;
        
        //start from 0
        //counts up when a lowest value is swapped
        int start_index = 0;
        
        //loops through whole array
        while (start_index < a.length) {
            
            //cursor starts from first unsorted index
            for (int cursor = start_index; cursor < a.length; cursor++) {
                
                //store value of cursor location
                int value = a[cursor];
                
                //compare value
                if ( value <= least) {
                    
                    //if it equals lowest, add index to the list
                    if (value == least) least_list.add(cursor);
                    
                    //if it is the lowest, store value and index
                    else {
                        least_list.clear();
                        least_list.add(cursor);
                        least = value;
                    }
                }
            }
            
            //swap all values that are the lowest
            //while incrementing the start index
            for (Integer number:least_list)
                swap(number, start_index++, least);
            
            //set compare value for next loop iteration
            least = Integer.MAX_VALUE;
        }
    }

    /**
     * Constructor
     * @param size size of the array to sort
     */
    public SelectionSort(int size) {
        super(size);
        name = "Selection";
    }

    @Override
    /**
     * Populates the array with the example from the book
     */
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
    /**
     * verbose option that prints each step
     */
    protected void verboseSort() {
        LinkedList<Integer> least_list = new LinkedList<Integer>();
        int least = Integer.MAX_VALUE;
        int start_index = 0;
        while (start_index < a.length) {
            
            //print option
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
        }
    }

    /**
     * Allows class to be run by itself
     * Uses verbose method and examples from the book:
     * https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("This is a verbose example of selection sort.");
        SelectionSort test = new SelectionSort(0);
        test.populateA();
        test.verboseSort();
    }

}
