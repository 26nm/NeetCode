class Solution {
    /**
    * we have n cars traveling to same destination on
    * one-lane highway
    *
    * we are given two arrays of integers position and speed,
    * both of length n
    * -position[i] is position of ith car (in miles)
    * -speed[i] is speed of ith car (in mph)
    *
    * if car catched up to car fleet when it reaches destination,
    * car joins fleet
    *
    * return number of different car fleets arriving
    *
    * to solve this, we could:
    * 1. pair each car with times
    * 
    * 2. sort array in decreasing order
    *
    * 3. determine which cars join fleets
    *
    * 4. return result
    */
    public int carFleet(int target, int[] position, int[] speed) {
        // init variables
        int n = position.length;

        // pair position with time to target
        double[][]cars = new double[n][2];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // sort by descending order
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
