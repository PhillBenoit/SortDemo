
public class RunTests {

    
    static private long average_nano;
    static private double average_seconds;
    
    public static void main(String[] args) {
        
        int array_size = 20000;
        int number_of_tests = 20;
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new BubbleSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Bubble Average:    [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new SelectionSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Selection Average: [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new InsertionSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Insertion Average: [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new ShellSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Shell Average:     [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new MergeSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Merge Average:     [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
        average_seconds = average_nano = 0;
        for (int step = 0; step < number_of_tests; step++)
            runTest(new QuickSort(array_size));
        average_seconds /= number_of_tests;
        average_nano /= number_of_tests;
        System.out.format("Quick Average:     [%.3f] Seconds  [%d] Nanoseconds\n",
                average_seconds, average_nano);        
        
    }
    
    private static void runTest(SortModule m) {
        m.sort();
        if (!m.isCorrect()) {
            System.err.println("Sort Algorithm Failed");
            System.exit(-1);
        }
        average_nano += m.getElapsedTime();
        average_seconds += m.getElapsedSeconds();
    }

}
