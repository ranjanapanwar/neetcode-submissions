class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        int l = 0, r = 0;
        int n = nums.length;

        int[] output = new int[n-k+1];

        while(r < n){

            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(r);
            if(l > dq.peekFirst()){
                dq.removeFirst();
            }

            if(r-l+1 >= k){
                output[l] = nums[dq.peekFirst()];
                l++;
            }

            r++;

        }

        return output;
        
    }
}