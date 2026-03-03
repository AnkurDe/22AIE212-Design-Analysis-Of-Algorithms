package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Q3 {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Distance between two points
    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                         (p1.y - p2.y) * (p1.y - p2.y));
    }

    // Brute force for small number of points
    static double bruteForce(Point[] points, int left, int right) {
        double min = Double.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }

    // Check strip area
    static double stripClosest(Point[] strip, int size, double d) {
        double min = d;

        Arrays.sort(strip, 0, size, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size &&
                 (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, distance(strip[i], strip[j]));
            }
        }
        return min;
    }

    static double closestUtil(Point[] points, int left, int right) {

        if (right - left <= 3)
            return bruteForce(points, left, right);

        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        double dl = closestUtil(points, left, mid);
        double dr = closestUtil(points, mid + 1, right);

        double d = Math.min(dl, dr);

        Point[] strip = new Point[right - left + 1];
        int j = 0;

        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < d) {
                strip[j++] = points[i];
            }
        }

        return Math.min(d, stripClosest(strip, j, d));
    }

    public static double closest(Point[] points) {

        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));

        return closestUtil(points, 0, points.length - 1);
    }

    // Example usage
    public static void main(String[] args) {

        Point[] points = {
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        double result = closest(points);
        System.out.println("Minimum distance: " + result);
    }
}