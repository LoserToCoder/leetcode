package com.leetcode.binary;

public class SearchInsertPosition {

    /**
     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     你可以假设数组中无重复元素。
     示例 1:
     输入: [1,3,5,6], 5
     输出: 2
     示例 2:
     输入: [1,3,5,6], 2
     输出: 1
     示例 3:
     输入: [1,3,5,6], 7
     输出: 4
     示例 4:
     输入: [1,3,5,6], 0
     链接：https://leetcode-cn.com/problems/search-insert-position
     */
    public int searchInsert(int[] nums, int target) {
       int len=nums.length;
       int low=0;
       int high=len-1;
       int middle;
       while(low<=high){
         middle=(low+high)>>1;
         if(target==nums[middle]){
            return middle;
         }else if(target<nums[middle]){
            high=middle-1;
         }else{
            low=middle+1;
         }
       }
       if(high<0) return 0;
       return low;
    }

    public static void main(String[] args) {

    }


}
