class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> nums = new HashMap<>();
        int result[] = new int[2];
        for(int i=0; i< numbers.length; i++){
            nums.put(numbers[i], i+1);
        }

        for(int i=0; i< numbers.length; i++){
            int rem = target - numbers[i];
            if(nums.containsKey(rem) && nums.get(rem) != i+1){
                
                result[0] = nums.get(rem) < i+1 ? nums.get(rem) : i+1;
                result[1] = nums.get(rem) > i+1 ? nums.get(rem) : i+1;
                return result;
            }

        }
        return result;
        
    }   
}
