class Pair {
    int col;
    int row;
    TreeNode node;
    public Pair(TreeNode node, int col, int row) {
        this.col = col;
        this.row = row;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int col = pair.col;
            int row = pair.row;
            TreeNode node = pair.node;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null) queue.offer(new Pair(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1, row + 1));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> vals : rows.values()) {
                Collections.sort(vals); // keep same (x,y) sorted
                colList.addAll(vals);
            }
            list.add(colList);
        }
        return list;
    }
}
