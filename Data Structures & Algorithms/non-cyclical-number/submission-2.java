/**
* a non-cyclical number is an integer defined by following algo:
* -given positive int, replace it with sum of squares of its digits
* -repeat above until number is 1, or it loops infinitely in cycle
*  not including 1
* -if it stops at 1, number is non-cyclical
*
* given positive int n, return true if it is non-cyclical, false otherwise
*
* to solve this question, we can implement following algorithms:
* 
* 1. define helper function to calc next num in sequence:
*    -set sum to 0
*
* 2. iterate while number bigger than 0:
*    -extract rightmost digit
*    -update sum to itself + sum of digits squared
*    -update number to itself divided by 10
*
* 3. return final sum
*
* main function:
*
* 1. track slow and fast pointers:
*    -set slow to input n, fast to helper call of n
*
* 2. iterate until fast is 1 and fast and slow meet:
*    -advance slow once
*    -advance fast twice
*
* 3. return whether fast equals 1
*/
class Solution {
    // helper function to calculate next number
    private int getNext(int number) {
        // track sum, start at 0
        int sum = 0;

        // iterate while number bigger than 0
        while(number > 0) {
            // extract rightmost digit
            int digit = number % 10;

            // update sum to itself + digit squared
            sum += digit * digit;

            // update number to itself divided by 10
            number /= 10;
        }

        // return final sum
        return sum;
    }

    // main function
    public boolean isHappy(int n) {
        // track slow and fast pointers
        int slow = n;
        int fast = getNext(n);

        // iterate until fast equals 1 and slow and fast meet
        while(fast != 1 && slow != fast) {
            // move slow once
            slow = getNext(slow);

            // move fast twice
            fast = getNext(getNext(fast));
        }

        // return whether fast reaches 1
        return fast == 1;
    }
}
