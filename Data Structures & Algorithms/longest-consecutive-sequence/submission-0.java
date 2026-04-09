class Solution {
    /**
    * we are given an integer array
    *
    * we are asked to find longest consecutive sequence possible
    * -a consecutive sequence is a sequence in which each element
    *  is exactly 1 greater than previous element
    *
    * input: [2, 20, 4, 10, 3, 4, 5]
    *
    * 2 is start of sequence because it doesn't have a (num - 1) and it has (num + 1)
    * output: 4 [2, 3, 4, 5]
    *
    * since no dupes are allowed, we can use HashSet
    *
    * elements in original array do not have to be consecutive
    *
    * we could:
    * 1. convert the array to a set
    * 2. iterate through set:
    *    -if the number doesn't have a num - 1, we start sequence
    *    -then perhaps update start of sequence to num + 1?
    */ 
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        // convert to set
        for(int n : nums) {
            seen.add(n);
        }

        int longest = 0;

        // find and add sequence starters
        for(int num : seen) {
            if(!seen.contains(num - 1)) {
                int current = num;
                int length = 1;

                while(seen.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
