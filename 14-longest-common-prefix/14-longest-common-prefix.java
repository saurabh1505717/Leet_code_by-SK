class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i=1; i<strs.length; i++){
            String s = strs[i];
            String temp="";
            for(int j=0; j<Math.min(s.length(), common.length()); j++){
                if(common.charAt(j)==s.charAt(j)){
                    temp = temp + common.charAt(j);
                }
                else{
                    break;
                }
            }
            common=temp;
        }
        return common;
    }
}