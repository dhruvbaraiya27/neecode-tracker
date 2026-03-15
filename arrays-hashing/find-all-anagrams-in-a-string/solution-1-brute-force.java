// Find All Anagrams in a String - Brute force
// Time: O(nm) | Space: O(m)
// Interview Note — Space Complexity

Space Complexity = total memory used by the algorithm.

In interviews, it usually means Auxiliary Space.

Auxiliary Space = extra temporary memory used excluding input and output.

Rule:

If interviewer asks space complexity → say auxiliary space.

If asked including output → add result storage.

Example:

Time Complexity: O(n * m)
Space Complexity: O(m)   (auxiliary)

class Solution {
    private boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int freq[] = new int[26];
        for(int i=0; i< s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int num : freq) {
            if(num!=0)  return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i < n-m+1; i++) {
            if(isAnagram(s.substring(i,i+m), p)) {
                result.add(i);
            }   
        }
        return result;
    }
}