/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Roman to Integer
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/roman-to-integer/
 Notes:
 Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.

 Solution: use <map> or <unordered_map> (clean)
 */
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();                
        map.put('M', 1000);    
        map.put('D', 500);    
        map.put('C', 100);    
        map.put('L', 50);
        map.put('X', 10);    
        map.put('V', 5);
        map.put('I',1);
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                res -= map.get(s.charAt(i));
            else res += map.get(s.charAt(i));
        }
        return res;
    }
}