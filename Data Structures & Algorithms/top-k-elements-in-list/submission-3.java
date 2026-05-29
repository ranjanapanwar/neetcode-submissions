class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        List<Integer> bucket[] = new List[nums.length + 1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int idx = 0;
        int result[] = new int[k];
        for(int count = bucket.length-1; count >=0 && idx < k; count--){
            if(bucket[count] != null){
                for(int num: bucket[count]){
                    if(idx < k){
                        result[idx++] = num;
                    } else {
                        break;
                    }
                }
            }
             
        }
        return result;
    }
}