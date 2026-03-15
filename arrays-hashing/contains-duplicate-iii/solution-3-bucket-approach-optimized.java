// Contains Duplicate III - Bucket Approach(Optimized)
// Time: O(N) | Space: O(indexDiff)
// 

import java.util.HashMap;

class Solution {

    /*
    CONTAINS DUPLICATE III — BUCKET APPROACH

    Idea:
    - Maintain a sliding window of size indexDiff
    - Put each number into a bucket of size valueDiff + 1
    - If two numbers fall into the same bucket, their difference is automatically <= valueDiff
    - Also check adjacent buckets because close values can fall into neighboring buckets

    Why bucketSize = valueDiff + 1?
    - So that any two numbers in the same bucket differ by at most valueDiff

    Why use long?
    - To avoid integer overflow while doing subtraction and bucket calculations

    Time Complexity: O(n)
    - Each number is processed once
    - HashMap operations are average O(1)

    Space Complexity: O(indexDiff)
    - At most indexDiff elements are kept in the sliding window
    */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff < 1 || valueDiff < 0) return false;

        HashMap<Long, Long> map = new HashMap<>();
        long bucketSize = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucketId = getBucketId(num, bucketSize);

            // If same bucket already has a number, difference is automatically <= valueDiff
            if (map.containsKey(bucketId)) return true;

            // Check left bucket
            if (map.containsKey(bucketId - 1) &&
                Math.abs(num - map.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // Check right bucket
            if (map.containsKey(bucketId + 1) &&
                Math.abs(num - map.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Put current number into its bucket
            map.put(bucketId, num);

            // Remove the element that is out of the allowed indexDiff window
            if (i >= indexDiff) {
                long oldNum = nums[i - indexDiff];
                long oldBucketId = getBucketId(oldNum, bucketSize);
                map.remove(oldBucketId);
            }
        }

        return false;
    }

    // Handles negative numbers correctly
    private long getBucketId(long num, long bucketSize) {
        if (num >= 0) return num / bucketSize;
        return ((num + 1) / bucketSize) - 1;
    }
}