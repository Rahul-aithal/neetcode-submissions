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
        List<Integer> visible = new ArrayList<Integer>();
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        while (!s.isEmpty()) {
            int length = s.size();
            TreeNode last = new TreeNode();
            for (int i = 0; i < length; i++) {
                last = s.poll();
                if (last != null) {
                    if (last.left != null)
                        s.offer(last.left);
                    if (last.right != null)
                        s.offer(last.right);
                    if (i == length - 1)
                        visible.add(last.val);
                }
            }
        }
        return visible;
    }
}
