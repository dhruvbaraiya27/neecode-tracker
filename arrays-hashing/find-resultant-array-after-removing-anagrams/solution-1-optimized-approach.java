// Find Resultant Array After Removing Anagrams - Optimized Approach
// Time: O(N*k) | Space: O(1)
// 

class Solution {
    //optimized approach
    private boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int num : freq) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word: words) {
            if(result.isEmpty() || !isAnagram(result.get(result.size()-1), word)) {
                result.add(word);
            }
        }
        return result;
    }
}