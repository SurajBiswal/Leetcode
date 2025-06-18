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
    private int node=-1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return node;
    }

    public int helper(TreeNode root, int k) {
        if(root==null || node>=0)return k;
        k = helper(root.left, k);
        k = k-1;
        if(k==0){
            node = root.val;
        } 
        k = helper(root.right, k);
        return k;
    }
}