/**
* we are given a 2D array points where points[i] = [xi, yi]
* represents the coordinates of a point on an X-Y axis plane,
* along with an integer k
*
* return the k closest points to the origin (0, 0)
*
* distance between two points defined as Euclidean distance
* sqrt((x1 - x2)^2 + (y1 - y2)^2))
*
* k closest to origin should mean:
*
* return maximum values, as their distance from origin DECREASES
*
* so use a maxHeap for this question
*/
class Solution {
    // helper function to calculate Euclidean distance
    private int distance(int[] point) {
        // set x and y
        int x = point[0];
        int y = point[1];

        // return distance as x² + y²
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {
        // create priority queue to process coordinates
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a));

        // process each coordinate pair
        for(int[] point : points) {
            maxHeap.offer(point);

            // if heap full -> remove furthest point from origin
            if(maxHeap.size() > k) maxHeap.poll();
        }

        // create 2D array to hold result
        int[][] result = new int[k][2];

        // transfer k farthest from heap
        for(int i = 0; i < k; i++) {
            result[i] =  maxHeap.poll();
        }

        // return resulting array
        return result;
    }
}
