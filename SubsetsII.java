/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Nov 18, 2014
 Problem:    Subsets II
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/subsets-ii/
 Notes:
 Given a collection of integers that might contain duplicates, S, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:
 [
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
 ]

 Solution: ..Similar to Subset I.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        return subsetsWithDup_2(S);
    }
    public List<List<Integer>> subsetsWithDup_1(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        subsetsRe(S, 0, path, res);
        return res;
    }
    void subsetsRe(int[] S, int start, List<Integer> path, List<List<Integer>> res) {
        List<Integer> sub = new ArrayList<Integer>(path);
        res.add(sub);
        for (int i = start; i < S.length; ++i) {
            if (i != start && S[i] == S[i-1]) continue;
            path.add(S[i]);
            subsetsRe(S, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup_2(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        int presz = 0;
        for (int i = 0; i < S.length; ++i) {
            int sz = res.size();
            for (int j = 0; j < sz; ++j) {
                if (i == 0 || S[i] != S[i-1] || j >= presz) {
                    List<Integer> path = new ArrayList<Integer>(res.get(j));
                    path.add(S[i]);
                    res.add(path);
                }
            }
            presz = sz;
        }
        return res;
    }
}