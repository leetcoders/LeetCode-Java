/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 11, 2015
 Problem:    Simplify Path
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/simplify-path/
 Notes:
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 Solution: Add an additional '/' at the end of 'path' for simply detecting the end.
 */
public class Solution {
    public String simplifyPath(String path) {
        if(path.length()==0) return "/";
        if(path.charAt(0)!='/') return "/";
        ArrayList<String> dirs = new ArrayList<String>();
        String[] str = path.split("/");
        for (int i = 0; i < str.length; ++i) {
            if ((i == 0 || i == str.length - 1) && str[i].compareTo("") == 0) continue;
            if (str[i].compareTo("..") == 0) {
                if (dirs.isEmpty() == false) {
                    dirs.remove(dirs.size() - 1);
                }
            } else if ((str[i].compareTo(".") != 0) && (str[i].compareTo("") != 0)) {
                dirs.add(str[i]);
            }
        }
        if (dirs.isEmpty() == true) return "/";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < dirs.size(); ++i) {
            res.append("/");
            res.append(dirs.get(i));
        }
        return res.toString();
    }
}