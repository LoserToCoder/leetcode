package com.leetcode.tree;

public class PruneTree {

    /**
     * 给你二叉树的根结点root，此外树的每个结点的值要么是 0 ，要么是 1 。
     * 返回移除了所有不包含 1 的子树的原二叉树。
     * 节点 node 的子树为 node 本身加上所有 node 的后代。
     *
     * 示例 1：
     * 输入：root = [1,null,0,0,1]
     * 输出：[1,null,0,null,1]
     * 解释：
     * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
     * 示例 2：
     * 输入：root = [1,0,1,0,0,0,1]
     * 输出：[1,null,1,null,1]
     * 示例 3：
     *
     *
     * 输入：root = [1,1,0,1,1,0,1,0]
     * 输出：[1,1,0,1,1,null,1]
     *  
     *
     * 提示：
     *
     * 树中节点的数目在范围 [1, 200] 内
     * Node.val 为 0 或 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-pruning
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root) ? root:null;
    }

    private boolean dfs(TreeNode node){
        if(node==null) return false;
        boolean leftLeaf = dfs(node.left);
        boolean rightLeaf = dfs(node.right);
        if(!leftLeaf) node.left = null;
        if(!rightLeaf) node.right = null;
        return node.val==1||leftLeaf||rightLeaf;
    }
}
