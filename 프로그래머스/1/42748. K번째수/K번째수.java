import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int tempLength = commands[i][1] - commands[i][0] + 1;
      int[] tempArr = new int[tempLength];
      for (int j = 0; j < tempLength; j++) {
        tempArr[j] = array[commands[i][0] + j - 1];
      }
      Arrays.sort(tempArr);
      answer[i] = tempArr[commands[i][2] - 1];
    }
    return answer;
  }
}