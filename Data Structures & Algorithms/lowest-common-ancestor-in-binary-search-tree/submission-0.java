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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null) return root;
        if(p.val>q.val) return lowestCommonAncestor(root,q,p);
        if(p.val<=root.val&&root.val<=q.val){
            return root;
        }else{
            if( root.val<=p.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            else{
                return lowestCommonAncestor(root.left,p,q);

            }
        }
         
    }
}
