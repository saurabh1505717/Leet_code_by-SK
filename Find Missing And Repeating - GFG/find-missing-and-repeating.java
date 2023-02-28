//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        HashMap<Integer, Integer>hm=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i])){
                int of=hm.get(arr[i]);
                hm.put(arr[i], of+1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        
        // System.out.println(hm);
        
        int ans[]=new int[2];
        for(int i=1; i<=n; i++){
            if(hm.containsKey(i)){
                int val=hm.get(i);
                if(val==2){
                    ans[0]=i;
                }
            }
            if(!hm.containsKey(i)){
                ans[1]=i;
            }
        }
        return ans;
    }
}