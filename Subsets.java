/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Nov 18, 2014
 Problem:    Subsets
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/subsets/
 Notes:
 Given a set of distinct integers, S, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:
 [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
 ]

 Solution: 1. Updated Iterative solution.
           2. Updated Recursive solution.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        return subsets_2(S);
    }
    public List<List<Integer>> subsets_1(int[] S) {
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
            path.add(S[i]);
            subsetsRe(S, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsets_2(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; ++i) {
            int sz = res.size();
            for (int j = 0; j < sz; ++j) {
                List<Integer> path = new ArrayList<Integer>(res.get(j));
                path.add(S[i]);
                res.add(path);
            }
        }
        return res;
    }
}