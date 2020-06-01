package Coursera_Code.algorithmic_toolbox.week4;

import java.util.*;

//IMP
public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        List<Segment> allPoints = new ArrayList<>();
        for (int start : starts) {
            allPoints.add(new Segment(start, 'l'));
        }
        for (int point : points) {
            allPoints.add(new Segment(point, 'p'));
        }
        for (int end : ends) {
            allPoints.add(new Segment(end, 'r'));
        }
        allPoints.sort(new SegmentComparator());
        Map<Integer, Integer> pointSegments = new HashMap<>();
        int segment = 0;
        for (Segment allPoint : allPoints) {
            if (allPoint.type == 'l')
                segment++;
            else if (allPoint.type == 'r')
                segment--;
            else
                pointSegments.put(allPoint.value, segment);
        }
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            cnt[i] = pointSegments.get(points[i]);
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }

    static class Segment {
        int value;
        char type;

        Segment(int value, char type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {
            Segment segment = (Segment) obj;
            return segment.value == this.value && segment.type == this.type;
        }
    }
}

class SegmentComparator implements Comparator<PointsAndSegments.Segment> {

    @Override
    public int compare(PointsAndSegments.Segment s1, PointsAndSegments.Segment s2) {
        if (s1.value == s2.value)
            return s1.type - s2.type;
        return s1.value - s2.value;
    }
}

