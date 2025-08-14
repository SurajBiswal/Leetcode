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

 class Pair{
    int row, col;
    TreeNode node;
    public Pair(TreeNode node, int col){
        this.col=col;
        this.node=node;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q = new LinkedList<>();
	    q.offer(new Pair(root, 0));
	    int max=0;
	    while(!q.isEmpty()){
		    int size = q.size();
            int start = q.peek().col;

		    while(size!=0){
                Pair pair = q.peek();
			    TreeNode node = pair.node;
                int col = pair.col;
			    q.poll();
			    size--;
                if(node.left != null){
                    q.offer(new Pair(node.left, 2*col));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, 2*col+1));
                }
                max = Math.max(max, col-start+1);
            }    
			
		}
        return max;
	}
	
}