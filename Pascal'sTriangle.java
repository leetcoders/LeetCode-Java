/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Apr 16, 2013
 Problem:    Pascal's Triangle
 Difficulty: Easy
 Source:     http://leetcode.com/onlinejudge#question_118
 Notes:
 Given numRows, generate the first numRows of Pascal's triangle.
 For example, given numRows = 5,
 Return
 [
      [1],
     [1,1],
    [1,2,1],
   [1,3,3,1],
  [1,4,6,4,1]
 ]

 Solution: .....
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) return res;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        res.add(temp);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> t = new ArrayList<Integer>();
            t.add(1); 
            for (int j = 1; j < i; ++j) {
                t.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            t.add(1);
            res.add(t);
        }
        return res;
    }
}