import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
    int time = 0;
    PriorityQueue<int[]> waitingQ = new PriorityQueue<int[]>((e1, e2) -> {
      if (e1[2] == e2[2]) {
        if (e1[1] == e2[1]) {
          return e1[0] - e2[0];
        } else return e1[1] - e2[1];
      } else return e1[2] - e2[2];
    });
    PriorityQueue<int[]> reqQ = new PriorityQueue<int[]>((e1, e2) -> {
      return e1[1] - e2[1];
    });
    int curTaskIdx = -1;
    int[][] taskTimeTable = new int[jobs.length][3];
    // [0]: 작업시작시각, [1]: 작업종료시각, [2]: 요청시각

    for (int i = 0; i < jobs.length; i++) {
      reqQ.add(new int[] {i, jobs[i][0], jobs[i][1]});
    }

    while (true) {
      if (curTaskIdx == -1 && waitingQ.isEmpty() && reqQ.isEmpty()) break;
      
      // 현재 시점에서 새로운 요청 있는지 확인
      while (!reqQ.isEmpty() && reqQ.peek()[1] == time) {
        waitingQ.add(new int[] {reqQ.peek()[0], reqQ.peek()[1], reqQ.peek()[2]});
        taskTimeTable[reqQ.peek()[0]][2] = time;
        reqQ.poll();
      }

      // 현재 task 종료 여부 확인
      if (curTaskIdx == -1 || time == taskTimeTable[curTaskIdx][1]) {
        
        // 우선순위에 따라서 task 선택
        if (waitingQ.isEmpty()) curTaskIdx = -1;
        else {
          curTaskIdx = waitingQ.peek()[0];
          taskTimeTable[curTaskIdx][0] = time;
          taskTimeTable[curTaskIdx][1] = time + waitingQ.peek()[2];
          waitingQ.poll();
        }
      }
      time++;
    }

    int totalRunTime = 0;
    for (int i = 0; i < jobs.length; i++) {
      totalRunTime += taskTimeTable[i][1] - taskTimeTable[i][2];
    }

    return totalRunTime / jobs.length;
    }
}