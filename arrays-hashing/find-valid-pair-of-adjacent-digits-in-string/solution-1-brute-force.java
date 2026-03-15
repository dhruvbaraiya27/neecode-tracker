// Find Valid Pair of Adjacent Digits in String - Brute force
// Time: O(N^2) | Space: O(1)
// 

class Solution {
    //Brute force
    public String findValidPair(String s) {
        int n = s.length();
        for(int i=0; i<n-1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if(a==b) continue;

            int countA=0, countB=0;

            for(int j=0; j<n; j++) {
                if(s.charAt(j) == a) countA++;
                if(s.charAt(j) == b)    countB++;
            }
            int digitA = a - '0';
            int digitB = b - '0';
            if(countA == digitA && countB == digitB) {
                return "" + a + b;
            }
        }
        return "";
    }
}