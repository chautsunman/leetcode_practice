package problems.powXN;

public class Solution {
    public double myPow(double x, int n) {
        return calcPow(x, (long) n);
    }

    private double calcPow(double x, long n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            if (n % 2 == 0) {
                return calcPow(x * x, n / 2);
            } else {
                return x * calcPow(x * x, (n - 1) / 2);
            }
        } else {
            return 1.0 / calcPow(x, -n);
        }
    }
}
