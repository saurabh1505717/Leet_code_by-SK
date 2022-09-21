class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int added_element=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]%2==0){
                added_element+=nums[j];
            }
        }
        System.out.println(added_element);
        int[] ans_Array=new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int temp=nums[queries[i][1]];
            int sum = added_element;
            System.out.println(sum);
            nums[queries[i][1]] = nums[queries[i][1]]+queries[i][0];
            if(temp%2==0 && nums[queries[i][1]]%2==0){
                sum=sum-temp+nums[queries[i][1]];
            }
            if(temp%2==0 && nums[queries[i][1]]%2!=0){
                sum=sum-temp;
            }
            if(temp%2!=0 && nums[queries[i][1]]%2==0){
                sum=sum+nums[queries[i][1]];
            }
//             else{
                
//             }
            
            ans_Array[i]=sum;
            System.out.println(sum);
            added_element=sum;
        }
        return ans_Array;
    }
}