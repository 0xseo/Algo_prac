import java.io.*;
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
    List<String> arr = new ArrayList<>();
    for (int n:numbers) {
      arr.add(String.valueOf(n));
    }
    arr.sort((e1, e2) -> {
      return Integer.parseInt(e2 + e1) - Integer.parseInt(e1 + e2);
    });
    
    for (String s:arr) {
      answer += s;
    }
    if (answer.startsWith("0")) return "0";
    return answer;


    }
}