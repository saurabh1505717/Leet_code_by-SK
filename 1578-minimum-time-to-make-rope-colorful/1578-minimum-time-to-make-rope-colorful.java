class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        int pos=0;
        for(int i=1;i<colors.length();i++){
			//update pos based on the character's time
            if(colors.charAt(i)==colors.charAt(pos)){
                if(neededTime[i]<neededTime[pos]){
                    cost+=neededTime[i];
                }
                else{
                    cost+=neededTime[pos];
                    pos=i; 
                }
            }
            else{
                pos=i;
            }
        }
        return cost;
    }
}