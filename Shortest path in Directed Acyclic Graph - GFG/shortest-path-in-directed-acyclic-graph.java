//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

    class Pair{
        int secNode;
        int weight;
        Pair(int _secNode, int _weight){
            this.secNode=_secNode;
            this.weight=_weight;
        }
    }

class Solution {
    public void topoSort(int node, ArrayList<ArrayList<Pair>>adj, int []vis, Stack<Integer>st){
        vis[node]=1;
        for(int i=0; i<adj.get(node).size(); i++){
            int v=adj.get(node).get(i).secNode;
            if(vis[v]==0){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    
	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
		for(int i=0; i<N; i++){
		    ArrayList<Pair>temp=new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i=0; i<M; i++){
		    int first=edges[i][0];
		    int second=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(first).add(new Pair(second, wt));
		}
		
		int vis[]=new int[N];
		Stack<Integer>st=new Stack<>();
		for(int i=0; i<N; i++){
		    if(vis[i]==0){
		        topoSort(i, adj, vis, st);
		    }
		}
		
		int dist[]=new int[N];
		for(int i=0; i<N; i++){
		    dist[i]=(int)1e9;
		}
		dist[0]=0;
		
		while(!st.isEmpty()){
		    int node=st.pop();
		    for(int i=0; i<adj.get(node).size(); i++){
		        int nbrVcs=adj.get(node).get(i).secNode;
		        int nbrWt=adj.get(node).get(i).weight;
		        
		        if(dist[node]+nbrWt < dist[nbrVcs]){
		            dist[nbrVcs]=dist[node]+nbrWt;
		        }
		    }
		}
		
		for(int i=0; i<N; i++){
		    if(dist[i]==1e9){
		        dist[i]=-1;
		    }
		}
		return dist;
	}
}