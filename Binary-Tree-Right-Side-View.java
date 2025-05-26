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
        List<Integer>ans = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer>list = new ArrayList<>();
            while(n>0){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                list.add(temp.val);
                n--;
            }
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
}