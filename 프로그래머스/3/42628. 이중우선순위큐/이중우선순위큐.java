import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);

    HashMap<Integer, Integer> map = new HashMap<>();

    for (String cmd : operations) {
      if (cmd.startsWith("I")) {
        int num = Integer.parseInt(cmd.substring(2));
        minHeap.add(num);
        maxHeap.add(num);

        if (map.containsKey(num)) map.put(num, map.get(num) + 1);
        else map.put(num, 1);
      }
      else if (cmd.equals("D 1")) {
        while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
          maxHeap.poll();
        }
        if (!maxHeap.isEmpty()) {
          map.put(maxHeap.peek(), map.get(maxHeap.peek()) - 1);
          maxHeap.poll();
        }
      } else {
        while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
          minHeap.poll();
        }
        if (!minHeap.isEmpty()) {
          map.put(minHeap.peek(), map.get(minHeap.peek()) - 1);
          minHeap.poll();
        }
      }
        
      
    }
        while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
      maxHeap.poll();
    }
    while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
      minHeap.poll();
    }
    if (maxHeap.isEmpty()) return answer;
    else {
      answer[0] = maxHeap.peek();
      answer[1] = minHeap.peek();
      return answer;
    }
    }
}