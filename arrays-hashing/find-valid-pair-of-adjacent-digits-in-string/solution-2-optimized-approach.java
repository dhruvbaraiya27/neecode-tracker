// Find Valid Pair of Adjacent Digits in String - Optimized Approach
// Time: O(N) | Space: O(1)
// 

class Solution {
    //Optimized Approach
    public String findValidPair(String s) {
        int freq[] = new int[10];
        int n = s.length();
        for(char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        for(int i=0; i<n-1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if(a==b)    continue;
            if(freq[a - '0'] == a - '0' && freq[b - '0'] == b - '0')
            {
                return s.substring(i,i+2);
            }
        }
        return "";
    }
}