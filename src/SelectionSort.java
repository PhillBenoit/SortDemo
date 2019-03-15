import java.util.ArrayList;

public class SelectionSort extends SortModule {

	public SelectionSort(int size) {
		super(size);
	}
	
	public static void main(String[] args) {
		System.out.println("This is a verbose example of insertion sort.");
		SelectionSort test = new SelectionSort(0);
		test.populateA();
		test.verboseSort();
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
		ArrayList<Integer> least_list = new ArrayList<Integer>();
		int least = Integer.MAX_VALUE;
		int start_index = 0;
		while (start_index < a.length) {
			println(start_index);
			for (int cursor = start_index; cursor < a.length; cursor++) {
				int value = a[cursor];
				if ( value < least) {
					least_list.clear();
					least_list.add(cursor);
					least = value;
				}
				else if (value == least) least_list.add(cursor);
			}
			for (Integer number:least_list)
				swap(number, start_index++, least);
			least = Integer.MAX_VALUE;
			least_list.clear();
		}
	}
	
	private void swap(int source, int destination, int source_value) {
		int temp = a[destination];
		a[destination] = source_value;
		a[source] = temp;
	}

	@Override
	protected void runSort() {
		// TODO Auto-generated method stub

	}

}
