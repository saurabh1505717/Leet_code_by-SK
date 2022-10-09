class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] parts=s.split(" ");
        if(pattern.length()!=parts.length){
            return false;
        }
        HashMap hm = new HashMap();
        for(Integer i=0; i<parts.length; ++i){
            if(hm.put(pattern.charAt(i),i) != hm.put(parts[i],i)){
                return false;
            }
        }
        return true;
    }
}