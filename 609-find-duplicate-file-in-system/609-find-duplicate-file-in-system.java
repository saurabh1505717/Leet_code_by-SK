class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>>Hm=new HashMap<>();
        
        for(String path:paths){
            String[] arr=path.split(" ");
            
            String directory = arr[0];
            for(int i=1; i<arr.length; i++){
                String filename=arr[i].substring(0,arr[i].indexOf("("));
                String content=arr[i].substring(arr[i].indexOf("(")+1, arr[i].length()-1);
                List<String>filepaths=Hm.getOrDefault(content,new ArrayList<>());
                filepaths.add(directory+"/"+filename);
                Hm.put(content, filepaths);
            }
        }
        Hm.entrySet().removeIf(entry -> entry.getValue().size()<2);
        
        return new ArrayList<>(Hm.values());
    }
}