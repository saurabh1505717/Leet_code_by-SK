class Allocator {
    int arr[];

    public Allocator(int n) {
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=-1;
        }
    }
    
    public int allocate(int size, int mID) {
        // if(size>arr.length){
        //     return -1;
        // }
        int startIndex=0, count=0, flag=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==-1){
                count++;
                if(count==size){
                    flag=1;
                    break;
                }
            }
            else{
                count=0;
                startIndex=i+1;
            }
        }
        
        if(flag==1){
            for(int k=startIndex; k<=startIndex+size-1; k++){
                arr[k]=mID;
            }
            return startIndex;
        }
        return -1;
    }
    
    public int free(int mID) {
        int count=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==mID){
                arr[i]=-1;
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */