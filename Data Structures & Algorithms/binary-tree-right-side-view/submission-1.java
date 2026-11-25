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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return res;
        }

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size-1; i++) {
                TreeNode curr=q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            TreeNode last = q.poll();
            res.add(last.val);
            if(last.left != null){
                q.offer(last.left);
            }

            if(last.right != null){
                q.offer(last.right);
            }
        }

        return res;
    }
}
