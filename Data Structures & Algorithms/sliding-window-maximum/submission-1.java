class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length - (k-1);
        int[] result = new int[n];

        int max = Integer.MIN_VALUE;
        int left = 0;
        int m = 0;

        for(m=0; m < k; m++){
            max = Math.max(max, nums[m]);
        }
        result[0] = max;
        
        for(int right=m; right < nums.length; right++ ){
            if (nums[right-k] == max) {
                max = Integer.MIN_VALUE;
                for (int i = right - k + 1; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                }
            } else {
                max = Math.max(max, nums[right]);
            }
            result[right-k+1] = max;
        }

        return result;
    }
}