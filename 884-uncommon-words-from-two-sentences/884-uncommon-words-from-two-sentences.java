class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] words1=s1.split(" ");
        String[] words2=s2.split(" ");
        for(int i=0; i<words1.length; i++){
            if(hm.containsKey(words1[i])){
                int of=hm.get(words1[i]);
                int nf=of+1;
                hm.put(words1[i], nf);
            }else{
                hm.put(words1[i],1);
            }
        }
        
        for(int i=0; i<words2.length; i++){
            if(hm.containsKey(words2[i])){
                int of=hm.get(words2[i]);
                int nf=of+1;
                hm.put(words2[i], nf);
            }else{
                hm.put(words2[i],1);
            }
        }
        
        ArrayList<String>ans=new ArrayList<>();
        for(String key:hm.keySet()){
            Integer val=hm.get(key);
            if(val==1){
                ans.add(key);
            }
        }
        
        String[] f_ans=new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            String element=ans.get(i);
            f_ans[i]=element;
        }
        return f_ans;
    }
}