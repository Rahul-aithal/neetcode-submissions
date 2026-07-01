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
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int sum = this.pathSum(root);
        return Math.max(sum,this.max);
    }
    public int pathSum(TreeNode root){
        if(root==null) return 0;
        int leftMax = Math.max(0,pathSum(root.left));
        int rightMax = Math.max(0,pathSum(root.right));
        this.max = Math.max(this.max,leftMax+rightMax+root.val);
        // System.out.println(this.max);
        return root.val+Math.max(leftMax,rightMax);
    }

}
