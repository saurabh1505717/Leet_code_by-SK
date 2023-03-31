//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void bfs(int node, ArrayList<ArrayList<Integer>>adj, boolean vis[], Queue<Integer>q){
        vis[node]=true;
        q.add(node);
        while(!q.isEmpty()){
            int nbr=q.poll();
            for(int nbrs:adj.get(nbr)){
                if(vis[nbrs]==false){
                    q.add(nbrs);
                    vis[nbrs]=true;
                }
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);   
                }
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        boolean []vis=new boolean[V];
        int count=0;
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                count++;
                bfs(i, adjList, vis, q);
            }
        }
        return count;
    }
};