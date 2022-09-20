class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        return false;
    
    int n = s.length();
    
    HashMap<Character,Character> cc = new HashMap<>();
    HashMap<Character,Boolean>  cb = new HashMap<>();
    
    
    for(int i = 0; i < n;i++)
    {
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(i);
        
        if(cc.containsKey(ch1) == true)
        {
            if(cc.get(ch1) != ch2)
                return false;
        }else
            if(cb.containsKey(ch2) == true)
                return false;
        else
        {
            cc.put(ch1,ch2);
            cb.put(ch2,true);
        }
    }
    return true;
    }
}