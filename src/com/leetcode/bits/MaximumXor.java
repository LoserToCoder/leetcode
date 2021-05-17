package com.leetcode.bits;

public class MaximumXor {

    /**
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     *
     * 进阶：你可以在 O(n) 的时间解决这个问题吗？
     *
     * 
     *
     * 示例 1：
     *
     * 输入：nums = [3,10,5,25,2,8]
     * 输出：28
     * 解释：最大运算结果是 5 XOR 25 = 28.
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 3：
     *
     * 输入：nums = [2,4]
     * 输出：6
     * 示例 4：
     *
     * 输入：nums = [8,10,2]
     * 输出：10
     * 示例 5：
     *
     * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
     * 输出：127
     * 
     *
     *
     * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     */
    // 字典树的根节点
    private Trie root = new Trie();
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    /**
     * 哈夫曼树的编码思路
     * 利用前缀树, 重合不需要担心,重合也说明最终一定有一个数值存在能构造成这条路径
     *  两两问题: num[i] 放到路径上,num[j]也可以直接去比对。
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }


    class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }

    public static void main(String[] args) {
        int maximumXOR = new MaximumXor().findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70});
        System.out.println(maximumXOR);

    }

}
