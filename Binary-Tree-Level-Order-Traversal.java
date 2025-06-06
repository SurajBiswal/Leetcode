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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                list.add(node.val);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}