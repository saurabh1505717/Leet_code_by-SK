class Solution {

    public String reverseWords(String s) {
        String[] parts=s.split(" ");
        String res="";
        String final_res="";
        for(int i=0; i<parts.length; i++){
            String element=parts[i];
            String rstr="";
            for(int j=0; j<element.length(); j++){
                char ch = element.charAt(j);
                rstr=ch+rstr;
            }
            res=res+rstr;
            res+=" ";
        }
        for(int i=0; i<res.length()-1; i++){
            final_res+=res.charAt(i);
            
        }
        return final_res;
    }

}