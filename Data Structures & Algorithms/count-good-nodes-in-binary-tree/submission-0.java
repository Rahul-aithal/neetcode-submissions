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
    int count = 0;
    public int goodNodes(TreeNode root) {
       countGoodNodes(root,Integer.MIN_VALUE);
       return count; 
    }
    public void countGoodNodes(TreeNode root,int largest){
        if(root==null) return;
        if(root.val>=largest) {
            this.count++;
            System.out.println(root.val+","+largest);

            largest = root.val;
        }
        countGoodNodes(root.left,largest);
        countGoodNodes(root.right,largest);
        return;
    }
}
