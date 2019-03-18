import java.util.Random;

/**
 * Abstract class for a sorting algorithm.
 * 
 * link to the book used for examples:
 * https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
 * 
 * @author Phillip Benoit
 *
 */
public abstract class SortModule {

    /**
     * time elapsed for a sort (nanoseconds)
     */
	private long elapsed_time;
	
    /**
     * time elapsed for a sort (seconds)
     */
	private double elapsed_seconds;
	
    /**
     * Constant to calculate seconds from nanoseconds
     */
    public static final double BILLION = 1000000000.0;

    /**
	 * Size of the array to sort and random number max
	 */
	private int size;
	
	/**
	 * Represents algorithm accuracy
	 */
	private Boolean isCorrect;
	
	/**
	 * Name of the sort for identification
	 */
	protected String name;
	
	/**
	 * Array used for sorting
	 */
	protected int[] a;
	
	/**
	 * Constructor
	 * 
	 * @param size Array size
	 */
	public SortModule(int size) {
		this.size = size;
		reset();
	}
	
	/**
	 * Create array to test using random numbers
	 */
	public void reset() {
	    
	    //create the array
	    a = new int[size];
        
	    //assign random numbers with a max value of the size of the array
	    Random rng = new Random();
        for (int step = 0; step < size; step++)
            a[step] = rng.nextInt(size);
	}
	
    /**
     * Allows class to be run by itself
     * 
     * @param args Command line arguments (unused)
     */
	public static void main(String[] args) {
		System.out.println("This is an abstract class to measure sort times");
        System.out.println("Sorting algorithms are extensions of this class");
	}
	
	/**
	 * Used to populate array with values from the book
	 */
	protected abstract void populateA();
	
	/**
	 * Used to display output to show how sorts are working
	 */
	protected abstract void verboseSort();
	
	/**
	 * displays contents of a[] in a single line of text
	 * prefixed with the step number
	 * 
	 * @param step
	 */
	protected void println(int step) {
		System.out.printf("Step %d: ",step);
		for (int i:a) System.out.print(i + " ");
		System.out.println();
	}
	
	/**
	 * runs the sort
	 */
	public void sort() {

	    //run garbage collection
	    System.gc();
		
	    //run sort and calculate time
	    elapsed_time = System.nanoTime();
		runSort();
		elapsed_time = System.nanoTime() - elapsed_time;
		elapsed_seconds = elapsed_time / BILLION;
		
		//test for correctness
		isCorrect = correctTest();
		
		//clear array and run garbage collection
		a = null;
		System.gc();
	}
	
	/**
	 * Tests to see if a[] is sorted
	 * 
	 * @return False if list is out of order
	 */
	private boolean correctTest() {
	    for (int step = 1; step < a.length; step++)
	        if (a[step] < a[step-1]) return false;
	    return true;
	}
	
	/**
	 * Generic swap routine
	 * 
	 * @param source array index
	 * @param destination array index
	 * @param source_value value at source index
	 */
    protected void swap(int source, int destination, int source_value) {
        a[source] = a[destination];
        a[destination] = source_value;
    }

    /**
     * sort algorithm
     */
	protected abstract void runSort();

	/**
	 * gets elapsed time (nanoseconds)
	 * @return elapsed time (nanoseconds)
	 */
	public long getElapsedTime() {return elapsed_time;}

    /**
     * gets elapsed time (seconds)
     * @return elapsed time (seconds)
     */
	public double getElapsedSeconds() {return elapsed_seconds;}
	
	/**
	 * gets results of correctness testing
	 * @return results of correctness testing
	 */
	public boolean isCorrect() {return isCorrect;}
	
	/**
	 * gets the name of the algorithm
	 * @return name of the algorithm
	 */
	public String getName() {return name;}

}
