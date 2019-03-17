/**
 * Insertion sort module
 * 
 * Please see the SortModule.java file for more information.
 * 
 * @author Phillip Benoit
 *
 */
public class InsertionSort extends SortModule {

    @Override
    /**
     * sorting algorithm
     */
    protected void runSort() {
        
        //step through whole array starting at second element
        for (int step = 1; step < a.length; step++) {
            
            //store value and index
            int insertion_value = a[step];
            int insertion_cursor = step;
            
            //move cursor up the list until value is
            //less than the element before it
            while (insertion_cursor > 0 && a[insertion_cursor-1] > insertion_value)

                //shuffle values down while moving cursor
                a[insertion_cursor] = a[--insertion_cursor];
            
            //assign the value to its new location
            a[insertion_cursor] = insertion_value;
        }
    }

    /**
     * Constructor
     * @param size size of the array to sort
     */
	public InsertionSort(int size) {
		super(size);
		name = "Insertion";
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
		
	    //starts at 0 to show unsorted
	    for (int step = 0; step < a.length; step++) {
			int bubble_value = a[step];
			int bubble_cursor = step;
			while (bubble_cursor > 0 && a[bubble_cursor-1] > bubble_value)
				a[bubble_cursor] = a[--bubble_cursor];
			a[bubble_cursor] = bubble_value;
			
			//print option
			println(step);
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
        System.out.println("This is a verbose example of insertion sort.");
        InsertionSort test = new InsertionSort(0);
        test.populateA();
        test.verboseSort();
    }
    
}
