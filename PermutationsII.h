/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Permutations II
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/permutations-ii/
 Notes:
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].

 Solution: dfs...
 */
 public class Solution {
    public List<List<Integer>> permuteUnique_1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        Arrays.fill(visited, false);
        permuteRe(num, res, path,visited);
        return res;
    }
    void permuteRe(int[] num, List<List<Integer>> res, List<Integer> path, boolean[] visited) {
        if(path.size() == num.length) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(path);
            res.add(tmp);
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if(visited[i]||(i!=0&&num[i-1]==num[i]&&visited[i-1])) continue;
            visited[i] = true;
            path.add(num[i]);
            permuteRe(num, res, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    public boolean nextPermutation(int[] num) {
        int last = num.length - 1;
        int i = last;
        while (i > 0 && num[i - 1] >= num [i]) --i;
        for (int l = i, r = last; l < r; ++l, --r) {
            num[l] = num[l] ^ num[r];
            num[r] = num[l] ^ num[r];
            num[l] = num[l] ^ num[r];
        }
        if (i == 0) {
            return false;
        }
        int j = i;
        while (j <= last && num[i-1] >= num[j]) ++j;
        num[i-1] = num[i-1] ^ num[j];
        num[j] = num[i-1] ^ num[j];
        num[i-1] = num[i-1] ^ num[j];
        return true;
    }
    public List<List<Integer>> permuteUnique_2(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        do {
            List<Integer> path = new ArrayList<Integer>();
            for (int i : num) path.add(i);
            res.add(path);
        } while(nextPermutation(num));
        return res;
    }
}