/**
 * Bubble sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class BubbleSort extends SortModule {

    @Override
    /**
     * sorting algorithm
     */
    protected void runSort() {
        
        //last index is calculated and stored because it is used so much
        int last_index = a.length-1;
        
        //for each element in the array (increasing)
        for (int step = 0; step < last_index; step++)
            
            //bubble up from the bottom until the index from the step is reached
            for (int bubble = last_index; bubble > step; bubble--)
                
                //swap if lowest number is first
                //will always move the lowest number found to the step position
                if (a[bubble] < a[bubble-1])
                    swap(bubble, bubble-1, a[bubble]);
    }

    /**
     * Constructor
     * @param size size of the array to sort
     */
    public BubbleSort(int size) {
        super(size);
        name = "Bubble";
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
        int last_index = a.length-1;
        for (int step = 0; step < last_index; step++) {
            
            //print option
            println(step);
            
            for (int sub_step = last_index; sub_step > step; sub_step--)
                if (a[sub_step] < a[sub_step-1])
                    swap(sub_step, sub_step-1, a[sub_step]);
        }

        //print option
        println(7);
    }

    /**
     * Allows class to be run by itself
     * Uses verbose method and examples from the book:
     * https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("This is a verbose example of bubble sort.");
        BubbleSort test = new BubbleSort(0);
        test.populateA();
        test.verboseSort();
    }

}
