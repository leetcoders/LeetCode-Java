/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Generate Parentheses
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/generate-parentheses/
 Notes:
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 "((()))", "(()())", "(())()", "()(())", "()()()"

 Solution: Place n left '(' and n right ')'.
           Cannot place ')' if there are no enough matching '('.
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        generateParenthesisRe(res, n, n, "");
        return res;
    }
    public void generateParenthesisRe(ArrayList<String> res, int left, int right, String s) {
        if (left == 0 && right == 0)
            res.add(s);
        if (left > 0)
            generateParenthesisRe(res, left - 1, right, s + "(");
        if (right > left)
            generateParenthesisRe(res, left, right - 1, s + ")");
    }
}