/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Dec 20, 2014
 Problem:    Longest Valid Parentheses
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/longest-valid-parentheses/
 Notes:
 Given a string containing just the characters '(' and ')', find the length of the longest valid 
 (well-formed) parentheses substring.
 For "(()", the longest valid parentheses substring is "()", which has length = 2.
 Another example is ")()())", where the longest valid parentheses substring is "()()", 
 which has length = 4.

 Solution: O(n).
 */

public class Solution {
    public int longestValidParentheses_1(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int res = 0, count = 0;
        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stk.push(count);
                count = 0;
            } else if (stk.empty() == false) {
                count += (1 + stk.pop());
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res * 2;
    }
    public int longestValidParentheses_2(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int res = 0;
        int[] f = new int[n];
        for(int i=n-2;i>=0;i--){
            int match = i + f[i+1] + 1;
            if(match<n&&s.charAt(i)=='('&&s.charAt(match)==')'){
                f[i]=f[i+1]+2;
                if(match+1<n) f[i]+=f[match+1];
            }
            res = Math.max(res,f[i]);
        }
        return res;
    }
    public int longestValidParentheses(String s) {
        int counter = 0, val = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            counter += s.charAt(i) == '(' ? 1 : -1;
            if (counter < 0) {
                val = counter = 0;
                continue;
            }
            val += s.charAt(i) == '(' ? 0 : 2;
            res = counter == 0 ? Math.max(res, val) : res;
        }
        val = counter = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            counter += s.charAt(i) == ')' ? 1 : -1;
            if (counter < 0) {
                val = counter = 0;
                continue;
            }
            val += s.charAt(i) == ')' ? 0 : 2;
            res = counter == 0 ? Math.max(res, val) : res;
        }
        return res;
    }
}



