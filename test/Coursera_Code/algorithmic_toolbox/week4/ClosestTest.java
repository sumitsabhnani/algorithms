package Coursera_Code.algorithmic_toolbox.week4;

import java.util.Random;

public class ClosestTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Random rd = new Random();

        while (true) {
            int n = rd.nextInt(100000);
            Closest.Point[] points = new Closest.Point[n];
            Point2D[] points2D = new Point2D[n];
            int min = -1000000000, bound = 2000000000;
            for (int i = 0; i < n; i++) {
                int x = rd.nextInt(bound) - min;
                int y = rd.nextInt(bound) - min;
                points[i] = new Closest.Point(x, y);
                points2D[i] = new Point2D(x, y);

            }
            long time1 = System.currentTimeMillis();
            double fast = Closest.minimalDistanceFast(points);
            long time2 = System.currentTimeMillis();
            double slow = Closest.minimalDistanceSlow(points);
            long time3 = System.currentTimeMillis();
            ClosestPair closest = new ClosestPair(points2D);
            double superFast = closest.distance();
            long time4 = System.currentTimeMillis();

            if (slow != fast) {
                System.out.println(points);
            } else {
                System.out.println(String.format("Matching<%d>--Slow<%d>--Fast<%d>--SuperFast<%d>=====Values-Slow<%f>-Fast<%f>", n, (time3 - time2), (time2 - time1), (time4 - time3), slow, fast));
            }
        }
    }

}
