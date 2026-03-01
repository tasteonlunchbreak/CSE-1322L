public class FibIteration implements FindFib {
    
    @Override
    public int calculateFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int previous = 1;
        int current = 1;
        int next = 0;

        for (int i = 3; i <= n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}