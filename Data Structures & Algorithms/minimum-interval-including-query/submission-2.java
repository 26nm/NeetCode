/**
* we are given 2D int array intervals
*
* we are also given integer array of query points queries
* -result of query[j] is length of shortest interval i such that
*  left_i <= queries[j] <= right_i
* -if no such interval exists, result of query is -1
*
* return array output where output[j] is result of query[j]
*
* to solve this question, we can implement algorithm following this 
* process:
* 1. sort interval array in ascending order, by start times
*
* 2. create 2D int array to hold sorted queries
*    -populate this array with queries and their indices
*
* 3. sort queries in ascending order by their values
*
* 4. create an int array to hold results
*
* 5. create a min heap to process intervals
*
* 6. initialize pointer i to keep track of intervals
*
* 7. for each query:
*    -get current query and index
*    -add intervals whose start is before query
*    -remove invalid intervals
*    -add remaining intervals to result
*
* 8. return resulting array
*/
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort intervals in ascending order by start times
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // create 2D array to hold sorted queries
        int[][] sortedQueries = new int[queries.length][2];

        // populate sorted queries with queries and their indices
        for(int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // sorted queries array in ascending order by value
        Arrays.sort(sortedQueries, (a,b) -> a[0] - b[0]);

        // create min heap to process intervals
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        
        // create result array
        int[] result = new int[queries.length];

        // create pointer i and set to 0
        int i = 0;

        // traverse each query
        for(int[] query : sortedQueries) {
            // current query and index
            int q = query[0];
            int index = query[1];

            // add intervals whose start is before query to heap
            while(i < intervals.length && intervals[i][0] <= q) {
                // get left and right interval bounds
                int left = intervals[i][0];
                int right = intervals[i][1];

                // get interval size
                int size = right - left + 1;

                // add to heap
                minHeap.offer(new int[]{size, right});

                // advance i
                i++;
            }

            // remove invalid intervals
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // add remaining intervals to result
            if(!minHeap.isEmpty()) {
                result[index] = minHeap.peek()[0];

            // no valid queries
            } else {
                result[index] = -1;
            }
        }

        // return resulting array;
        return result;
    }
}
