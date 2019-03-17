/**
 * Runs SortModule tests
 * 
 * @author Phillip Benoit
 *
 */
public class RunTests {

    /**
     * average time elapsed per module (nanoseconds)
     */
    static private long average_nano;

    /**
     * average time elapsed per module (seconds)
     */
    static private double average_seconds;
    
    /**
     * Array size to generate
     * 20000 makes each bubble sort take about a half second.
     * Remember this is multiplied by number of tests so
     * 20 tests on Bubble Sort takes about 10 seconds.
     */
    static private final int array_size = 20000,
            
            /**
             * Number of tests to run per module
             */
            number_of_tests = 20;
    
    /**
     * Entry point for program
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        
        //Tests for each module
        
        testModule(new BubbleSort(array_size));
        
        testModule(new SelectionSort(array_size));
        
        testModule(new InsertionSort(array_size));
        
        testModule(new MergeSort(array_size));
        
        testModule(new ShellSort(array_size));
        
        testModule(new QuickSort(array_size));
    }
    
    /**
     * Sequence to test each module type
     * 
     * @param m Module to test
     */
    static private void testModule(SortModule m) {
        
        //(re)set averages
        average_seconds = average_nano = 0;
        
        //run tests
        for (int step = 0; step < number_of_tests; step++) runTest(m);
        
        //calculate averages
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        
        //format output
        String name = String.format("%s Average:", m.getName());
        System.out.format("%-22s[%.3f] Seconds  [%d] Nanoseconds\n",
                name, average_seconds, average_nano);        
    }
    
    /**
     * Single test
     * 
     * @param m Module to test
     */
    private static void runTest(SortModule m) {
        
        //run the sort
        m.sort();
        
        //quit program if the sort didn't work
        if (!m.isCorrect()) {
            System.err.println("Sort Algorithm Failed");
            System.exit(-1);
        }
        
        //add times for averages
        average_nano += m.getElapsedTime();
        average_seconds += m.getElapsedSeconds();
        
        //reset the module
        m.reset();
    }

}
