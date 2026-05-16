class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort input array in ascending order
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // create 2D array to hold sorted queries
        int[][] sortedQueries = new int[queries.length][2];

        // preserve original indices for queries
        for(int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // sort queries in ascending order
        Arrays.sort(sortedQueries, (a,b) -> a[0] - b[0]);

        // create min heap to process intervals
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        // create int array to hold result
        int[] result = new int[queries.length];

        // initialize pointer i to 0
        int i = 0;

        // traverse each query
        for(int[] query : sortedQueries) {
            // extract current query and index
            int q = query[0];
            int index = query[1];

            // add intervals whose start is before query
            while(i < intervals.length && intervals[i][0] <= q) {
                // get left and right bounds
                int left = intervals[i][0];
                int right = intervals[i][1];

                // get size of interval window
                int size = right - left + 1;

                // add interval to heap
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
            
            // no interval contains query -> return -1
            } else {
                result[index] = -1;
            }
        }

        // return resulting array
        return result;
    }
}
