class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i=0, j=s.length()-1; i < j; ){
            char chI = s.charAt(i);
            if(!((chI >= 'a' && chI <= 'z') || (chI >= '0' && chI <= '9'))){
                i++;
                continue;
            }
            char chJ = s.charAt(j);
            if(!((chJ >= 'a' && chJ <= 'z') || (chJ >= '0' && chJ <= '9'))){
                j--;
                continue;
            }

            if(chI != chJ){
                return false;
            }
            i++;
            j--;
        }

        return true;
        
    }
}
