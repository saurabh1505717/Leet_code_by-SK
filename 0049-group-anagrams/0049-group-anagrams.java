class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==1){
            List<String> list=new ArrayList<>();
            list.add(strs[0]);
            List<List<String>> res=new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> res=new ArrayList<>();
        HashMap<String, List<String>>hm=new HashMap<>();
        for(String word:strs){
            char[] arr=word.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(hm.containsKey(key)){
                hm.get(key).add(word);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(word);
                hm.put(key, list);
            }
        }
        // for(String s:hm.keySet()){
        //     List<String> ansList=hm.get(s);
        //     res.add(ansList);
        // }
        // return res;
        
        return new ArrayList<>(hm.values());
    }
}