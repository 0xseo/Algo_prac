from collections import deque
import heapq
def solution(land, height):
    N = len(land)
    ladders = []
    cost = 0
    
    visited = [[0] * N for i in range(N)]
    visited[0][0] = 1
    
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    
    q = deque([(0, 0)])
    
    while q or ladders:
        if q:
            y, x= q.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < N and 0 <= nx < N:
                    if visited[ny][nx] == 0:
                        if abs(land[ny][nx] - land[y][x]) <= height:
                            visited[ny][nx] = 1
                            q.append((ny, nx))
                        else:
                            heapq.heappush(ladders, (abs(land[ny][nx] - land[y][x]), (y, x), (ny, nx)))
                            
        else:
            money, (beforeY, beforeX), (nextY, nextX) = heapq.heappop(ladders)
            if visited[nextY][nextX] == 0:
                # print(beforeY, beforeX, nextY, nextX)
                cost += money
                visited[nextY][nextX] = 1
                q.append((nextY, nextX))
    # print(cost)
    # print(visited)
    return cost
            
        