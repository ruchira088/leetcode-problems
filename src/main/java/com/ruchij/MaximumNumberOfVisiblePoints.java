package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfVisiblePoints {
    record Coordinate(int x, int y) {}

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        ArrayList<Double> anglesList = new ArrayList<>();
        int alwaysVisible = 0;
        Coordinate person = parseCoordinate(location);

        for (List<Integer> coordinateValues : points) {
            Coordinate coordinate = parseCoordinate(coordinateValues);

            if (coordinate.equals(person)) {
                alwaysVisible++;
            } else {
                anglesList.add(parse(coordinate, person));
            }
        }

        double[] angles = anglesList.stream().mapToDouble(x -> x).sorted().toArray();

        int max = 0;

        for (int i = 0; i < angles.length; i++) {
            double start = angles[i];
            double end = start + angle;

            int endIndex = findLast(angles, end % 360);

            if (end <= 360) {
                max = Math.max(max, endIndex - i + 1);
            } else {
                max = Math.max(max, angles.length - i + 1 + endIndex);
            }
        }

        return max + alwaysVisible;
    }

    int findLast(double[] values, double target) {
        return findLast(values, 0, values.length - 1, target);
    }

    int findLast(double[] values, int start, int end, double target) {
        if (start > end) {
            return end;
        } else {
            int midPoint = (start + end + 1) / 2;
            double midValue = values[midPoint];

            if (start == end && midValue == target) {
                return midPoint;
            } else if (midValue > target) {
                return findLast(values, start, midPoint - 1, target);
            } else if (midValue < target) {
                return findLast(values, midPoint + 1, end, target);
            } else {
                return findLast(values, midPoint, end, target);
            }
        }
    }

    Coordinate parseCoordinate(List<Integer> coordinateList) {
        return new Coordinate(coordinateList.get(0), coordinateList.get(1));
    }

    double parse(Coordinate coordinate, Coordinate person) {
        int x = coordinate.x - person.x;
        int y = coordinate.y - person.y;
        double angle = Math.atan2(y, x);

        double degrees = angle > 0 ? angle * (180 / Math.PI) : (180 + (180 + angle * 180 / Math.PI));

        return degrees;
    }
}
