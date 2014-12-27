/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Permutations
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/permutations/
 Notes:
 Given a collection of numbers, return all possible permutations.
 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 Solution: dfs...
 */
public class Solution {
    public List<List<Integer>> permute_1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] free = new boolean[num.length];
        Arrays.fill(free, true);
        permuteRe(num, res, path,free);
        return res;
    }
    void permuteRe(int[] num, List<List<Integer>> res, List<Integer> path, boolean[] free) {
        if(path.size() == num.length) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(path);
            res.add(tmp);
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if (free[i] == true) {
                free[i] = false;
                path.add(num[i]);
                permuteRe(num, res, path, free);
                path.remove(path.size() - 1);
                free[i] = true;
            }
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
    public List<List<Integer>> permute_2(int[] num) {
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