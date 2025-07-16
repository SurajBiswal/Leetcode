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
   TreeNode node;
   int pos ;
   public Pair(TreeNode node, int pos){
     this.node = node;
     this.pos = pos;
   }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                int x = p.pos;

                tempMap.putIfAbsent(x, new ArrayList<>());
                tempMap.get(x).add(node.val);

                if (node.left != null) {
                    queue.offer(new Pair(node.left, x - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, x + 1));
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
                int col = entry.getKey();
                List<Integer> nodes = entry.getValue();
                Collections.sort(nodes);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).addAll(nodes);
            }
        }

        for (int col : map.keySet()) {
            result.add(map.get(col));
        }

        return result;
    }
}