/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Merge Intervals
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/merge-intervals/
 Notes:
 Given a collection of intervals, merge all overlapping intervals.
 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 Solution: 1. Sort in ascending order of 'start'.
           2. Traverse the 'intervals', merge or push...
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comp =  new Comparator<Interval>(){  
            public int compare(Interval a,  Interval b) {  
                if(a.start < b.start) {  
                    return -1;  
                }else if(a.start > b.start){  
                    return 1;  
                } else {
                    if (a.end < b.end) return -1;
                    else if (a.end > b.end) return 1;
                    return 0;  
                }  
            }  
        };
        ArrayList<Interval> res = new ArrayList<Interval>();
        int N = intervals.size();
        if (N <= 1) return intervals;
        Collections.sort(intervals, comp);
        Interval last = intervals.get(0);
        for (int i = 0; i < N; ++i) {
            if (intervals.get(i).start > last.end) {
                res.add(last);
                last = intervals.get(i);
            } else {
                last.end = Math.max(last.end, intervals.get(i).end);
            }
        }
        res.add(last);
        return res;
    }
}