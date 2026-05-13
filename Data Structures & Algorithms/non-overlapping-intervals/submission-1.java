/**
* given an array of intervals intervals where intervals[i] = [start_i, end_i]
* return the minimum number of intervals needed to be removed to make rest of intervals
* non-overlapping
*
* we can use the following approach to solve this question:
* 1. sort input array in ascending order, by start time
*
* 2. keep track of removals needed -> set remove to 0
*
* 3. keep track of the previous endpoint -> initialize this value to end of 1st interval
*
* 4. traverse through the remaining intervals:
*    -get the current start and end points
*    -if the prev end point bigger than next interval's start:
*     -increment remove
*     -adjust prev endpoint to smaller of prev and current end point
*    -otherwise set prev endpoint to current endpoint
*
* 5. return # of removals counted
*/ 
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort input array
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // track number of removals needed
        int remove = 0;

        // track previous endpoint, start with end of 1st interval
        int prevEnd = intervals[0][1];

        // traverse through remaining intervals
        for(int i = 1; i < intervals.length; i++) {
            // get current end and start points
            int start = intervals[i][0];
            int end = intervals[i][1];

            // check for overlaps
            if(prevEnd > start) {
                // if overlap found -> increment removal
                remove++; 

                // adjust prev endpoint to min of prev and current endpoint
                prevEnd = Math.min(prevEnd, end);

            // no overlap found, adjust prev end to current end
            } else {
                prevEnd = end;
            }
        }

        // return number of removals counte
        return remove;
    }
}
