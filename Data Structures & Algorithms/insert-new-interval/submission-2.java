/**
* we are given an array of non-overlapping intervals intervals
* -intervals[i] represents start and end time of ith intervals
* -intervals initially sorted in ascending order by start_i
* -we are also given another interval newInterval = [start, end]
*
* insert new interval such that intervals is still sorted in ascending
* order by start_i and no overlaps
* 
* to solve this question, we can implement 3-phase approach:
* 1. add intervals before newInterval
*
* 2. merge intervals with newInterval, if necessary
*
* 3. add remaining intervals to list
*
* 4. return the resulting list
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // create list to hold newly merged intervals
        List<int[]> result = new ArrayList<>();

        // set a pointer i to 0
        int i = 0;

        // set stopping point n to interval array length
        int n = intervals.length;

        // add intervals before newInterval
        while(i < n && intervals[i][1] < newInterval[0]) {
            // add interval to list
            result.add(intervals[i]);

            // advance i
            i++;
        }

        // merge new interval with existing intervals, if necessary
        while(i < n && intervals[i][0] <= newInterval[1]) {
            // set start of new interval as bigger of both start points
            newInterval[0] = 
                Math.min(intervals[i][0], newInterval[0]);

            // set end of new interval as bigger of both end points
            newInterval[1] =
                Math.max(intervals[i][1], newInterval[1]);

            // advance i
            i++;
        }

        // add newly merged interval(s) to list
        result.add(newInterval);

        // add remaining intervals
        while(i < n) {
            // add interval at intervals[i]
            result.add(intervals[i]);

            // advance i
            i++;
        }

        // return resulting list as an array
        return result.toArray(new int[result.size()][]);
    }
}
