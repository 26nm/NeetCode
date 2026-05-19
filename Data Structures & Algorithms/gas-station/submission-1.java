class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // track total gas and cost
        int totalGas = 0;
        int totalCost = 0;

        // compute total gas and costs
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // return -1 if impossible to complete circuit
        if(totalGas < totalCost) return -1;

        // track starting point, start at 0
        int start = 0;

        // track tank state, start at 0
        int tank = 0;

        // iterate through gas stations
        for(int i = 0; i < gas.length; i++) {
            // calc tank state as itself plus gas - cost
            tank += gas[i] - cost[i];

            // if curr start fails -> move to new station and reset tank
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // return starting gas station index
        return start;
    }
}
