class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        
        char[] s=palindrome.toCharArray();
        
        for(int i=0; i<s.length/2; i++){
            char alphabet=s[i];
            if(alphabet!='a'){
                s[i]='a';
                return String.valueOf(s);
            }
        }
        s[s.length-1]='b';
        return String.valueOf(s);
    }
}