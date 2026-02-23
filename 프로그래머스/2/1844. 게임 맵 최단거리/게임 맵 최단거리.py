from collections import deque
def solution(maps):
    inf = 9e9
    n = len(maps)
    m = len(maps[0])
    
    q = deque()
    q.append([1, 1, 1])
    visited = [[inf] * (m+1) for _ in range(n+1)]
    visited[1][1] = 1
    
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    
    while q:
        y, x, cost = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 >= ny or ny > n or 0 >= nx or nx > m:
                continue
            
            if maps[ny-1][nx-1] == 1:
                if visited[ny][nx] > cost+1:
                    visited[ny][nx] = cost+1
                    q.append([ny, nx, cost+1])
                        
    if visited[n][m] < inf:
        return visited[n][m]
    return -1
    