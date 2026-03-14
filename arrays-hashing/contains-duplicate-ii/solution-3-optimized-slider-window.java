// Contains Duplicate II - Optimized slider window
// Time: O(N) | Space: O(k)
// see comment for notes

import java.util.HashSet;

class Solution {

    /*
    CONTAINS DUPLICATE II — SLIDING WINDOW + HASHSET

    Idea:
    - We only care about duplicates within distance k.
    - Maintain a sliding window of the last k elements using a HashSet.
    - For each number:
        1. Check if it already exists in the set → duplicate within k → return true
        2. Add current number to the set
        3. If window size exceeds k, remove the element that is now out of range

    This ensures the set always stores at most the last k elements.

    --------------------------------------------------

    Time Complexity: O(n)

    - We traverse the array once.
    - HashSet operations (contains, add, remove) are average O(1).

    Total = O(n)

    --------------------------------------------------

    Space Complexity: O(k)

    - The HashSet stores at most k elements because we remove elements
      once the window exceeds size k.

    --------------------------------------------------

    Why Sliding Window Works:

    We only care about elements whose index difference ≤ k.

    So we keep only the last k elements in the set.
    If the current element already exists in this window,
    it means a duplicate appeared within distance k.
    */

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // If k = 0, two different indices cannot have distance ≤ 0
        if (k == 0) return false;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If number already exists in current window → duplicate found
            if (set.contains(nums[i])) {
                return true;
            }

            // Add current number to the sliding window
            set.add(nums[i]);

            // Maintain window size ≤ k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}