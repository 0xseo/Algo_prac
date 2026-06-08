import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
    
    int[] vByIdx = new int[number.length()];
    boolean[] removeByIdx = new boolean[number.length()];
    int totLen = number.length();

    for (int i = 0; i < totLen; i++) {
      vByIdx[i] = number.charAt(i) - (int) '0';
      removeByIdx[i] = false;
    }

    int curCnt = 0;
    for (int i = 0; i < totLen - k + curCnt; i++) {
      int firstV = vByIdx[i];
      for (int j = 1; j <= k - curCnt; j++) {
        if (firstV < vByIdx[i + j]) {
          removeByIdx[i] = true;
          curCnt++;
          break;
        }
      }
    }

    for (int i = 0; i < totLen; i++) {
      if (!removeByIdx[i]) {
          if (vByIdx[i] == 0 && answer.length() == 0) continue;
          answer += number.charAt(i);
      }
    }

    if (answer.charAt(0) == '0') return "0";
        if (answer.length() > totLen - k) {
      return answer.substring(0, totLen - k);
    }
    return answer;
    }
}