package codechef.june19;

import java.util.Scanner;

public class KS2 {

    public static void main(String args[]) {
        KS2 ks2 = new KS2();
        Scanner reader = new Scanner(System.in);
        int testCases;
        testCases = reader.nextInt();
        while (testCases-- > 0) {
            long N = reader.nextLong();
            System.out.println(ks2.smallestRoundInteger(N));
        }
    }

//    public static void main(String[] args) {
//      KS2 ks2 = new KS2();
//      for(long i = 1000000000L; i < 10000000000L; i++) {
//          long result = ks2.smallestRoundInteger(i);
//          if(!ks2.isMultipleOf10(result))
//              System.out.println(i + "----" + result);
//      }
//    }

    private boolean isMultipleOf10(long n) {
        long M = n/10;
        long sum = n %10;
        while(M != 0) {
            sum = sum + M%10;
            M = M/10;
        }
        return sum%10 == 0;
    }

    public long smallestRoundInteger(long n) {
        long M = n /10;
        long sum = n %10;
        while(M != 0) {
            sum = sum + M%10;
            M = M/10;
        }
        if(sum%10 == 0)
            return n *10;
        else {
            return (n *10) + (10-sum%10);
        }
    }
}
