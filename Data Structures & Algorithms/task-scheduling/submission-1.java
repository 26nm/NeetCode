/**
* we are given array of CPU tasks tasks, where tasks[i] is uppercase English
* character from A to Z
* -also given integer n
*
* each CPU cucle allows completion of single task, and tasks may be completed
* in any order
*
* only constraint being identical tasks must be separated by at least N CPU
* cycles to cooldown CPU
*
* return min number of CPU cycles to complete all tasks
*
* to solve this question, we maintain max heap + cooldown queue:
* 1. count task freqs
*    -move existing tasks to heap
*
* 2. create a cooldown queue
*
* 3. while task heap not empty or cooldown queue not empty:
*    -increase passage of time
*    -if task heap not empty -> execute task, decrease freq
*    -if task still exists -> add to cooldown queue
*    -if task still available -> move it back to the task heap
*
* 4. return passage of time
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // create freq array to track task freqs
        int[] taskFreq = new int[26];

        // cal task freqs
        for(char task : tasks) {
            taskFreq[task - 'A']++;
        }

        // create task heap
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // transfer existing tasks to task heap
        for(int freq : taskFreq) {
            if(freq > 0) {
                maxHeap.offer(freq);
            }
        }

        // create cooldown queue
        Queue<int[]> cooldown = new LinkedList<>();

        // track time elapsed
        int time = 0;

        // execute tasks until either task heap or cooldown queue empty
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            // elapse time
            time++;

            // if task heap not empty -> execute highest freq task, decrease freq
            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;

                // if task still exists -> add to cooldown
                if(count > 0) {
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            // if task at front of queue stil avail -> add back to heap
            if(!cooldown.isEmpty() &&
                cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        // return cycles completed
        return time;
    }
}
