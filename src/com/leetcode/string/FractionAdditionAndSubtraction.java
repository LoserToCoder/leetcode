package com.leetcode.string;

public class FractionAdditionAndSubtraction {

    /***
     * 给定一个表示分数加减运算的字符串expression，你需要返回一个字符串形式的计算结果。
     *
     * 这个结果应该是不可约分的分数，即最简分数。如果最终结果是一个整数，
     * 例如2，你需要将它转换成分数形式，其分母为1。所以在上述例子中, 2应该被转换为2/1。
     *
     *
     * 示例1:
     * 输入:expression= "-1/2+1/2"
     * 输出: "0/1"
     *
     * 示例 2:
     * 输入:expression= "-1/2+1/2+1/3"
     * 输出: "1/3"
     *
     * 示例 3:
     * 输入:expression= "1/3-1/2"
     * 输出: "-1/6"
     *
     * 提示:
     *
     * 输入和输出字符串只包含'0' 到'9'的数字，以及'/', '+' 和'-'。
     * 输入和输出分数格式均为±分子/分母。如果输入的第一个分数或者输出的分数是正数，则'+'会被省略掉。
     * 输入只包含合法的最简分数，每个分数的分子与分母的范围是[1,10]。如果分母是1，意味着这个分数实际上是一个整数。
     * 输入的分数个数范围是 [1,10]。
     * 最终结果的分子与分母保证是 32 位整数范围内的有效整数
     *
     * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
     * @param expression
     * @return
     */
    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1; //分母,分子
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long numerator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            numerator1 = sign * numerator1;
            index++;

            // 读取分母
            long denominator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            numerator = denominator * numerator1 + denominator1 * numerator;
            denominator *= denominator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator); // 获取最大公约数
        return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
