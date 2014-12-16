/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 14, 2014
 Problem:    String to Integer (atoi)
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/string-to-integer-atoi/solution/
 Notes:
 Implement atoi to convert a string to an integer.
 Hint: Carefully consider all possible input cases. If you want a challenge, please do not 
 see below and ask yourself what are the possible input cases.
 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 You are responsible to gather all the input requirements up front.

 Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first 
 non-whitespace character is found. Then, starting from this character, takes an optional
 initial plus or minus sign followed by as many numerical digits as possible, and interprets 
 them as a numerical value.
 The string can contain additional characters after those that form the integral number, which 
 are ignored and have no effect on the behavior of this function.
 If the first sequence of non-whitespace characters in str is not a valid integral number, or 
 if no such sequence exists because either str is empty or it contains only whitespace characters, 
 no conversion is performed.
 If no valid conversion could be performed, a zero value is returned. If the correct value is out 
 of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 Solution: 1. To deal with overflow, inspect the current number before multiplication. 
            If the current number is greater than 214748364, we know it is going to overflow.
            On the other hand, if the current number is equal to 214748364, 
            we know that it will overflow only when the current digit is greater than or equal to 8..
 */

public class Solution {
    public int atoi(String str) {
        if (str == null) return 0;
        int i = 0;
        boolean sign = true;
        str = str.trim();
        int n = str.length();
        if (i < n && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            if (str.charAt(0) == '+') sign = true;
            else sign = false;
            ++i;
        }
        int res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }
            res = res * 10 + str.charAt(i) - 48;
            ++i;
        }
        return sign ? res : -res;
    }
}
