// Contains Duplicate - just bit more optimized than simple set 
// Time: O(N) | Space: O(N)
// Just optimized than simple set because it only calls one operation , no need to call contains() operation.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length ==0) return false;
        HashSet<Integer> set = new HashSet<>();
        boolean returnedValue = false;
        //move throw all elements in the array, and add to hashset
        //set.add(num) return true if you add the element for the first time
        //else if return false(duplicate)

        for(int num : nums) {
            if(!set.add(num)) {
                returnedValue = true;
                break;
            }
        }
        return returnedValue;
        
    }
}