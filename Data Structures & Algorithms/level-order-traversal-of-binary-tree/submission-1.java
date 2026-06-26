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
    List<List<Integer>> order;
    public List<List<Integer>> levelOrder(TreeNode root) {
        int len = this.getLevel(root, 1);
        // System.out.println(len);
        this.order = new ArrayList<List<Integer>>(len);
        for (int i = 0; i < len; i++) {
            List<Integer> value = new ArrayList<Integer>();
            this.order.add(i, value);
        }

        this.travers(root, 0);
        return this.order;
    }
    public int getLevel(TreeNode root, int len) {
        if (root == null)
            return 0;
        int leftLen = getLevel(root.left, len);
        int rightLen = getLevel(root.right, len);
        return len + Math.max(leftLen, rightLen);
    }
    public void travers(TreeNode root, int level) {
        if (root == null)
            return;
        this.order.get(level).add(root.val);

        // this.order.add(level, values);

        travers(root.left, level + 1);
        travers(root.right, level + 1);

        return;
    }
}
