/**
* we are given array of non-overlapping intervals intervals
* -intervals[i] represents [start_i, end_i] -> start and end time of ith interval
* -sorted in ascending order by start_i
* -we're also given another interval newInterval -> [newStart, newEnd]
*
* insert newInterval into intervals such that intervals is still sorted in
* ascending order, and intervals not having any overlaps
*
* to solve this question, we can implement a 3-phase algorithm:
* 1. add intervals before newInterval
*
* 2. merge existing intervals with newInterval, if necessary
*
* 3. add remaining intervals to list
*
* 4. return result as an array
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // create list to hold merged intervals
        List<int[]> result = new ArrayList<>();

        // define pointer i to 0
        int i = 0;

        // set stopping point as intervals array length
        int n = intervals.length;

        // add intervals occurring before newInterval
        while(i < n && intervals[i][1] < newInterval[0]) {
            // add interval at intervals[i]
            result.add(intervals[i]);

            // advance i
            i++;
        }

        // merge existing intervals with newInterval (if necessary)
        while(i < n && intervals[i][0] <= newInterval[1]) {
            // set start point to bigger of both start points
            newInterval[0] = 
                Math.min(newInterval[0], intervals[i][0]);

            // set end point to bigger of both end points
            newInterval[1] =
                Math.max(newInterval[1], intervals[i][1]);

            // advance i
            i++;
        }

        // add newly merged interval to result
        result.add(newInterval);

        // add remaining intervals
        while(i < n) {
            // add intervals[i] to result
            result.add(intervals[i]);

            // advance i
            i++;
        }

        // return resulting list as an array
        return result.toArray(new int[result.size()][]);
    }
}
