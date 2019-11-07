package others;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FastFibonacci {

    static Map<Long, BigInteger> fibonaccis = new HashMap<>();

    public static void main(String args[]) {
        fibonaccis.put(0L, BigInteger.ZERO);
        fibonaccis.put(1L, BigInteger.ONE);
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(12));
        System.out.println(fibonacci(15));
        System.out.println(fibonacci(1000));
        System.out.println(fibonacci(10000));
        System.out.println(System.currentTimeMillis() - start);
    }

    static BigInteger fibonacci(long position) {
        if (fibonaccis.get(position) != null)
            return fibonaccis.get(position);
        long half = position / 2;
        if (position % 2 == 0) {
            fibonaccis.put(half - 1, fibonacci(half - 1));
            fibonaccis.put(half, fibonacci(half));
            return fibonaccis.get(half - 1).multiply(BigInteger.TWO).add(fibonaccis.get(half)).multiply(fibonaccis.get(half));
        }
        fibonaccis.put(half, fibonacci(half));
        fibonaccis.put(half + 1, fibonacci(half + 1));
        return fibonaccis.get(half).pow(2).add(fibonaccis.get(half + 1).pow(2));
    }
}
