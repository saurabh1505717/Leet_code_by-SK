/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
		public TreeNode addOneRow(TreeNode root, int val, int depth)
		{
			if(depth==1)
			{
				TreeNode node = new TreeNode(val);
				node.left =root;
				return node;
			}
    Queue<TreeNode> q = new ArrayDeque<>();

    q.add(root);
    depth--;
    while(!q.isEmpty() && depth>0)
    {
        int cap = q.size();
        if(depth==1)
        {
           for(int i=0;i<cap;i++)
           {
               TreeNode node = q.poll();
               TreeNode nl = new TreeNode(val);
               TreeNode nr = new TreeNode(val);
                if(node.left!=null)
                {
                    nl.left =node.left;
                }
                if(node.right!=null)
                {
                   nr.right = node.right;
                }
               node.left = nl;
               node.right= nr;
           }
            
        }
        else{
        for(int i=0;i<cap;i++)
        {
            TreeNode node = q.poll();
            if(node.left!=null)
            {
                q.add(node.left);
            }
            if(node.right!=null)
            {
                q.add(node.right);
            }
        }
        }
        depth--;
    }
    return root;
        }
}