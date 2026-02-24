from collections import deque
def solution(board):
    N = len(board)
    inf = 9e9
    costs = [[[inf] * 4 for i in range(N)] for _ in range(N)]
    
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    direc = ['d', 'u', 'r', 'l']
    
    q = deque()
    q.append((0, 0, -500, ''))
    
    while q:
        y, x, cost, direction = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < N and 0 <= nx < N:
                if board[ny][nx] == 0:
                    if i == direction:
                        c = cost + 100
                    else:
                        c = cost + 600
                    if c < costs[ny][nx][i]:
                        q.append((ny, nx, c, i))
                        costs[ny][nx][i] = c
    return min(costs[N-1][N-1])
    