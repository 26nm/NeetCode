/**
* you are given two strings s and t, both consisting of english letters
*
* return number of distinct subsequences of s which are equal to t
*
* to solve this question, we can implement following algorithm:
* 1. get lengths of strings s and t (set as m and n, respectively)
*    -create dp array of size n + 1
*    -set last element to 1 (always 1 way to form empty target)
*
* 2. iterate through string s from right to left:
*    -store # of ways to generate current char, store this as prev
*    -iterate through string t from right to left:
*     -store current value before going to next, store this as temp
*     -if i in string s matches j in string t -> increase # of ways
*      to get character
*    -update prev to temp
*
* 3. return 1st elem in dp (most recent step)
*/
class Solution {
    public int numDistinct(String s, String t) {
        // get lengths of both input strings
        int m = s.length();
        int n = t.length();

        // create 1d dp array of size n+1
        long[] dp = new long[n + 1];

        // set last element to 1 (always 1 way to form empty target)
        dp[n] = 1;

        // iterate through string s, from right to left
        for(int i = m - 1; i >= 0; i--) {
            // store previous value, set this to n in dp
            long prev = dp[n];

            // iterate through string t, from right to left
            for(int j = n - 1; j >= 0; j--) {
                // store current value before replacing, set this to
                    // j in dp
                long temp = dp[j];

                // if i in string s matches j in string t ->
                    // add number of ways to get dp[j]
                if(s.charAt(i) == t.charAt(j)) dp[j] += prev;

                // update previous value to temp
                prev = temp;
            }
        }

        // return 1st element in dp
        return (int) dp[0];

    }
}
