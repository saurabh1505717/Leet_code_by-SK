//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private boolean dfs(int node, List<List<Integer>>adj, int []vis, int[]check){
        vis[node]=2;
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==0){
                if(dfs(adjNode, adj, vis, check)==true){
                    return true;
                }
            }
            else if(vis[adjNode]==2){
                return true;
            }
        }
        check[node]=1;
        vis[node]=1;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int vis[]=new int[V];
        int check[]=new int[V];
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfs(i, adj, vis, check);
            }
        }
        
        List<Integer>safeNode=new ArrayList<>();
        for(int i=0; i<V; i++){
            if(check[i]==1){
                safeNode.add(i);
            }
        }
        return safeNode;
    }
}
