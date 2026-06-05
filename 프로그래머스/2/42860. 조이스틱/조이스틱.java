class Solution {
    public int solution(String name) {
        int answer = 0;
    int minMove = name.length() - 1;
    for (int i = 0; i < name.length(); i++) {
      answer += Math.min(name.charAt(i) - (int) 'A', (int) 'Z' - name.charAt(i) + 1);
      int pointer = i + 1;
      while (pointer < name.length() && name.charAt(pointer) == 'A') pointer++;
      minMove = Math.min(minMove, Math.min(2 * (name.length() - pointer) + i, 2 * i + name.length() - pointer));
    }
    return answer + minMove;
    }
}