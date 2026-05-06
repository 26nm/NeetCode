/**
* we are given a 2d array points where points[i] = [xi, yi]
* -this represents coordinates of a point on X-Y axis plane
* -also given an integer k
*
* return k closest points to the origin at (0, 0)
*
* to solve this question, we maintain a max heap and compare
* point distances using following formula:
* -x² + y²:
* 1. create priority queue in decreasing order for max heap
*
* 2. add each pair to the heap
*
* 3. create 2D array to store result (k x 2)
*
* 4. transfer contents from heap to this array:
*    -if heap is full -> transfer furthest point to
*    -resulting array
*
* 5. return resulting array
*/
class Solution {
    // helper function to calculate Euclidean distance
    private int distance(int[] point) {
        // set x & y
        int x = point[0];
        int y = point[1];

        // return x² + y²
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {
        // create priority queue to process coordinates
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a));

        // process each coordinate and add to heap
        for(int[] point : points) {
            maxHeap.offer(point);

            // if heap size exceeds k, remove from heap
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // create 2D array (k x 2) to hold result
        int[][] result = new int[k][2];

        // transfer k farthest points to resulting array
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        // return resulting array
        return result;
    }
}
