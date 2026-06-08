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
import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            int isLeft = d[2];

            nodes.putIfAbsent(p, new TreeNode(p));
            nodes.putIfAbsent(c, new TreeNode(c));
            if (isLeft == 1) {
                nodes.get(p).left = nodes.get(c);
            } else {
                nodes.get(p).right = nodes.get(c);
            }
            parent.put(c, p);
        }
        for (int val : nodes.keySet()) {
            if (!parent.containsKey(val)) {
                return nodes.get(val);
            }
        }
        return null;
    }
}