class Solution {
    /**
    * there are n cars traveling to same destination on one-lane highway
    *
    * we are given two arrays of integers position and speed, both of n length
    * -position[i] is position of ith car (in miles)
    * -speed[i] is speed of ith car (in mph)
    * -destination is at position target miles
    * -car DOES NOT pass another ahead of it (only catches up and keep same speed)
    * 
    * return the number of different car fleets that will arrive at destination
    */
    public int carFleet(int target, int[] position, int[] speed) {
        // init variables
        int n = position.length;

        // pair position with time to target
        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0;

        // count which cars join fleets
        for(int i = 0; i < n; i++) {
            double time = cars[i][1];

            if(time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}
