from collections import deque
def solution(maps):
    def dfs(start, end, maps):
        
        q = deque()
    
        dirx = [-1, 1, 0, 0]
        diry = [0, 0, -1, 1]
        R = len(maps)
        C = len(maps[0])
        d = [[-1] * C for _ in range(R)]
        d[start[0]][start[1]] = 0

        q.append(((start[0], start[1]), 0))

        while q:
            item = q.popleft()
            y = item[0][0]
            x = item[0][1]
            time = item[1]

            if x == end[1] and y == end[0]:
                continue

            for i in range(4):
                nx = x + dirx[i]
                ny = y + diry[i]
                if nx >= 0 and nx < C and ny >= 0 and ny < R:
                    if maps[ny][nx] != "X":
                        if d[ny][nx] == -1 or d[ny][nx] > time+1:
                            d[ny][nx] = time+1
                            q.append(((ny, nx), time+1))
        return d[end[0]][end[1]]
    for y, rows in enumerate(maps):
        for x, cell in enumerate(rows):
            if cell == "S":
                start = (y, x)
            elif cell == "L":
                lever = (y, x)
            elif cell == "E":
                end = (y, x)
        
    startToLever = dfs(start, lever, maps)
    if startToLever == -1:
        return -1
    leverToEnd = dfs(lever, end, maps)
    if leverToEnd == -1:
        return -1
    return startToLever + leverToEnd
                    
                    

    
