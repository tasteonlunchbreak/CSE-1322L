public class FibFormula implements FindFib {
    
    @Override
    public int calculateFib(int n) {
        double sqrtOf5 = Math.sqrt(5);

        double goldnRatio = (1 + sqrtOf5) / 2;
        double goldnConj = (1 - sqrtOf5) / 2;

        double result = (Math.pow(goldnRatio, n) - Math.pow(goldnConj, n)) / sqrtOf5;

        return (int) result;
    }
    
}
