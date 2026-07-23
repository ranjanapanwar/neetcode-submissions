class Solution {
    public String minWindow(String s, String t) {

        if(s.isEmpty() || t.isEmpty()){
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            need.merge(t.charAt(i), 1, Integer::sum);
        }

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> windowMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            windowMap.merge(c, 1, Integer::sum);
            if(need.containsKey(c) && need.get(c).equals(windowMap.get(c))){
                formed++;
            }

            while(required == formed){
                
                if(right-left+1 < minLength){
                    minStart = left;
                    minLength = right-left+1;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if(need.containsKey(leftChar) && windowMap.get(leftChar) < need.get(leftChar)){
                    formed--;
                }
                left++;

            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
        
    }
}