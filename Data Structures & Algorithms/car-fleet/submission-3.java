class Solution {
    /**
    * we have n cars traveling to same destination on one-lane
    * highway
    *
    * we are given two arrays of integers position and speed, both length n
    * -position[i] is position of ith car, in miles
    * -speed[i] is speed of ith car, in miles per hour
    *
    * destination is at position target miles
    *
    * a car can only catch up to another car and drive same speed, not pass it
    * -if car catches up to fleet the moment fleet reaches target, car joins
    *  fleet
    *
    * return number of different car fleets that arrive at destination
    *
    * to solve this, we could use a sorting approach:
    * 1. pair each car by position and time
    *
    * 2. sort the array in descending order
    *
    * 3. check which cars join fleet
    *
    * 4. return this number
    */
    public int carFleet(int target, int[] position, int[] speed) {
        // init variables
        int numCars = position.length;

        // pair positions with time
        double[][] cars = new double[numCars][2];

        for(int i = 0; i < numCars; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // sort array in descending order
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        // count which cars join fleet
        double prevTime = 0;
        int numFleets = 0;

        for(int i = 0; i < numCars; i++) {
            double time = cars[i][1];

            if(time > prevTime) {
                numFleets++;
                prevTime = time;
            }
        }

        return numFleets;
    }
}
