class Solution {
    public int leastInterval(char[] tasks, int n) {
        // create freq array to hold tasks
        int[] freq = new int[26];

        // calc freqs for each task
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        // make max heap to process tasks
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Collections.reverseOrder());

        // insert existing tasks into heap
        for(int count : freq) {
            if(count > 0) {
                maxHeap.offer(count);
            }
        }

        // make a queue to process task cooldown
        Queue<int[]> cooldown = new LinkedList<>();

        // track time to complete all tasks
        int time = 0;

        // execute tasks while neither task heap nor cooldown queue empty
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            // increase time
            time++;

            // if heap not empty -> execute highest freq task
            if(!maxHeap.isEmpty()) {
                // decrease task freq
                int count = maxHeap.poll() - 1;

                // if task still exists -> add to cooldown
                if(count > 0) {
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            // if task at front of queue still avail -> move it back to heap
            if(!cooldown.isEmpty() &&
                cooldown.peek()[1] == time) {
                    // move task back to heap
                    maxHeap.offer(cooldown.poll()[0]);
            }
        }

        // return final time tracked
        return time;
    }
}
