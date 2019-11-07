package codechef.common;

public class FastExp {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fastMod(4, 40, 1000000007));
        System.out.println("Time:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(slowMod(4, 40));
        System.out.println("Time:" + (System.currentTimeMillis() - start));
    }
    private static long fastMod(long base, int exp, long mod){
        long result = 1;
        while(exp > 0) {
            if(exp%2 == 1)
                result = (result * base)%mod;
            base = (base * base)%mod;
            exp /= 2;
        }
        return result % mod;
    }

    private static long slowMod(long base, int exp)
    {
        if(exp==1)
            return base;
        else
        {
            if(exp%2 == 0)
            {
                long base1 = (long)Math.pow(slowMod(base, exp/2),2);
                if(base1 >= 1000000007)
                    return base1%1000000007;
                else
                    return base1;
            }
            else
            {
                long ans = (long)(base*  Math.pow(slowMod(base,(exp-1)/2),2));
                if(ans >= 1000000007)
                    return ans%1000000007;
                else
                    return ans;
            }
        }
    }
}
