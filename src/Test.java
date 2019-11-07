import codechef.aug18.Balsa;
import hackerearth.PicuBank;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //testPicuBank();
        //testBalsa();
        System.out.println("abc" + null);
    }

    public static void testBalsa() {
        int bound = 2000000000;
        //int runFor = 1000000;
        while(true) {
            Random random = new Random();
            int n = random.nextInt(bound);
            char[] output = Balsa.findGreaterThan3(""+n).toCharArray();
            int count3=0;
            int newN = Integer.parseInt(new String(output));
            for(int i = 0;i<output.length; i++) {
                if(output[i] == '3')
                    count3++;
            }
            if(count3 < 3 || newN <= n) {
                System.out.println(n + "----" + new String(output));
                break;
            }
        }
    }

    public static void testPicuBank(){
        int bound = 100000;
        int runFor = 1000000;
        while(runFor-- > 0) {
            Random rand = new Random();
            int d = rand.nextInt(bound)+1;
            int m = rand.nextInt(bound)+1;
            int x = rand.nextInt(bound)+1;
            int a = rand.nextInt(bound)+1;
            int b = rand.nextInt(bound)+1;

            long fast = PicuBank.fasterMinMonths(a, m, b, x-d);
            int slow = PicuBank.minMonths(d, a, m, b, x);
            if(fast != slow && d < x) {
                System.out.println(fast + "----" + slow);
                System.out.println(d + "--" + m + "--" + x + "--" + a + "--" + b);
                //break;
            }
        }
    }
}
