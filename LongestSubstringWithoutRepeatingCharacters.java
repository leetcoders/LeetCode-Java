/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Dec 12, 2014
 Problem:    Longest Substring Without Repeating Characters
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 Notes:
 Given a string, find the length of the longest substring without repeating characters. 
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 For "bbbbb" the longest substring is "b", with the length of 1.

 Solution: 1. Pay attention when moving the 'start' pointer forward.
           2. More space, but maybe faster.
 */
public class Solution {
    public int lengthOfLongestSubstring_1(String s) {
        boolean[] hash = new boolean[256];
        Arrays.fill(hash,false);
        int n = s.length();
        if (n <= 1) return n;
        int start = 0, end = 0, res = 0;
        while (end < n && start + res < n) {
            if (hash[s.charAt(end)] == false) {
                hash[s.charAt(end++)] = true;
            } else {
                hash[s.charAt(start++)] = false;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
    public int lengthOfLongestSubstring_2(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int n = s.length();
        if (n <= 1) return n;
        hash[s.charAt(0)] = 0;
        int start = 0, res = 1, cur = 0;
        while (++cur < n) {
            if (hash[s.charAt(cur)] >= start) {
                start = hash[s.charAt(cur)] + 1;
            }
            res = Math.max(res, cur - start + 1);
            hash[s.charAt(cur)] = cur;
        }
        return res;
    }
}
