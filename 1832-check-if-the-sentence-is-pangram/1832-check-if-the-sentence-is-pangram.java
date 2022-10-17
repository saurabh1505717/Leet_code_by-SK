class Solution {
    public boolean checkIfPangram(String sentence) {
        // char []array=sentence.toCharArray();
        // Arrays.sort(array);
        
        HashMap<Character, Boolean> hm=new HashMap<>();
        
        for(char ch='a'; ch<='z'; ++ch){
            hm.put(ch,true);
        }
        // for(String chs:hm.keySet()){
        //     System.out.println(chs+":"+hm.get(chs));
        // }
        int count=0;
        for(int i=0; i<sentence.length(); i++){
            // System.out.println(count);
            char c=sentence.charAt(i);
            // System.out.println(c);
            if(hm.containsKey(c)){
                
                if(hm.get(c)==true){
                    count++;
                }
                hm.put(c,false);
            }
        }
        System.out.println(count);
        if(count==26){
            return true;
        }
        return false;
    }
}