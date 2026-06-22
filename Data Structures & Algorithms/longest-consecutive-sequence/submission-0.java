class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int best = 0;
        int current = 0;
        int length = 0;
        for(int  num : set){
            if(!set.contains(num-1)){
                current = num;
                length = 1;
                while(set.contains(current+1)){
                    current = current+1;
                    length = length + 1;
                }
                best = Math.max(best, length);
            }
        }

        return best;
    }
}
