import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n)+1);
            else map.put(n, 1);
        }

    
        answer = map.keySet().size();
        if (answer > nums.length / 2) return nums.length / 2;
        return answer;
    }
}