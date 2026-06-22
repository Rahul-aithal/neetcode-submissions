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
    int dim=0;
    public int diameterOfBinaryTree(TreeNode root) {
         this.check(root);
         return this.dim;
    }

    public  int check(TreeNode root){
        if(root==null) return 0;

        int left = check(root.left);
        int right = check(root.right);

        this.dim = Math.max(this.dim,left+right);

        return Math.max(left,right)+1;
    }
}
