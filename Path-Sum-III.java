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
    public int pathSum(TreeNode root, long targetSum) {
        if(root==null)return 0;
        int allPaths =0;
        allPaths+= findPaths(root, targetSum);
        allPaths+= pathSum(root.left, targetSum);
        allPaths+= pathSum(root.right, targetSum);
        return allPaths;
    }

    public int findPaths(TreeNode root, long targetSum){
        if(root==null) return 0;
        
        int count=0;
        if((long)root.val == (long)targetSum) ++count;
        count+= findPaths(root.left, targetSum-root.val);
        count+= findPaths(root.right, targetSum-root.val);
        return count;
    }
}