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

/**
* we are given an array of meeting time interval objects
*
* determine if a person could attend all meetings without schedule conflicts
*
* to solve this, we can check if:
* -prev interval's end bigger than curr interval's start
*/
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort input array in ascending order, by start time
        intervals.sort((a,b) -> a.start - b.start);

        // traverse each interval, starting from 1
        for(int i = 1; i < intervals.size(); i++) {
            // get previous and current intervals
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);

            // check for schedule conflicts
            if(prev.end > curr.start) return false;
        }

        // no conflict found
        return true;
    }
}
