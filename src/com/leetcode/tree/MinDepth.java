package com.leetcode.tree;

public class MinDepth {

    /***
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     * 提示：
     * 树中节点数的范围在 [0, 105] 内
     * -1000 <= Node.val <= 1000
     *
     * 链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //都为null的情况下,自身指向自身
        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

}
