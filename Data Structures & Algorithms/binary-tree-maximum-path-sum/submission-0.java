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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        // intitialize maxSum
        maxSum = Integer.MIN_VALUE;
        // call dfs(root)
        dfs(root);
        // return maxSum

        return maxSum;
    }

    private int dfs(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }

        // get best left path
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        // get best rigth path

        //ignore negative paths

        // update global max using:
        // left + root.val + rigth

        maxSum = Math.max(maxSum, left + right + root.val);

        //return to parent: 

        // root.val + max(left, right)
        return root.val + Math.max(left,right);
    }
}
