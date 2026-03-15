// Group Anagrams - Optimized Approach
// Time: O(n * k log k) | Space: O(nk)
// 

class Solution {
    //Optimized Approach
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for(List<String> group : map.values()) {
            result.add(group);
        }
        return result;
    }
}