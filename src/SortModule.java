import java.util.Random;

public abstract class SortModule {

	private long elapsed_time;
	private double elapsed_seconds;
	public static final double BILLION = 1000000000.0;
	private Boolean isCorrect;
	
	protected int[] a;
	
	public SortModule(int size) {
		a = new int[size];
		Random rng = new Random();
		for (int step = 0; step < size; step++)
			a[step] = rng.nextInt(size);
	}
	
	public static void main(String[] args) {
		System.out.println("This is an abstract class to measure sort times");
	}
	
	protected abstract void populateA();
	
	protected abstract void verboseSort();
	
	protected void println(int step) {
		System.out.printf("Step %d: ",step);
		for (int i:a) System.out.print(i + " ");
		System.out.println();
	}
	
	public void sort() {
		System.gc();
		elapsed_time = System.nanoTime();
		runSort();
		elapsed_time = System.nanoTime() - elapsed_time;
		elapsed_seconds = elapsed_time / BILLION;
		isCorrect = correctTest();
		a = null;
		System.gc();
	}
	
	private boolean correctTest() {
	    for (int step = 1; step < a.length; step++)
	        if (a[step] < a[step-1]) return false;
	    return true;
	}
	
    protected void swap(int source, int destination, int source_value) {
        int temp = a[destination];
        a[destination] = source_value;
        a[source] = temp;
    }

	protected abstract void runSort();

	public long getElapsedTime() {return elapsed_time;}

	public double getElapsedSeconds() {return elapsed_seconds;}
	
	public boolean isCorrect() {return isCorrect;}

}
