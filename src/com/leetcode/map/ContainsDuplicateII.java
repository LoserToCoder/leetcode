package com.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    /**
     * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的绝对值最大为 k。
     * 示例1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Integer j=map.get(nums[i]);
                if(i-j<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII duplicateII = new ContainsDuplicateII();
        System.out.println(duplicateII.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
