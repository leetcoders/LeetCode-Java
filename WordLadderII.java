/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 29, 2014
 Problem:    Word Ladder II
 Difficulty: High
 Source:     https://oj.leetcode.com/problems/word-ladder-ii/
 Notes:
 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,
 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.

 Solution: BFS + DFS
*/

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(start.compareTo(end) == 0) return res;
        Set<String> visited = new HashSet<String>();
        Set<String> cur = new HashSet<String>();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        graph.put(end,new ArrayList<String>());
        cur.add(start);
        boolean found = false;
        while (cur.isEmpty() == false && found == false) {
            Set<String> queue = new HashSet<String>();
            for(Iterator<String> it=cur.iterator();it.hasNext();) {
                visited.add(it.next());
            }
            for(Iterator<String> it=cur.iterator();it.hasNext();) {
                String str = it.next();
                char[] word = str.toCharArray();
                for (int j = 0; j < word.length; ++j) {
                    char before = word[j];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (ch == before) continue;
                        word[j] = ch;
                        String temp = new String(word);
                        if (dict.contains(temp) == false) continue;
                        if (found == true && end.compareTo(temp) != 0) continue;
                        if (end.compareTo(temp) == 0) {
                            found = true;
                            (graph.get(end)).add(str);
                            continue;
                        }
                        if (visited.contains(temp) == false) {
                            queue.add(temp);
                            if (graph.containsKey(temp) == false) {
                                ArrayList<String> l = new ArrayList<String>();
                                l.add(str);
                                graph.put(temp,l);
                            } else {
                                (graph.get(temp)).add(str);
                            }
                        }
                    }
                    word[j] = before;
                }
            }
            cur = queue;
        }
        if (found == true) {
            ArrayList<String> path = new ArrayList<String>();
            trace(res, graph, path, start, end);
        }
        return res;
    }
    public void trace(List<List<String>> res, 
                    HashMap<String, ArrayList<String>> graph,
                    ArrayList<String> path,
                    String start, String now) {
        path.add(now);
        if (now.compareTo(start) == 0) {
            ArrayList<String> ans = new ArrayList<String>(path);
            Collections.reverse(ans);
            res.add(ans);
            path.remove(path.size()-1);
            return;
        }
        ArrayList<String> cur = graph.get(now);
        for (int i = 0; i < cur.size(); ++i) {
            trace(res,graph,path,start,cur.get(i));
        }
        path.remove(path.size()-1);
    }
}