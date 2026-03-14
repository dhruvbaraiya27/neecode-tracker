// Valid Anagram - usingHashMap
// Time: O(N) | Space: O(k),k = number of unique characters
// 

if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count characters in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // decrease counts using t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) map.remove(c);
        }

        return map.isEmpty();