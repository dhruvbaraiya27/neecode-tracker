// Valid Anagram - Optimized
// Time: O(N) | Space: O(1)
// See notes in code comment

import java.util.HashMap;

class Solution {

    /*
    VALID ANAGRAM — HASHMAP APPROACH

    Idea:
    - Count frequency of characters in string s
    - Decrease frequency using characters from string t
    - If a character doesn't exist or count becomes invalid → not an anagram
    - If all counts match, map becomes empty → valid anagram

    Time Complexity: O(n)
    - Traverse s once → O(n)
    - Traverse t once → O(n)
    - HashMap operations (put/get/remove) are average O(1)

    Space Complexity: O(k)
    - k = number of unique characters
    - Worst case O(n) if all characters are different

    -----------------------------------------------------

    When to use ARRAY instead of HashMap:

    If character set is fixed and small, array is faster and uses less memory.

    1️⃣ Lowercase letters only (a–z)
        int[] count = new int[26]

    2️⃣ Standard ASCII characters
        int[] count = new int[128]

    3️⃣ Extended ASCII
        int[] count = new int[256]

    Why array is faster:
    - Direct index access (no hashing)
    - No object overhead
    - Less memory usage

    -----------------------------------------------------

    What is ASCII?

    ASCII = American Standard Code for Information Interchange

    It maps characters to numeric values.

    Examples:
    'A' = 65
    'a' = 97
    '0' = 48
    ' ' = 32

    Standard ASCII size = 128 characters (0–127)
    Extended ASCII size = 256 characters (0–255)

    -----------------------------------------------------

    When to use HashMap:

    Use HashMap<Character, Integer> when:
    - Character set is unknown
    - Unicode characters are possible
    - Input may contain emojis or non-English characters

    Example:
    "你好🙂abc"

    In this case array indexing isn't practical.

    -----------------------------------------------------

    Quick Interview Rule:

    Lowercase only → int[26]
    ASCII characters → int[128]
    Extended ASCII → int[256]
    Unicode / unknown characters → HashMap
    */

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())    return false;
        int[] freqMap = new int[26];
        for(int i=0; i<s.length(); i++) {
            freqMap[s.charAt(i) - 'a']++;
            freqMap[t.charAt(i) - 'a']--;
        }
        for(int num : freqMap) {
            if(num!=0)  return false;
        }
        return true;
    }
}