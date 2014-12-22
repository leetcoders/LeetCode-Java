/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Combinations
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/combinations/
 Notes:
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
 [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
 ]

 Solution: DFS.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combineRe(n, k, 1, path, res);
        return res;
    }
    void combineRe(int n, int k, int start, ArrayList<Integer> path, List<List<Integer>> res){
        int m = path.size();
        if (m == k) {
            ArrayList<Integer> p = new ArrayList<Integer>(path);
            res.add(p);
            return;
        }
        for (int i = start; i <= n-(k-m)+1; ++i) {
            path.add(i);
            combineRe(n,k,i+1, path, res);
            path.remove(path.size() - 1);
        }
    }
}