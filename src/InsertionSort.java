
public class InsertionSort extends SortModule {

	public static void main(String[] args) {
		System.out.println("This is a verbose example of insertion sort.");
		InsertionSort test = new InsertionSort(0);
		test.populateA();
		test.verboseSort();
	}
	
	public InsertionSort(int size) {
		super(size);
	}

	@Override
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
	protected void verboseSort() {
		for (int step = 0; step < a.length; step++) {
			int bubble_value = a[step];
			int bubble_cursor = step;
			while (bubble_cursor > 0 && a[bubble_cursor-1] > bubble_value)
				a[bubble_cursor] = a[--bubble_cursor];
			a[bubble_cursor] = bubble_value;
			println(step);
		}
	}

	@Override
	protected void runSort() {
		for (int step = 1; step < a.length; step++) {
			int bubble_value = a[step];
			int bubble_cursor = step;
			while (bubble_cursor > 0 && a[bubble_cursor-1] > bubble_value)
				a[bubble_cursor] = a[--bubble_cursor];
			a[bubble_cursor] = bubble_value;
		}
	}

}
