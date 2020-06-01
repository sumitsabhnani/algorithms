package Coursera_Code.algorithm_on_graphs.week5;

import java.util.*;

public class ConnectingPoints {
    private static double minimumDistance(Point[] points) {
        double result = 0.00;
        List<Distance> sortedDistances = calculateAllDistances(points);
        Map<Point, Integer> disjointSet = new HashMap<>();
        Map<Integer, List<Point>> pointsInSet = new HashMap<>();
        for (int i = 1; i <= points.length; i++) {
            disjointSet.put(points[i - 1], i);
            List<Point> point = new ArrayList<>();
            point.add(points[i - 1]);
            pointsInSet.put(i, point);
        }
        for (Distance distance : sortedDistances) {
            Integer set1 = disjointSet.get(distance.from);
            Integer set2 = disjointSet.get(distance.to);
            if (!set1.equals(set2)) {
                result = result + distance.distance;
                if (set1 < set2) {
                    while (!pointsInSet.get(set2).isEmpty()) {
                        Point point = pointsInSet.get(set2).get(0);
                        disjointSet.put(point, set1);
                        pointsInSet.get(set1).add(point);
                        pointsInSet.get(set2).remove(0);
                    }
                } else {
                    while (!pointsInSet.get(set1).isEmpty()) {
                        Point point = pointsInSet.get(set1).get(0);
                        disjointSet.put(point, set2);
                        pointsInSet.get(set2).add(point);
                        pointsInSet.get(set1).remove(0);
                    }
                }
            }
        }
        return Math.round(result * 1000000000.0) / 1000000000.0;
    }

    private static List<Distance> calculateAllDistances(Point[] points) {
        List<Distance> distances = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distances.add(new Distance(points[i], points[j]));
            }
        }
        Collections.sort(distances);
        return distances;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point();
            points[i].x = scanner.nextInt();
            points[i].y = scanner.nextInt();
        }
        System.out.println(minimumDistance(points));
    }
}

class Distance implements Comparable<Distance> {
    Double distance;
    Point from;
    Point to;

    Distance(Point from, Point to) {
        this.from = from;
        this.to = to;
        distance = Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
    }

    @Override
    public int compareTo(Distance o) {
        return this.distance.compareTo(o.distance);
    }
}

class Point {
    int x, y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

