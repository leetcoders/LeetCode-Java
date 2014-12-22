/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Substring with Concatenation of All Words
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 Notes:
 You are given a string, S, and a list of words, L, that are all of the same length. Find all 
 starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
 and without any intervening characters.
 For example, given:
 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).

 Solution: ...
*/
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if(L.length==0 || S==null || S.length()==0) return res;
        int M = S.length(), N = L.length;
        int K = L[0].length();
        HashMap<String, Integer> need = new HashMap<String, Integer>();
        for(String str: L) {
            if(need.containsKey(str)) {
                need.put(str, need.get(str)+1);
            } else {
                need.put(str, 1);
            }
        }
        for (int i = 0; i <= M - N*K; ++i) {
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            int j = 0;
            for (j = 0; j < N; ++j) {
                String s = S.substring(i + j * K, i + (j+1) * K);
                if (need.containsKey(s) == false) break;
                if (found.containsKey(s) == true) {
                    if (need.get(s) <= found.get(s)) break;
                    found.put(s, found.get(s)+1);
                } else found.put(s, 1);
            }
            if (j == N) res.add(i);
        }
        return res;
    }
}