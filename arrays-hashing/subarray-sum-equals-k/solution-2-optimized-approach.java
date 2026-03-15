// Subarray Sum Equals K - Optimized Approach
// Time: O(N) | Space: O(N)
// 

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;                 // number of subarrays with sum = k
        int sum = 0;                   // running prefix sum

        HashMap<Integer,Integer> map = new HashMap<>();

        // Assume prefix sum 0 appeared once before array starts
        // This helps detect subarrays starting from index 0
        map.put(0,1);

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];   // update running prefix sum

            /*
            Example walk-through for:
            nums = [3,-3,1,1,1], k = 3

            i=0 → sum = 3
            sum-k = 0 → map contains 0 → count++
            subarray = [3]

            i=1 → sum = 0
            sum-k = -3 → not found

            i=2 → sum = 1
            sum-k = -2 → not found

            i=3 → sum = 2
            sum-k = -1 → not found

            i=4 → sum = 3
            sum-k = 0 → map contains 0 again → count++
            subarray = [3,-3,1,1,1]

            Also prefix sum 0 appeared earlier again
            which leads to another valid subarray
            [1,1,1]
            */

            int remaining = sum - k;

            // if prefix sum (sum-k) existed earlier
            // then subarray between them has sum k
            if(map.containsKey(remaining)) {
                count += map.get(remaining);
            }

            // store how many times this prefix sum appears
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}