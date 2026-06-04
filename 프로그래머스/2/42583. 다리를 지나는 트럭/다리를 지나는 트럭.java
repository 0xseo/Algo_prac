import java.util.*;
import java.io.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
    int cur_weight = 0;

    Queue<Integer> waitingQ = new LinkedList<Integer>();
    for (int car: truck_weights) {
      waitingQ.add(car);
    }
    Queue<int[]> inBridgeQ = new LinkedList<int[]>();
    // {[0] 나갈 수 있는 시간, [1] 무게}
    

    while (true) {
      time++;
      // 나갈 수 있는 차가 있으면 내보내기
      if (!inBridgeQ.isEmpty() && inBridgeQ.peek()[0] == time) {
        cur_weight -= inBridgeQ.peek()[1];
        inBridgeQ.poll();
      }
      
      // 들어올 수 있는 차가 있으면 들여보내기
      if (!waitingQ.isEmpty() && cur_weight + waitingQ.peek() <= weight) {
        // 한 대 더 들어올 수 있음
        cur_weight += waitingQ.peek();
        inBridgeQ.add(new int[] {time + bridge_length, waitingQ.peek()});
        
        waitingQ.poll();
      }
      if (waitingQ.isEmpty() && inBridgeQ.isEmpty()) break;
    }
    return time;
    }
}