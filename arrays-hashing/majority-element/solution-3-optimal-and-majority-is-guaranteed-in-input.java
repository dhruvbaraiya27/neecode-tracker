// Majority Element - Optimal and Majority is guaranteed in input
// Time: O(N) | Space: O(1)
// 

/*
Approach: Boyer-Moore Voting Algorithm

Idea:
- The majority element appears more than n/2 times.
- So even if we cancel it with all other elements, it will still remain.

How it works:
- We keep a candidate and a count.
- If count becomes 0 → we pick a new candidate.
- If current element == candidate → increment count.
- Else → decrement count (cancel out).

Since majority element always exists, the final candidate is the answer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {

            // If count is 0, choose a new candidate
            if (count == 0) {
                candidate = num;
            }

            // If same as candidate → increase count
            if (num == candidate) {
                count++;
            } 
            // Else → decrease count (cancel)
            else {
                count--;
            }
        }

        // Since majority is guaranteed, candidate is the answer
        return candidate;
    }
}