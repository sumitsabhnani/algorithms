package Coursera_Code.Algorithmic_Toolbox.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Closest {

    static class XComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return Long.signum(o1.x - o2.x);
        }
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean lessThan(Point that) {
            if (this.y < that.y) return true;
            if (this.x < that.x) return true;
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    static double minimalDistanceFast(Point[] pointsArr) {
        for (int i = 0; i < pointsArr.length - 1; i++) {
            if (pointsArr[i].equals(pointsArr[i + 1])) {
                return 0.0;
            }
        }
        Arrays.sort(pointsArr, new XComparator());
        Point[] pointsByX = new Point[pointsArr.length];
        Point[] pointsByY = new Point[pointsArr.length];
        Point[] aux = new Point[pointsArr.length];
        for (int i = 0; i < pointsArr.length; i++) {
            pointsByX[i] = pointsArr[i];
            pointsByY[i] = pointsArr[i];
        }
        return minimalDistanceFast(pointsByX, pointsByY, aux, 0, pointsArr.length - 1);
    }

    static double minimalDistanceFast(Point[] pointsByX, Point[] pointsByY, Point[] aux, int start, int end) {
        if (end <= start) {
            return Double.POSITIVE_INFINITY;
        }
        int mid = (start + end) / 2;
        Point midPoint = pointsByX[mid];

        double d1 = minimalDistanceFast(pointsByX, pointsByY, aux, start, mid);
        double d2 = minimalDistanceFast(pointsByX, pointsByY, aux, mid + 1, end);
        double currentMin = Math.min(d1, d2);

        for (int k = start; k <= end; k++) {
            aux[k] = pointsByY[k];
        }

        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) pointsByY[k] = aux[j++];
            else if (j > end) pointsByY[k] = aux[i++];
            else if (aux[j].lessThan(aux[i])) pointsByY[k] = aux[j++];
            else pointsByY[k] = aux[i++];
        }

        int m = 0;
        for (int ii = start; ii <= end; ii++) {
            if (Math.abs(pointsByY[ii].x - midPoint.x) < currentMin)
                aux[m++] = pointsByY[ii];
        }

        return closest(aux, m, currentMin);
    }

    static double closest(Point[] strip, int size, double d) {
        double dSharp = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && strip[j].y - strip[i].y < d; j++) {
                double distance = Math.sqrt(Math.pow(strip[i].x - strip[j].x, 2) + Math.pow(strip[i].y - strip[j].y, 2));
                if (distance < dSharp)
                    dSharp = distance;
            }
        }
        return Math.min(d, dSharp);
    }

    static double minimalDistanceSlow(Point[] points) {
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                if (distance < ans)
                    ans = distance;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.####");
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(nextInt(), nextInt());
        }
        System.out.println(df.format(minimalDistanceFast(points)));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
