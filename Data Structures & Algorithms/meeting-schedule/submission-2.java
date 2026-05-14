/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort input array in ascending order, by start time
        intervals.sort((a,b) -> a.start - b.start);

        // traverse each interval, starting at 1
        for(int i = 1; i < intervals.size(); i++) {
            // get previous and current Intervals
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);

            // check if prev's endpoint bigger than curr's start (conflict)
            if(prev.end > curr.start) return false;
        }

        // no conflict found
        return true;
    }
}
