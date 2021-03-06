package com.leetcode.bits;

public class XorQueriesSubArray {

    /**
     *
     有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

     对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

     并返回一个包含给定查询 queries 所有结果的数组。



     示例 1：

     输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
     输出：[2,7,14,8]
     解释：
     数组中元素的二进制表示形式是：
     1 = 0001
     3 = 0011
     4 = 0100
     8 = 1000
     查询的 XOR 值为：
     [0,1] = 1 xor 3 = 2
     [1,2] = 3 xor 4 = 7
     [0,3] = 1 xor 3 xor 4 xor 8 = 14
     [3,3] = 8
     示例 2：

     输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
     输出：[8,0,4,4]

     解法:
     我们用数组 pre 表示数组 arr 的「前缀异或和」，即
     pre[0] = 0
     pre[i] = arr[0] ^ arr[1] ^ ... ^ arr[i - 1]
     其中 ^ 表示异或（xor）操作。这样以来，当我们要计算 arr[Li] 到 arr[Ri] 的异或值时，我们可以通过


     pre[Li] ^ pre[Ri + 1] = (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[0] ^ ... ^ arr[Ri])
     = (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[Li] ^ ... ^ arr[Ri]) （异或运算的结合律）
     = 0 ^ (arr[Li] ^ ... ^ arr[Ri]) （异或运算的逆运算，即 a ^ a = 0）
     = arr[Li] ^ ... ^ arr[Ri]
     链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray/solution/zi-shu-zu-yi-huo-cha-xun-by-leetcode-solution/

     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length,m=queries.length;
        int[] prefix = new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        int[] ret = new int[m];
        for(int i=0;i<m;i++){
            int start = queries[i][0], end = queries[i][1];
            /*
            当我们要计算 arr[Li] 到 arr[Ri] 的异或值时，我们可以通过
             pre[Li] ^ pre[Ri + 1] = (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[0] ^ ... ^ arr[Ri])
             = (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[0] ^ ... ^ arr[Li - 1]) ^ (arr[Li] ^ ... ^ arr[Ri]) （异或运算的结合律）
             = 0 ^ (arr[Li] ^ ... ^ arr[Ri]) （异或运算的逆运算，即 a ^ a = 0）
             = arr[Li] ^ ... ^ arr[Ri]
             */
            ret[i] = prefix[start] ^ prefix[end+1];
        }
        return ret;
    }
}
