class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // return false immediately if s1 longer
        if(s1.length() > s2.length()) return false;

        // create freq arrays
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // calculate freq arrays
        for(int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // check if arrays match
        if(Arrays.equals(count1, count2)) return true;

        // find matching freqs within window
        int left = 0;

        for(int right = s1.length(); right < s2.length(); right++) {
            count2[s2.charAt(right) - 'a']++;
            count2[s2.charAt(left) - 'a']--;
            left++;

            if(Arrays.equals(count1, count2)) return true;
        }

        return false;
    }
}
