class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // create list to hold result after inserting new interval
        List<int[]> result = new ArrayList<>();

        // set a pointer i to 0
        int i = 0;

        // set stopping point to length of intervals array
        int n = intervals.length;

        // add intervals before the new interval
        while(i < n && intervals[i][1] < newInterval[0]) {
            // add current interval at intervals[i]
            result.add(intervals[i]);

            // advance i
            i++;
        }

        // merge overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]) {
            // set start of new interval as smaller of both start points
            newInterval[0] =
                Math.min(newInterval[0], intervals[i][0]);

            // set end of new interval as bigger of both end points
            newInterval[1] =
                Math.max(newInterval[1], intervals[i][1]);

            // advance i
            i++;
        }

        // add merged interval to resulting list
        result.add(newInterval);

        // add remaining intervals
        while(i < n) {
            result.add(intervals[i]);

            // advance pointer
            i++;
        }

        // return resulting list as an array
        return result.toArray(new int[result.size()][]);
    }
}
