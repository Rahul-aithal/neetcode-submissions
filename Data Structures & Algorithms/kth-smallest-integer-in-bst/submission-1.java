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
    int k = 0;
    List<Integer> inorderArray = new ArrayList<Integer>(); 
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return this.inorderArray.get(k-1);
    }
    public void inorder(TreeNode root) {
       if(root==null) return;
       inorder(root.left);
       this.inorderArray.add(root.val);
              inorder(root.right);

    }
}
