package com.ruchij;

import java.util.*;

public class IntersectionSizeTwo {
    record Interval(int start, int end) {
        boolean contains(int number) {
            return number >= start && number <= end;
        }
    }

    public int intersectionSizeTwo(int[][] intervals) {
        List<Interval> intervalList = intervalList(intervals);
        System.out.println(intervalList);
        ArrayList<Integer> numbers = new ArrayList<>();

        for (Interval interval : intervalList) {
            int numberContaining = 0;

            if (!numbers.isEmpty()) {
                Integer last = numbers.get(numbers.size() - 1);

                if (interval.contains(last)) {
                    numberContaining++;
                }

                if (numbers.size() >= 2) {
                    Integer secondLast = numbers.get(numbers.size() - 2);

                    if (interval.contains(secondLast)) {
                        numberContaining++;
                    }
                }
            }


            if (numberContaining >= 2) {
                // Do nothing
            } else if (numberContaining == 1) {
                numbers.add(interval.end);
            } else {
                numbers.add(interval.end);
                numbers.add(interval.end - 1);
            }
        }

        return numbers.size();
    }

    List<Interval> intervalList(int[][] intervals) {
        ArrayList<Interval> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(
                list,
                Comparator.comparingInt(Interval::start).thenComparingInt(Interval::end)
        );

        return reduce(list);
    }

    List<Interval> reduce(List<Interval> intervals) {
        Stack<Interval> stack = new Stack<>();
        boolean changesMade = false;

        for (Interval interval : intervals) {
            if (!stack.isEmpty()) {
                Interval last = stack.peek();

                if (last.end >= interval.end) {
                    stack.pop();
                    changesMade = true;
                    stack.push(interval);
                } else if (last.start == interval.start) {
                    changesMade = true;
                } else {
                    stack.push(interval);
                }
            } else {
                stack.push(interval);
            }
        }

        if (changesMade) {
            return reduce(stack);
        } else {
            return stack;
        }
    }
}
