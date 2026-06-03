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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root,int maxSoFar) {
        // base case
        if(root == null) {
            return 0;
        }
        int count = 0;
        //check if curr node good
        if(root.val >= maxSoFar) {
            count++;
        }
        //update maxSOFar
        maxSoFar = Math.max(maxSoFar, root.val);
        //searh L and R
        
        count += dfs(root.left,maxSoFar);
        count += dfs(root.right, maxSoFar);
        

        // return total count

        return count;

        
    }
}
