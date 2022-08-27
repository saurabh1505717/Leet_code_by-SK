class Solution {
    public int minPartitions(String n) {
        int a = n.length();
        int max=0;
        for(int i=0; i<a; i++){
            int x=n.charAt(i)-48;
            if(x>max){
                max=x;
            }
        }
        return max;
           
    }
}
