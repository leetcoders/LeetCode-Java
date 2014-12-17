/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 15, 2014
 Problem:    Fraction to Recurring Decimal
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 Notes:
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".

 Solution: ...
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return new String("0");
        boolean flag = (numerator < 0)^(denominator < 0);
        long Numerator = Math.abs((long)numerator);
        long Denominator = Math.abs((long)denominator);
        StringBuffer res = new StringBuffer();
        if (flag == true) res.append('-');
        res.append(String.valueOf((Numerator / Denominator)));
        Numerator = Numerator % Denominator;
        if (Numerator == 0) return res.toString();
        res.append('.');
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = res.length(); Numerator != 0; ++i) {
            if (map.get(Numerator) != null) break;
            map.put(Numerator, i);
            Numerator *= 10;
            res.append(String.valueOf((Numerator / Denominator)));
            Numerator %= Denominator;
        }
        
        if (Numerator == 0) return res.toString();
        res.insert(map.get(Numerator),"(");
        res.append(')');
        return res.toString();
    }
}