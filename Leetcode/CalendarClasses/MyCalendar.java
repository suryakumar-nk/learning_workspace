package Leetcode.CalendarClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar {
    private List<int[]> intervals;
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {
        intervals = new ArrayList<int[]>();
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
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
        for (int[] interval: intervals) {
            if (isOverlap(interval, start, end))
                return false;
        }
        intervals.add(new int[]{start, end});
        return true;
    }

    public boolean bookTree(int start, int end) {
        // get an (higher)entry that ends just after current
        var e = map.higherEntry(start);
        // if start time of higher entry is less than end time of current
        // since current has to start before higher enry,
        // so if above condition is true, it means the current event will end before higher entry
        // event will start, so we can schedule it
        if(end <= e.getValue()){
            map.put(end, start);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var calendar = new MyCalendar();
        // System.err.println(calendar.bookTree(10, 20));
        // System.out.println(calendar.bookTree(15, 25));
        // System.out.println(calendar.bookTree(20, 30));
        System.err.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}
