import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int robotCnt = routes.length;
    int inRobotCnt = robotCnt;

    List<int[]>[] robotRoutes = new ArrayList[robotCnt];
    for (int i = 0; i < robotCnt; i++) {
      robotRoutes[i] = findRobotRoutes(routes[i], points);
    }

    int time = 0;
    int answer = 0;
    while (inRobotCnt > 0) {
      HashMap<Integer, Integer> map = new HashMap<>();
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < robotCnt; i++) {
        if (robotRoutes[i].size() <= time) continue;
        int pos = robotRoutes[i].get(time)[0] * 100 + robotRoutes[i].get(time)[1];
        if (map.containsKey(pos)) {
          map.put(pos, map.get(pos) + 1);
          set.add(pos);
        }
        else map.put(pos, 1);
        if (time == robotRoutes[i].size() - 1) inRobotCnt--;
      }
      answer += set.size();
      time++;
    }
    
    return answer;
  }

  List<int[]> findRobotRoutes(int[] routePoint, int[][] points) {
    int routeCnt = routePoint.length;
    List<int[]> pos = new ArrayList<>();
    pos.add(new int[] {points[routePoint[0]-1][0], points[routePoint[0]-1][1]});


    for (int i = 0; i < routeCnt-1; i++) {
      int curY = points[routePoint[i]-1][0];
      int curX = points[routePoint[i]-1][1];
      int desY = points[routePoint[i+1]-1][0];
      int desX = points[routePoint[i+1]-1][1];


      while (curY != desY || curX != desX) {
        if (curY != desY) {
          if (curY > desY) curY--;
          else curY++;
        } else {
          if (curX > desX) curX--;
          else curX++;
        }
        pos.add(new int[] {curY, curX});
      }
      
    }
    return pos;
  }

  
}