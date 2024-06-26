//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // public class Pair{
    //     int node;
    //     int parent;
    //     Pair(int _node, int _parent){
    //         this.node=_node;
    //         this.parent=_parent;
    //     }
    // }
    
    // public boolean detectCycleBFS(int src, int V, ArrayList<ArrayList<Integer>>adj, boolean[]vis){
    //     vis[src]=true;
    //     Queue<Pair>q=new LinkedList<>();
    //     q.add(new Pair(src, -1));
    //     while(!q.isEmpty()){
    //         int currNode=q.peek().node;
    //         int parentNode=q.peek().parent;
    //         q.remove();
            
    //         for(Integer it:adj.get(currNode)){
    //             if(vis[it]==false){
    //                 vis[it]=true;
    //                 q.add(new Pair(it, currNode));
    //             }
    //             else if(parentNode!=it){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    private boolean detectCycleDFS(int node, int parent,  int []vis, ArrayList<ArrayList<Integer>>adj){
        vis[node]=1;
        for(int adjacentNode:adj.get(node)){
            if(vis[adjacentNode]==0){
                if(detectCycleDFS(adjacentNode, node, vis, adj)==true){
                    return true;
                }
            }
                else if(adjacentNode!=parent){
                    return true;
                }

        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // boolean[] vis=new boolean[V];
        // Arrays.fill(vis, false);
        // for(int i=0; i<V; i++){
        //     if(vis[i]==false){
        //         if(detectCycleBFS(i, V, adj, vis)==true){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        int[] vis=new int[V];
        // Arrays.fill(vis, false);
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                if(detectCycleDFS(i, -1, vis, adj)==true){
                    return true;
                }   
            }
        }
        return false;
    }
}