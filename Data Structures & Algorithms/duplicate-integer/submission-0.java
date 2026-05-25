class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet hashset = new HashSet();
        for(int i=0; i<nums.length; i++){
            if(!hashset.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}