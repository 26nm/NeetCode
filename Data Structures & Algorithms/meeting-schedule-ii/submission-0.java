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
    public int minMeetingRooms(List<Interval> intervals) {
        // sort input array in ascending order
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        // create min heap to process meeting times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // traverse through each interval
        for(Interval interval : intervals) {
            // if heap not empty and earliest end time before current's start -> remove
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }

            // add current meeting end time to heap
            minHeap.offer(interval.end);
        }

        // return heap size
        return minHeap.size();
    }
}
