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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode r = q.poll();
            if (r == null) {
                s.append("n"
                    + ",");
                continue;
            }
            s.append(r.val + ",");
            q.offer(r.left);
            q.offer(r.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
    // System.out.println(data.length());
        q.offer(root);
        for (int i = 1; i < s.length; i += 2) {
            TreeNode r = q.poll();
            if (s[i].equals("n")) {
                r.left = null;
            } else {
                r.left = new TreeNode(Integer.parseInt(s[i]));
                q.offer(r.left);
            }
            if (s[i + 1].equals("n")) {
                r.right = null;
            } else {
                r.right = new TreeNode(Integer.parseInt(s[i + 1]));
                q.offer(r.right);
            }
        }
        return root;
    }
}
