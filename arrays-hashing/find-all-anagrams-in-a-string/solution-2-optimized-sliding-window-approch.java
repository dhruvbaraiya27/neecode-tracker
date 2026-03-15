// Find All Anagrams in a String - Optimized Sliding Window Approch
// Time: O(N) | Space: O(1)
// 

class Solution {
    //Optimized Approach
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        int[] pFreq = new int[26];
        int[] window = new int[26];
        for(char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        for(int i=0; i<n; i++) {
            window[s.charAt(i)-'a'] ++;
            if(i>=m) {
                window[s.charAt(i-m) - 'a']--;
            }
            if(Arrays.equals(window, pFreq)) {
                result.add(i-m+1);
            }

        }
        return result;
    }
}