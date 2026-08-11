class Solution {
    // helper function to calculate next number
    private int getNext(int number) {
        // set sum to 0
        int sum = 0;

        // iterate while number bigger than 0
        while(number > 0) {
            // extract rightmost digit
            int digit = number % 10;

            // update sum to itself plus digit squared
            sum += digit * digit;

            // update number to itself divided by 10
            number /= 10;
        }

        // return final sum
        return sum;
    }

    public boolean isHappy(int n) {
        // track fast and slow pointers, set slow to
            // input and fast to output of
            // recursive function
        int slow = n;
        int fast = getNext(n);

        // iterate until fast is 1 and slow meets fast
        while(fast != 1 && slow != fast) {
            // move slow forward once
            slow = getNext(slow);

            // move fast twice
            fast = getNext(getNext(fast));
        }

        // return whether fast is 1
        return fast == 1;
    }
}
