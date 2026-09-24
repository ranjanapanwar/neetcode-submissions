class Solution {
    public int minEatingSpeed(int[] piles, int h) {

            int l = 1;
            int r = Arrays.stream(piles).max().getAsInt();

            int result = r;

            while(l <= r){
                int m = l + (r - l)/2;
                long total = 0;
                for(int a: piles){
                    total += Math.ceil((double) a / m);
                }
                if(total <= h){
                    result = m;
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }

            return result;
        
    }
}
