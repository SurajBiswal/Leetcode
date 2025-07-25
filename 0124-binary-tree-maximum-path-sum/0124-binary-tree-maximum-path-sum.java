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
    public int maxPathSum(TreeNode root) {
        int [] ans = {root.val};
        helper(root, ans);
        return ans[0];
    }
    public int helper(TreeNode root, int[]ans){
        if(root==null) return 0;
        int left = Math.max(0, helper(root.left, ans));
        int right = Math.max(0, helper(root.right, ans));
        ans[0] = Math.max(ans[0], left + right + root.val);
        return Math.max(left, right)+root.val;
    }
}