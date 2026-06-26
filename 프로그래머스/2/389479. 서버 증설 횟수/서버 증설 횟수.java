import java.util.*;
import java.io.*;
class Server {
    int expsTime; int mainTime;
    Server(int expsTime, int mainTime) {
        this.expsTime = expsTime;
        this.mainTime = mainTime;
    }
    boolean endOrNot(int time) {
        return (time < this.expsTime + this.mainTime - 1);
    }
}
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Server> q = new LinkedList<>();
        
        for (int time = 0; time < 24; time++) {
            if (players[time] > (q.size() + 1) * m - 1) {
                // 서버 증설 필요
                int moreServer = (players[time] - q.size() * m) / m;
                answer += moreServer;
                for (int i = 0; i < moreServer; i++) {
                    q.add(new Server(time, k));
                }
            }
            while (!q.isEmpty() && !q.peek().endOrNot(time)) {
                q.poll();
            }
        }
        
        return answer;
    }
}