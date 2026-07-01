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
    int target = 0;
    int res = -1;
    List<Integer> inorderArray = new ArrayList<Integer>(); 
    public int kthSmallest(TreeNode root, int k) {
        this.target = k;
        inorder(root);
        return this.res;
    }
    public void inorder(TreeNode root) {
       if(root==null) return;
       inorder(root.left);
        this.k++;
        if(target==k){
            this.res = root.val;
            return;
        }
        inorder(root.right);

    }
}
