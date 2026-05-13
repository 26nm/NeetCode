/**
* given an array of intervals where intervals[i] = [start_i, end_i],
* merge all overlapping intervals, and return array of non-overlapping
* intervals
*
* to solve this question, we can use following approach:
* 1. sort input array in ascending order, by start times
*
* 2. make a list to hold merged intervals
*
* 3. add the first interval to list
*    
* 4. traverse remaining intervals, starting from 1
*    -get the most recent interval added to list
*    -get the current interval
*    -if next interval's start time <= prev interval's end time -> overlap
*     -update previous interval's endpoint to the max of those two
*     -otherwise add this interval to resulting list
*
* 5. return the resulting list as an array
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        // sort input array in ascending order, by start times
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // create list to hold merged intervals
        List<int[]> result = new ArrayList<>();

        // add first interval to result
        result.add(intervals[0]);

        // traverse through remaining intervals
        for(int i = 1; i < intervals.length; i++) {
            // get most recent interval
            int[] lastInterval = result.get(result.size() - 1);

            // get current interval
            int[] current = intervals[i];

            // check if overlap exists
            if(current[0] <= lastInterval[1]) {
                // if overlap -> adjust prev end point to max of prev and current
                lastInterval[1] = 
                    Math.max(lastInterval[1], current[1]);

            // no overlap, add current interval to list
            } else {
                result.add(current);
            }
        }

        // return resulting list as an array
        return result.toArray(new int[result.size()][]);
    }
}
