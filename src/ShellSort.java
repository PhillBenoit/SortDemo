/**
 * Shell sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class ShellSort extends SortModule {

    @Override
    /**
     * sorting algorithm
     */
    protected void runSort() {
        
        //special subdivision size discussed in class
        int step = a.length/2;
        while ( step%3 != 1) step--;
        
        //decrease subdivision size until less than divisor
        for (; step > 3; step/=3)
            
            //sort subdivided arrays
            for (int start_index = 0; start_index < step; start_index++)
                inserstionStep(start_index, step);
        
        //run insertion sort on entire array
        inserstionStep(0, 1);
    }
    
    /**
     * Insertion sort step for shell sort algorithm
     * 
     * @param start first index
     * @param step_increment number of indices to skip to create virtual subset
     */
    private void inserstionStep(int start, int step_increment) {
        
        //previous index stored to prevent need to recalculate
        int previous_index = start;
        
        //run through list using steps of subdivision size
        for (int step = start+step_increment; step < a.length;
                step+=step_increment) {
            
            //store value and index
            int cursor_value = a[step];
            int cursor_index = step;
            
            //shift elements down until cursor is less than the value before it
            while (previous_index > -1 && a[previous_index] > cursor_value) {
                a[cursor_index] = a[previous_index];
                cursor_index = previous_index;
                previous_index -= step_increment;
            }
            
            //assign cursor to new location
            a[cursor_index] = cursor_value;
            
            //assign previous index for next loop iteration
            previous_index = step;
        }
    }

    /**
     * Constructor
     * @param size size of the array to sort
     */
    public ShellSort(int size) {
        super(size);
        name = "Shell";
    }

    @Override
    /**
     * Populates the array with the example from the book
     */
    protected void populateA() {
        a = new int[16];
        a[0]  = 59;
        a[1]  = 20;
        a[2]  = 17;
        a[3]  = 13;
        a[4]  = 28;
        a[5]  = 14;
        a[6]  = 23;
        a[7]  = 83;
        a[8]  = 36;
        a[9]  = 98;
        a[10] = 11;
        a[11] = 70;
        a[12] = 65;
        a[13] = 41;
        a[14] = 42;
        a[15] = 15;
    }

    @Override
    /**
     * verbose option that prints each step
     */
    protected void verboseSort() {
        
        //counter for steps
        int counter = 0;
        
        for (int step = a.length/2; step > 2; step/=2) {
            
            //print option
            println(counter++);
            
            for (int sub_step = 0; sub_step < step; sub_step++)
                inserstionStep(sub_step, step);
        }
        
        //print option
        println(counter++);
        
        inserstionStep(0, 1);
        
        //print option
        println(counter);
    }

    /**
     * Allows class to be run by itself
     * Uses verbose method and examples from the book:
     * https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("This is a verbose example of shell sort.");
        ShellSort test = new ShellSort(0);
        test.populateA();
        test.verboseSort();
    }

}
