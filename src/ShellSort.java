
public class ShellSort extends SortModule {

    public ShellSort(int size) {
        super(size);
    }

    @Override
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
    protected void verboseSort() {
        int counter = 0;
        for (int step = a.length/2; step > 2; step/=2) {
            println(counter++);
            for (int sub_step = 0; sub_step < step; sub_step++)
                inserstionStep(sub_step, step);
        }
        println(counter++);
        inserstionStep(0, 1);
        println(counter);
    }

    @Override
    protected void runSort() {
        int step = a.length/2;
        while ( step%3 != 1) step--;
        for (; step > 3; step/=3)
            for (int sub_step = 0; sub_step < step; sub_step++)
                inserstionStep(sub_step, step);
        inserstionStep(0, 1);
    }
    
    private void inserstionStep(int start, int step_increment) {
        int previous_index = start;
        for (int step = start+step_increment; step < a.length; step+=step_increment) {
            int cursor_value = a[step];
            int cursor_index = step;
            while (previous_index > -1 && a[previous_index] > cursor_value) {
                a[cursor_index] = a[previous_index];
                cursor_index = previous_index;
                previous_index -= step_increment;
            }
            a[cursor_index] = cursor_value;
            previous_index = step;
        }
    }

    public static void main(String[] args) {
        System.out.println("This is a verbose example of shell sort.");
        ShellSort test = new ShellSort(0);
        test.populateA();
        test.verboseSort();
    }

}
