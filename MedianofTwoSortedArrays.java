/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 12, 2014
 Problem:    Median of Two Sorted Arrays
 Difficulty: Hard
 Source:     http://leetcode.com/onlinejudge#question_4
 Notes:
 There are two sorted arrays A and B of size m and n respectively. 
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Solution: 1. O(m+n)
           2. O(log(m+n))
*/

public class Solution {
    public double findMedianSortedArrays_1(int A[], int B[]) {
        int m = A.length, n = B.length;
        int total = n + m, m1=0, m2=0, i=0, j=0;
        for (int k = 1; k <= total/2 + 1; ++k) {
            int a = (i==m) ? Integer.MAX_VALUE : A[i];
            int b = (j==n) ? Integer.MAX_VALUE : B[j];
            m1 = m2;
            m2 = Math.min(a,b);
            if (a > b) ++j;
            else ++i;
        }
        if ((total&1) == 1) return m2;
        else return (m1+m2)/2.0;
    }
    public double findMedianSortedArrays_2(int A[], int B[]) {
        int m = A.length, n = B.length;
        int total = m + n;
        int k = total / 2;
        if ((total&1) == 1) return findKth(A,B,k+1,0,m-1,0,n-1);
        else return (findKth(A,B,k,0,m-1,0,n-1)+findKth(A,B,k+1,0,m-1,0,n-1))/2.0;
    }
    public double findKth(int A[], int B[], int k, int astart, int aend, int bstart, int bend) {
        int alen = aend - astart + 1;
        int blen = bend - bstart + 1;
        if (alen > blen) return findKth(B,A,k, bstart, bend, astart, aend);
        if (alen == 0) return B[bstart + k - 1];
        if (k == 1) return Math.min(A[astart],B[bstart]);
        int sa = Math.min(alen, k/2), sb = k- sa;
        if (A[astart+sa-1] == B[bstart+sb-1]) return A[astart+sa-1];
        else if (A[astart+sa-1] > B[bstart+sb-1]) return findKth(A,B,k - sb,astart,aend,bstart+sb,bend);
        else return findKth(A,B,k - sa,astart+sa,aend,bstart,bend);
    }
    
}
