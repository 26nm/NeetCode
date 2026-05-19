/**
* there are n gas stations along circular route
* -given 2 int arrays gas and cost where:
*  -gas[i] is amount of gas at ith station
*  -cost[i] is amount of gas needed to travel from
*   ith station to (i + 1)th station
*
* vehicle can store unlimited amount of gas, but you start with empty tank
*
* return starting gas station index such that you can complete circuit once
* clockwise, return -1 otherwise
*
* to solve this, we can implement following algorithm:
* 1. track total gas and cost, start at 0
*    -compute totals for both
*
* 2. check if total cost exceeds total gas:
*    -return -1 if so (impossible to complete)
*
* 3. set starting point to 0
*    -track tank state, start at 0
*
* 4. traverse through each gas station:
*    -update tank state as itself plus gas - cost
*    -if tank becomes negative -> move to next gas station
*     -reset tank to 0
*
* 5. return index of starting gas station
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // track total gas and cost, start at 0
        int totalGas = 0;
        int totalCost = 0;

        // calc total gas and cost
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // if total cost exceeds total gas -> impossible to do route
        if(totalCost > totalGas) return -1;

        // track tank state, start at 0
        int tank = 0;

        // track starting point, start at 0
        int start = 0;

        // iterate through stations
        for(int i = 0; i < gas.length; i++) {
            // update tank state as itself plus gas - cost
            tank += gas[i] - cost[i];

            // if tank is negative -> change gas station and reset tank
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // return index of gas station
        return start;
    }
}
