import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        
        int p1 = 0;
        int p2 = 0;
        int tempSum = sequence[0];
        int n = sequence.length;
        
        while (p1 < n && p2 < n) {
            if (p1 == p2) {
                if (tempSum == k) {
                    return new int[] {p1, p2};
                } else if (tempSum < k) {
                    if (p2+1==n) break;
                    tempSum += sequence[++p2];
                } else {
                    if (p1+1==n) break;
                    tempSum = sequence[++p1]; p2++;
                }
            } else {
                if (tempSum == k) {
                    pq.add(new int[] {p2 - p1, p1, p2});
                    if (p2+1==n) break;
                    tempSum = tempSum - sequence[p1++] + sequence[++p2];
                } else if (tempSum < k) {
                    if (p2+1==n) break;
                    tempSum += sequence[++p2];
                } else {
                    tempSum -= sequence[p1++];
                }
            }
        }
        int[] answer = {pq.peek()[1], pq.peek()[2]};
        return answer;
    }
}