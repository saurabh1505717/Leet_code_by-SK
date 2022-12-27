class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int []diffArray=new int[rocks.length];
        for(int i=0; i<rocks.length; i++){
            diffArray[i]=capacity[i]-rocks[i];
        }
        
        Arrays.sort(diffArray);
        int count=0;
        for(int i=0; i<diffArray.length; i++){
            if(additionalRocks>0 && additionalRocks-diffArray[i]>=0){
                additionalRocks-=diffArray[i];
                diffArray[i]=0;
                count++;
            }
        }
        return count;
    }
}