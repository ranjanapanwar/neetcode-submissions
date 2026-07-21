class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < n; i++){
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if(matches(need, window)){
            return true;
        }

        int left = 0;

        for(int right = n; right < m ; right++){
            window[s2.charAt(right) - 'a']++;
            left = right - n;
            window[s2.charAt(left) - 'a']--;

            if(matches(need, window)){
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] need, int[] window){
        for(int i = 0; i < 26; i++){
            if(! (need[i] == window[i])){
                return false;
            }
        }
        return true;
    }
}