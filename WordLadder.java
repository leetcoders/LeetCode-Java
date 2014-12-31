/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Word Ladder
 Difficulty: High
 Source:     https://oj.leetcode.com/problems/word-ladder/
 Notes:
 Given two words (start and end), and a dictionary, find the length of shortest transformation 
 sequence from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,
 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.

 Solution: BFS.
*/
 public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> cur = new LinkedList<String>();
        if(start.compareTo(end) == 0) return 0;
        cur.offer(start);
        int depth = 1;
        Set<String> visited = new HashSet<String>();
        while (cur.isEmpty() == false) {
            Queue<String> queue = new LinkedList<String>();
            while(cur.isEmpty() == false) {
                String str = cur.poll();
                char[] word = str.toCharArray();
                for (int i = 0; i < word.length; ++i) {
                    char before = word[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        word[i] = ch;
                        String temp = new String(word);
                        if (end.compareTo(temp) == 0) return depth + 1;
                        if (dict.contains(temp) == true && visited.contains(temp) == false) {
                            queue.offer(temp);
                            visited.add(temp);
                        }
                    }
                    word[i] = before;
                }
            }
            cur = queue;
            ++depth;
        }
        return 0;
    }
}