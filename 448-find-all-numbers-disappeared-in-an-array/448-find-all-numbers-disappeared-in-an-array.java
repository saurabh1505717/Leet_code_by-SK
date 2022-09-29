class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer>res=new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],1);
        }
        for(int i=1; i<=nums.length; i++){
            if(hm.containsKey(i)==false){
                res.add(i);
            }
        }
        return res;
    }
}