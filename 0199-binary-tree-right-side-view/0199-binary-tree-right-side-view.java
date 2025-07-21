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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        int[]max = {-1};
        helper(root, 0, max, list);
        return list;
    }
    public void helper(TreeNode root, int level, int[] max, List<Integer>list){
        if(root==null) return;
        if(level > max[0]){
            list.add(root.val);
            max[0]= level;
        }
        if(root.right != null){
            helper (root.right, level+1, max, list);
        }

        if(root.left != null){
            helper (root.left, level+1, max, list);
        }
        return;
    }
}