// Valid Anagram - Brute Force
// Time: O(NlogN) | Space: O(N)
// 

class Solution {
    public boolean isAnagram(String s, String t) {
        //Brute force
        if(s.length() != t.length())    return false;
        char[] c = s.toCharArray();
        char[] p = t.toCharArray();

        Arrays.sort(c);
        Arrays.sort(p);

        return Arrays.equals(c,p);
    }
}