// Majority Element - Optimla and Majority is not guaranteed in output
// Time: O(N) | Space: O(1)
// 

/*
Approach: Boyer-Moore + Verification

Idea:
- First pass: Find a potential candidate using Boyer-Moore.
- Second pass: Verify if the candidate appears more than n/2 times.

Why needed?
- Boyer-Moore only guarantees correct candidate IF majority exists.
- If not, we must verify.

Steps:
1. Find candidate (same as previous logic)
2. Count occurrences of candidate
3. If count > n/2 → return candidate
4. Else → return -1 (no majority)

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find candidate
        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // Check if candidate is truly majority
        if (count > nums.length / 2) {
            return candidate;
        }

        return -1; // No majority element
    }
}