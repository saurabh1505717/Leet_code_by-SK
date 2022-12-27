class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // Arrays.sort(capacity);
        // Arrays.sort(rocks);
        
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
//             else if(additionalRocks>0 && additionalRocks-dffArray[i]<0){
                
//             }
        }
        
        
        
        
        
    //     for(int i=0; i<rocks.length; i++){
    //         int diff=capacity[i]-rocks[i];
    //         if(diff!=0){
    //             if(additionalRocks>0 && (additionalRocks-diff)>=0){
    //                 rocks[i]=rocks[i]+diff;
    //                 additionalRocks-=diff;
    //             }
    //             else if(additionalRocks>0 && (additionalRocks-diff)<0){
    //                 rocks[i]=rocks[i]+additionalRocks;
    //                 additionalRocks=0;
    //                 break;
    //             }
    //         }
    //         else{
    //             continue;
    //         }
    //     }
    //     int count=0;
    //     for(int i=0; i<rocks.length; i++){
    //         if(rocks[i]==capacity[i]){
    //             count++;
    //         }
    //         else{
    //             continue;
    //         }
    //     }
    return count;
    }
}