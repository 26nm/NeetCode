/**
* we are given a 2D int array intervals
*
* we are also given an integer array of query points queries
* -result of query[j] is length of shortest interval i such that
*  left_i <= queries[j] <= right_i
* -if no such interval exists -> return -1
*
* return an array output where output[j] is result of query [j]
*
* we can implement algorithm that follows this process:
* 1. sort intervals in ascending order, by start time
*
* 2. create a 2D int array to hold sorted queries:
*    -populate this array by assigning queries their original indices
*
* 3. sort the queries in ascending order by their values
*
* 4. create a min heap to process intervals 
*
* 5. for each interval:
*    -get current query and index
*    -add valid intervals to heap
*    -remove invalid intervals from heap
*    -add smallest possible interval to result
*
* 6. return resulting array
*/
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort intervals in ascending order by start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // create 2D int array to hold sorted queries
        int[][] sortedQueries = new int[queries.length][2];

        // populate array with queries and their indices
        for(int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // sort in ascending order by their values
        Arrays.sort(sortedQueries, (a,b) -> a[0] - b[0]);

        // create min heap to process intervals
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        // create int array to hold result
        int[] result = new int[queries.length];

        // set pointer i to 0
        int i = 0;

        // process each query
        for(int[] query : sortedQueries) {
            // get current query and index
            int q = query[0];
            int index = query[1];

            // add intervals whose start is before query
            while(i < intervals.length && intervals[i][0] <= q) {
                // get left and right interval bounds
                int left = intervals[i][0];
                int right = intervals[i][1];

                // get window size
                int size = right - left + 1;

                // add this interval to heap
                minHeap.offer(new int[]{size, right});

                // advance pointer i
                i++;
            }

            // remove intervals that cannot contain query
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // add smallest valid interval to result
            if(!minHeap.isEmpty()) {
                result[index] = minHeap.peek()[0];

            // no valid intervals
            } else {
                result[index] = -1;
            }
        }

        // return resulting array
        return result;
    }
}
