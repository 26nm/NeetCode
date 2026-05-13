class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort input array in ascending order, by start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // keep track of removals, start at 0
        int remove = 0;

        // keep track of previous end, start at end of first interval
        int prevEnd = intervals[0][1];

        // traverse through remaining intervals
        for(int i = 1; i < intervals.length; i++) {
            // get current start and end points
            int start = intervals[i][0];
            int end = intervals[i][1];

            // check if overlap exists
            if(start < prevEnd) {
                // overlap found -> increment remove
                remove++;

                // adjust prev endpoint to min of prev and current endpoint
                prevEnd = Math.min(prevEnd, end);

            // no overlap found -> set prev endpoint to current endpoint
            } else {
                prevEnd = end;
            }
        }

        // return number of removals counted
        return remove;
    }
}
