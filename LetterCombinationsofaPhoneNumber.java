/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Letter Combinations of a Phone Number
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 Notes:
 Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 Solution: ...
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        String[] keyboard = new String[]{" ","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsRe(keyboard,res,digits,"");
        return res;
    }
    public void letterCombinationsRe(String[] keyboard, ArrayList<String> res, String digits, String s) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        String letters = keyboard[digits.charAt(s.length()) - '0'];
        for (int i = 0; i < letters.length(); ++i) {
            letterCombinationsRe(keyboard, res, digits, s+letters.charAt(i));
        }
    }
}