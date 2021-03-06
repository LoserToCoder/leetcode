package com.leetcode.map;

import java.util.Arrays;
import java.util.HashMap;

/**
 给定两个数组，编写一个函数来计算它们的交集。
 示例 1:
 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2,2]
 示例 2:
 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [4,9]
 说明：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。
 进阶:
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果nums1的大小比nums2小很多，哪种方法更优？
 如果nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //调整参数顺序(按照指定条件来排顺序),简化编码,比如第一个参数最小,依次递增
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {

        
    }
}
