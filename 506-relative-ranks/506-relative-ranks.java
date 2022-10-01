class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        String[] ans=new String[score.length];
        for(int i=0; i<score.length; i++){
            hm.put(score[i],i);
        }
        for(int i=0; i<score.length; i++){
            pq.add(score[i]);
        }
        int count=1;
        int val=pq.peek();
        int index=hm.get(val);
        ans[index]="Gold Medal";
        pq.remove();
        count++;
        if(pq.size()>0){
            val=pq.peek();
            index=hm.get(val);
            ans[index]="Silver Medal";
            pq.remove();
            count++;
        }
        
        if(pq.size()>0){
            val=pq.peek();
            index=hm.get(val);
            ans[index]="Bronze Medal";
            pq.remove();
            count++;
        }
        
        while(pq.size()>0){
            val=pq.peek();
            index=hm.get(val);
            ans[index]=count+"";
            pq.remove();
            count++;
        }
        return ans;
    }
}