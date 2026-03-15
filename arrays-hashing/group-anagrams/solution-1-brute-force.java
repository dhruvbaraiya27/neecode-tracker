// Group Anagrams - Brute force
// Time: O(N^2 * k), k = average length of each string | Space: O(N)(because of boolean Array)
// 

class Solution {
    //brute force
    private boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        int[] freq = new int[26];
        for(int i=0; i< s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int num : freq) {
            if(num !=0) return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for(int i=0; i< strs.length; i++) {
            if(used[i]) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i]=true;
            for(int j=i+1; j< strs.length; j++) {
                if(!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j]=true;
                }
            }
            result.add(group);

        }
        return result;
    }
}