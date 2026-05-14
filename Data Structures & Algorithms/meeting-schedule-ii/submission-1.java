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
* given an array of meeting time interval objects, find the minimum number
* of rooms required to schedule all meetings without any conflicts
*
* to solve this question, we can maintain a min heap containing meetings'
* end times
*
* 1. sort input array in ascending order, by start time
*
* 2. traverse each meeting time interval:
*    -if heap not empty and earliest end is before current's start, remove
*    -add current meeting's end time to heap
*
* 3. return heap size
*/
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // sort input in ascending order, by start time
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        // create min heap to process meeting intervals
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // traverse through meeting intervals
        for(Interval interval : intervals) {
            // check if heap not empty and earliest end before current's start
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                // if earliest end time is before current's start -> free up room
                minHeap.poll();
            }

            // add current meeting end time to heap
            minHeap.offer(interval.end);
        }

        // return # of active meetings
        return minHeap.size();
    }
}
