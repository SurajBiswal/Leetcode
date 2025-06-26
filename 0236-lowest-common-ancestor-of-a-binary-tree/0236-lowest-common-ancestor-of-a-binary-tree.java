/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     TreeNode temp = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TreeNode temp = new TreeNode();
        helper(root, p, q);
        return temp;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        boolean currentNode = false;
        if(root == p || root == q) currentNode = true;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if((currentNode == true && (left==true || right==true)) || (left==true && right==true)){
            temp = root;
        }
        return currentNode || left || right;
    }
}