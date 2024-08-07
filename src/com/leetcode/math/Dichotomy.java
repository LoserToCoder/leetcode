package com.leetcode.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Dichotomy {

    /**
     * 描述
     * 计算一个浮点数的立方根，不使用库函数。
     * 保留一位小数。
     *
     * 数据范围：|val| \le 20 \∣val∣≤20
     *
     * 输入描述：
     * 待求解参数，为double类型（一个实数）
     *
     * 输出描述：
     * 输出参数的立方根。保留一位小数。
     */

    //使用类似二分的思路
    public static double Dichotomy(double num) {
        double right , left, mid = 0.0;
        //一定要注意边界条件，输入的num可能是负数  将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
        right = Math.max(1.0,num);
        left = Math.min(-1.0,num);
        while (right - left > 0.001) {
            mid = (left + right) / 2;
            //如果乘积大于num，说明立方根在mid的左侧
            if (mid * mid * mid > num) {
                right = mid;
            }
            //如果乘积小于num，说明立方根在mid的右侧
            else if (mid * mid * mid < num) {
                left = mid;
            } else {
                return mid;
            }
        }
        return right;
    }

}
