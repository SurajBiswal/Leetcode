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
// class Solution {
//     private int node=-1;
//     private int count=0;
//     public int kthSmallest(TreeNode root, int k) {
//         helper(root, k);
//         return node;
//     }

//     public boolean helper(TreeNode root, int k) {
//         if(root==null)return false;
//         helper(root.left, k);
//         ++count;
//         if(k==count){
//             node = root.val;
//             return true;
//         } 
//         helper(root.right, k);
//         return false;
//     }
// }

class Solution {
    public int kthSmallest(TreeNode root, int k) {

    Stack<TreeNode>st=new Stack<>();

    while(root!=null || !st.isEmpty()){
        while(root!=null){
            st.push(root);
            root=root.left;
        }

        root = st.pop();
        k--;
        if(k==0) return root.val;

        root = root.right;
    }
    
    return -1;
    }
}