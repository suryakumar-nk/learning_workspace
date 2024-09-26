package Leetcode.CalendarClasses;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    private List<int[]> intervals;

    public MyCalendarTwo() {
        intervals = new ArrayList<int[]>();
    }
    
    private boolean isOverlap(int[] interval, int start, int end) {
        if (start >= interval[0] && start < interval[1])
            return true;
        if (end > interval[0] && end <= interval[1])
            return true;
        if (start < interval[0] && end > interval[1])
            return true;
        return false;
    }
    
    public boolean book(int start, int end) {
        List<int[]> prevInts = new ArrayList<>();
        for (int[] interval: intervals) {
            if (isOverlap(interval, start, end)) {
                for (int[] prevInt : prevInts) {
                    if (isOverlap(prevInt, interval[0], interval[1]))
                        return false;
                }
                prevInts.add(interval);
            }
        }
        intervals.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        var calendar = new MyCalendarTwo();
        System.err.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(25, 50));
    }
}
