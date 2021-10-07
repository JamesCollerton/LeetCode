class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n < 0){
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
    
    private double positivePow(double x, int n, int increment, double total) {
        while(n != 0) {
            System.out.println(n);
            total = x * total;
            n += increment;
        }
        return total;
    }
}