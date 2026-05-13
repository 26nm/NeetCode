class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals in ascending order, by start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // create list to hold result
        List<int[]> result = new ArrayList<>();

        // add first interval to result
        result.add(intervals[0]);

        // traverse remaining intervals starting from 1
        for(int i = 1; i < intervals.length; i++) {
            // get last interval
            int[] lastInterval = result.get(result.size() - 1);

            // get current interval
            int[] current = intervals[i];

            // check if intervals overlap
            if(current[0] <= lastInterval[1]) {
                // update endpoint of prev interval to bigger of prev and current
                lastInterval[1] =
                    Math.max(lastInterval[1], current[1]);

            // no overlap, add to result
            } else {
                result.add(current);
            }
        }

        // convert resulting list to array and return
        return result.toArray(new int[result.size()][]);
    }
}
