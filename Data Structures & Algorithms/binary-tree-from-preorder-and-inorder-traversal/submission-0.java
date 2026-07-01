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
    TreeNode dummy = new TreeNode();
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int pre_s, int pre_e, int in_s, int in_e) {
        if (pre_s > pre_e || in_s > in_e)
            return null;
        TreeNode root = new TreeNode(preorder[pre_s]);
        int root_idx = this.map.get(root.val);
        int dist = root_idx - in_s;
        root.left = build(preorder, pre_s + 1, pre_s + dist, in_s, root_idx - 1);
        root.right = build(preorder, pre_s + dist + 1, pre_e, root_idx + 1, in_e);
        return root;
    }
}
