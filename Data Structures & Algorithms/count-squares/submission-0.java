class CountSquares {
    // track point frequency
    private Map<Integer, Integer> count;

    // maintain list of all added points
    private List<int[]> points;

    // class constructor
    public CountSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }
    
    // function to add a point to data structure
    public void add(int[] point) {
        // get x and y pair
        int x = point[0];
        int y = point[1];

        // encode each pair
        int key = x * 1001 + y;

        // add x and y pair to map and list
        count.put(key, count.getOrDefault(key, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        // get x and y pair
        int x = point[0];
        int y = point[1];

        // track # of squares, start at 0
        int squares = 0;

        // iterate through each point as a diagonal
        for(int[] diagonal : points) {
            // get x2 and y2 pairs
            int x2 = diagonal[0];
            int y2 = diagonal[1];

            // skip this x and y pair if it shares same
                // x coordinate as query or if
                // horizontal and vertical distances
                // from query is not equal
            if(x == x2 || Math.abs(x - x2) 
                != Math.abs(y - y2)) continue;

            // determine other two corners
            int corner1 = x * 1001 + y2;
            int corner2 = x2 * 1001 + y;

            // multiply their frequencies and add to total 
            squares += count.getOrDefault(corner1, 0)
                * count.getOrDefault(corner2, 0);
        }

        // return # of squares formed
        return squares;
    }
}
