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
        while(root != null) {
            // compare p.val and q.val to root.val
            
            // both smaller: root = root.left
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
                // both bigger: root = root.right
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else  {
                return root;
            }

            // split or equal: return root
        }
        return null;
    }
}
