from collections import deque
def solution(maps):
    def bfs(start, end):
        inf = 9e9

        sy = start[0]
        sx = start[1]
        ey = end[0]
        ex = end[1]

        dy = [1, -1, 0, 0]
        dx = [0, 0, 1, -1]

        visited = [[inf] * m for i in range(n)]

        q = deque([(sy, sx, 0)])

        while q:
            # print(q)
            y, x, cost = q.popleft()

            if y == ey and x == ex:
                # print(cost)
                return cost
            
            
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < n and 0 <= nx < m:
                    if maps[ny][nx] != 'X':
                        if visited[ny][nx] > cost + 1:
                            visited[ny][nx] = cost + 1
                            q.append((ny, nx, cost + 1))
        # print('bfs', cost)
        return -1

    n = len(maps)
    m = len(maps[0])
    S = (0, 0)
    L = (0, 0)
    E = (0, 0)
    
    for i, string in enumerate(maps):
        if "S" in string:
            S = (i, string.index("S"))
        if "L" in string:
            L = (i, string.index("L"))
        if "E" in string:
            E = (i, string.index("E"))
    
    a = bfs(S, L)
    b = bfs(L, E)
    if a != -1 and b != -1:
        return a + b
    return -1
                    
                   
    
    
