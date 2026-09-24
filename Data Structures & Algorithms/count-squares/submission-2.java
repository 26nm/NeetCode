/**
* we are given stream of points consisting of x-y coordinates on 2d plane
*
* points can be added and queried as follows:
* -add: new points can be added to stream into data structure. dupe points
*  allowed
*
* -query: given single query point, count number of ways to form a square
*
* to solve this question, we can implement following algorithm:
*
* instance variables:
* -------------------
* 1. track point frequency with HashMap
*
* 2. track list of all points with list of integer pairs
*
* add a point:
*-------------
* 1. get x and y pair
*
* 2. encode each pairing
*
* 3. add point to map and list
*
* count # of squares:
* -------------------
* 1. get x and y pair
*
* 2. iterate through the pair as a possible diagonal:
*    -get x2 and y2 pair
*    -skip x and y pair if x and x2 are the same, or
*     if distance between x and x2, or y and y2 are not equal
*    -determine the other two corners
*    -get and multiply their frequencies, add to number of squares
*     that can be formed
*
* 3. return number of squares that can be formed
*/
class CountSquares {
    // instance variables
    private Map<Integer, Integer> count;
    private List<int[]> points;

    // class constructor
    public CountSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        // get x and y pair
        int x = point[0];
        int y = point[1];

        // encode each x and y pair
        int key = x * 1001 + y;

        // put x and y pair into map and list
        count.put(key, count.getOrDefault(key, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        // get x and y pair
        int x = point[0];
        int y = point[1];

        // count # of squares that can be formed, start with 0
        int numSquares = 0;

        // iterate through x and y pair as possible diagonal
        for(int[] diagonal : points) {
            // get x2 and y2 pair
            int x2 = diagonal[0];
            int y2 = diagonal[1];

            // skip this x and y pair if x coordinate is same as
                // query, or if vertical/horizontal distance between
                // x and x2 or y and y2 is not the same
            if(x == x2 || Math.abs(x - x2) != Math.abs(y - y2))
                continue;

            // determine other 2 corners
            int corner1 = x * 1001 + y2;
            int corner2 = x2 * 1001 + y;

            // multiply point frequencies and add to total count
                // of squares that can be formed
            numSquares += count.getOrDefault(corner1, 0)
                * count.getOrDefault(corner2, 0);
        }

        // return # of squares that can be formed
        return numSquares;
    }
}
